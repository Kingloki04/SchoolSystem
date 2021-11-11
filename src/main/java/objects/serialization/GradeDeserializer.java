package objects.serialization;

import com.google.gson.JsonObject;
import objects.Grades;
import utils.json.JsonConversion;
import utils.json.JsonDeserializer;

import java.util.UUID;

public class GradeDeserializer implements JsonDeserializer {

    @Override
    public Object deserialize(JsonObject object) {
        return new Grades(
                UUID.fromString(object.get("courseUUID").getAsString()),
                JsonConversion.toIntegerList(object.get("grades").getAsString()));
    }
}
