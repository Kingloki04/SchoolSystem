package tech.lpdev.objects.serialization;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import tech.lpdev.objects.Unit;
import tech.lpdev.utils.json.JsonChain;
import tech.lpdev.utils.json.JsonSerializer;

public class UnitSerializer implements JsonSerializer<Unit> {

    Gson gson = new Gson();

    @Override
    public JsonObject serialize(Unit unit) {
        return new JsonChain()
                .addProperty("name", unit.getName())
                .addProperty("weight", String.valueOf(unit.getWeight()))
                .addProperty("sections", gson.toJson(unit.getSections()))
                .get();
    }

}
