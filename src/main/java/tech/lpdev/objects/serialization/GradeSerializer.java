package tech.lpdev.objects.serialization;

import com.google.gson.*;
import tech.lpdev.objects.Grades;
import tech.lpdev.utils.json.JsonChain;
import tech.lpdev.utils.json.JsonSerializer;

public class GradeSerializer implements JsonSerializer<Grades> {

    Gson gson = new Gson();

    @Override
    public JsonObject serialize(Grades grades) {
        return new JsonChain()
                .addProperty("courseUUID", grades.getCourseUUID().toString())
                .addProperty("grades", gson.toJson(grades.getGrades())).get();
    }
}
