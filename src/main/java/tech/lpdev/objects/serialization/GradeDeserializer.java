package tech.lpdev.objects.serialization;

import com.google.gson.JsonObject;
import tech.lpdev.objects.Grades;
import tech.lpdev.utils.json.JsonConversion;
import tech.lpdev.utils.json.JsonDeserializer;

import java.util.UUID;

public class GradeDeserializer implements JsonDeserializer {

    @Override
    public Object deserialize(JsonObject object) {
        return new Grades(
                UUID.fromString(object.get("courseUUID").getAsString()),
                JsonConversion.toIntegerList(object.get("grades").getAsString()));
    }
}
