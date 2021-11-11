package objects;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.ReplaceOptions;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import managers.DatabaseManager;
import org.bson.Document;
import utils.json.JsonConversion;

import java.util.*;
import java.util.stream.Collectors;

@Getter @Setter
@AllArgsConstructor
public class Student {

    Gson gson = new Gson();

    private final Gson GSON = new Gson();
    private static Map<UUID, Student> students = new HashMap<UUID, Student>();

    private final UUID uuid;
    private String firstName, middleName, lastName, username, password, position;
    private int security;

    private List<Grades> grades;

    public Student(String first_name, String middle_name, String last_name, String username, String password, String position, int security){
        this.uuid = UUID.randomUUID();
        this.firstName = first_name;
        this.middleName = middle_name;
        this.lastName = last_name;
        this.username = username;
        this.password = password;
        this.position = position;
        this.security = security;
        this.grades = new ArrayList<>();
    }

    public Student(UUID uuid, String first_name, String middle_name, String last_name, String username, String password, String position, int security, ArrayList<Grades> grades) {
        this.uuid = uuid;
        this.firstName = first_name;
        this.middleName = middle_name;
        this.lastName = last_name;
        this.username = username;
        this.password = password;
        this.position = position;
        this.security = security;
        this.grades = grades;
    }

    public Student(String first_name, String middle_name, String last_name, String username, String password, String position, int security, ArrayList<Grades> grades) {
        this.uuid = UUID.randomUUID();
        this.firstName = first_name;
        this.middleName = middle_name;
        this.lastName = last_name;
        this.username = username;
        this.password = password;
        this.position = position;
        this.security = security;
        this.grades = grades;
    }

    /**
     * Initializes the student objects in the map
     */
    public static void initialize() {
        try (MongoCursor<Document> cursor = DatabaseManager.getCollection("Students").find().iterator()) {
            while (cursor.hasNext()) {
                Document document = cursor.next();

                List<Grades> gradesList = new ArrayList<>();
                if(document.getString("grades") != null) {
                    List<JsonObject> stringList = JsonConversion.toJsonList(document.getString("grades"));
                    stringList.forEach(value -> {
                        gradesList.add((Grades) Grades.DESERIALIZER.deserialize(value));
                    });
                }

                Student student = new Student(
                        UUID.fromString(document.getString("uuid")),
                        document.getString("firstName"),
                        document.getString("middleName"),
                        document.getString("lastName"),
                        document.getString("username"),
                        document.getString("password"),
                        document.getString("position"),
                        document.getInteger("security"),
                        (ArrayList<Grades>) gradesList);
                students.put(student.getUuid(), student);
            }
        }
        getDefaultStudent();
    }

    /**
     * Saves the student object to the database
     */
    public void save() {
        List<JsonObject> objects = grades.stream().map(Grades.SERIALIZER::serialize).collect(Collectors.toList());

        Document document = new Document();
        document.put("uuid", uuid.toString());
        document.put("firstName", firstName);
        document.put("middleName", middleName);
        document.put("lastName", lastName);
        document.put("username", username);
        document.put("password", password);
        document.put("position", position);
        document.put("security", security);
        document.put("grades", gson.toJson(objects));
        DatabaseManager.getCollection("Students").replaceOne(Filters.eq("uuid", uuid.toString()), document, new ReplaceOptions().upsert(true));
    }

    /**
     * Searches the database for a user with the given username
     *
     * @param username The requested username
     * @return         The object of the requested user if they exist in the database
     */
    public static Student getByUsername(String username) {
        for (Student student : students.values()) if (student.getUsername().equals(username)) return student;
        return null;
    }

    /**
     * Removes a given user from the database
     */
    public void remove() {
        DatabaseManager.getCollection("Students").deleteOne(Filters.eq("uuid", uuid.toString()));
        students.remove(uuid);
    }

    /**
     * Generates a default student object if none exist in the database
     */
    public static void getDefaultStudent() {
        if (students.isEmpty()) {

            Student student = new Student("Default", "Test", "Student", "student0001", "test123", "Student", 1);
            student.save();

            students.put(student.getUuid(), student);
        }
    }

    public void addGrade(Grades g) {
        grades.add(g);
    }

    public void updateMarks(UUID uuid, List<Integer> marks) {

        for (Grades g : grades) {
            if (g.getCourseUUID().toString().equals(uuid.toString())) {
                g.setGrades(marks);
            }
        }
    }
}
