package objects.serialization;

import com.google.gson.JsonObject;
import objects.Section;
import utils.json.JsonDeserializer;

public class SectionDeserializer implements JsonDeserializer<Section> {

    @Override
    public Section deserialize(JsonObject object) {
        return new Section(object.get("name").getAsString(), object.get("weight").getAsInt());
    }
}
