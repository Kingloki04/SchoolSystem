package objects.serialization;

import com.google.gson.JsonObject;
import objects.Section;
import utils.json.JsonChain;
import utils.json.JsonSerializer;

public class SectionSerializer implements JsonSerializer<Section> {

    @Override
    public JsonObject serialize(Section section) {
        return new JsonChain().addProperty("name", section.getName())
                .addProperty("weight", String.valueOf(section.getWeight())).get();
    }

}
