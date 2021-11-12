package tech.lpdev.objects.serialization;

import com.google.gson.JsonObject;
import tech.lpdev.objects.Section;
import tech.lpdev.utils.json.JsonChain;
import tech.lpdev.utils.json.JsonSerializer;

public class SectionSerializer implements JsonSerializer<Section> {

    @Override
    public JsonObject serialize(Section section) {
        return new JsonChain().addProperty("name", section.getName())
                .addProperty("weight", String.valueOf(section.getWeight())).get();
    }

}
