package tech.lpdev.objects.serialization;

import com.google.gson.JsonObject;
import tech.lpdev.objects.Section;
import tech.lpdev.utils.json.JsonDeserializer;

public class SectionDeserializer implements JsonDeserializer<Section> {

    @Override
    public Section deserialize(JsonObject object) {
        return new Section(object.get("name").getAsString(), object.get("weight").getAsInt());
    }
}
