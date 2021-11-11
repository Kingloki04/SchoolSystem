package objects;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.ReplaceOptions;
import lombok.Data;

import managers.DatabaseManager;
import org.bson.Document;
import utils.json.JsonConversion;

import java.util.*;
import java.util.stream.Collectors;

@Data
public class Course {

    private final Gson gson = new Gson();

    public static Map<UUID, Course> CACHE = new HashMap<>();

    private UUID uuid;
    private String name, code;
    private Staff teacher;
    private List<Unit> units;

    public Course(String name, String code, Staff teacher) {
        this.uuid = UUID.randomUUID();
        this.name = name;
        this.code = code;
        this.teacher = teacher;
        this.units = new ArrayList<>();
    }

    public Course(UUID uuid, String name, String code, Staff teacher, List<Unit> units) {
        this.uuid = uuid;
        this.name = name;
        this.code = code;
        this.teacher = teacher;
        this.units = units;
    }

    public static void initialize() {
        try (MongoCursor<Document> cursor = DatabaseManager.getCollection("Courses").find().iterator()) {
            while (cursor.hasNext()) {
                Document document = cursor.next();

                List<Unit> unitList = new ArrayList<>();
                if (document.get("units") != null) {
                    List<JsonObject> stringList = JsonConversion.toJsonList(document.getString("units"));
                    stringList.forEach(value -> {
                        unitList.add((Unit) Unit.DESERIALIZER.deserialize(value));
                    });
                }

                Course course = new Course(
                        UUID.fromString(document.getString("uuid")),
                        document.getString("name"),
                        document.getString("code"),
                        Staff.getByUUID(UUID.fromString(document.getString("teacher"))),
                        unitList
                );
                if (course.getTeacher() == null) System.out.println("Teacher not found");
                CACHE.put(course.getUuid(), course);
            }
        }
    }

    public Document getDocument() {
        Document document = new Document();
        List<JsonObject> objects = units.stream().map(Unit.SERIALIZER::serialize).collect(Collectors.toList());

        document.put("uuid", this.uuid.toString());
        document.put("name", this.name);
        document.put("code", this.code);
        document.put("teacher", this.teacher.getUuid().toString());
        document.put("units", gson.toJson(objects));

        return document;
    }

    public void save() {
        DatabaseManager.getCollection("Courses").replaceOne(Filters.eq("uuid", uuid.toString()), getDocument() , new ReplaceOptions().upsert(true));
    }

    public static Course getByName(String name, Staff staff) {
        for (Course c : CACHE.values()) if (c.getName().equalsIgnoreCase(name)) return c;
        return null;
    }

    public static Course getByCode(String code, Staff staff) {
        for (Course c : CACHE.values()) if (c.getCode().equalsIgnoreCase(code)) return c;
        return null;
    }

    public static Course getByUUID(UUID uuid) {
        return CACHE.get(uuid);
    }

    public Unit getUnit(int unit) {
        return units.get(unit - 1);
    }
}
