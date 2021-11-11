package objects.serialization;

import com.google.gson.*;
import objects.Grades;
import utils.json.JsonChain;
import utils.json.JsonSerializer;

public class GradeSerializer implements JsonSerializer<Grades> {

    Gson gson = new Gson();

    @Override
    public JsonObject serialize(Grades grades) {
        return new JsonChain()
                .addProperty("courseUUID", grades.getCourseUUID().toString())
                .addProperty("grades", gson.toJson(grades.getGrades())).get();
    }
}
