package tech.lpdev.objects;

import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.ReplaceOptions;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import tech.lpdev.managers.DatabaseManager;
import org.bson.Document;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Getter @Setter
@AllArgsConstructor
public class  Staff {

    public static Map<UUID, Staff> staffMembers = new HashMap<>();

    private final UUID uuid;
    private String firstName, middleName, lastName, username, password, position;
    private int security;

    /**
     * Creates new staff object
     *
     * @param first_name  value for the users first name
     * @param middle_name value for the users middle name
     * @param last_name   value for the users last name
     * @param username    value for the users username
     * @param password    value for the users password
     * @param position    value for the users position
     * @param security    value for the users security level
     */
    public Staff(String first_name, String middle_name, String last_name, String username, String password, String position, int security) {
        this.uuid = UUID.randomUUID();
        this.firstName = first_name;
        this.middleName = middle_name;
        this.lastName = last_name;
        this.username = username;
        this.password = password;
        this.position = position;
        this.security = security;
    }

    /**
     * Initializes the staff objects in the map
     */
    public static void initialize() {
        try (MongoCursor<Document> cursor = DatabaseManager.getCollection("Staff").find().iterator()) {
            while (cursor.hasNext()) {
                Document document = cursor.next();
                Staff staff = new Staff(
                        UUID.fromString(document.getString("uuid")),
                        document.getString("firstName"),
                        document.getString("middleName"),
                        document.getString("lastName"),
                        document.getString("username"),
                        document.getString("password"),
                        document.getString("position"),
                        document.getInteger("security"));
                staffMembers.put(staff.getUuid(), staff);
            }
        }
        createDefaultStaff();
    }

    /**
     * Saves the student object to the database
     */
    public void save() {
        Document document = new Document();
        document.put("uuid", uuid.toString());
        document.put("firstName", firstName);
        document.put("middleName", middleName);
        document.put("lastName", lastName);
        document.put("username", username);
        document.put("password", password);
        document.put("position", position);
        document.put("security", security);
        DatabaseManager.getCollection("Staff").replaceOne(Filters.eq("uuid", uuid.toString()), document, new ReplaceOptions().upsert(true));
    }

    /**
     * Searches the database for a user with the given username
     *
     * @param username The requested username
     * @return         The object of the requested user if they exist in the database
     */
    public static Staff getByUsername(String username) {
        for (Staff staff : staffMembers.values()) if (staff.getUsername().equals(username)) return staff;
        return null;
    }

    public static Staff getByUUID(UUID uuid) {
        return staffMembers.get(uuid);
    }

    /**
     * Removes a given user from the database
     */
    public void remove() {
        DatabaseManager.getCollection("Staff").deleteOne(Filters.eq("uuid", uuid.toString()));
        staffMembers.remove(uuid);
    }

    /**
     * Generates a default student object if none exist in the database
     */
    private static void createDefaultStaff() {
        if (staffMembers.isEmpty()) {
            // Updating database info
            Staff staff = new Staff("System", null, "Admin", "Admin", "toor", "Administrator", 4);
            staff.save();
            //
            staffMembers.put(staff.getUuid(), staff);
        }
    }
}
