package objects.serialization;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import objects.Unit;
import utils.json.JsonConversion;
import utils.json.JsonDeserializer;

public class UnitDeserializer implements JsonDeserializer<Unit> {

    Gson gson = new Gson();

    @Override
    public Unit deserialize(JsonObject object) {
        return new Unit(object.get("name").getAsString(),
                object.get("weight").getAsInt(),
                JsonConversion.toSectionList(object.get("sections").getAsString()));
    }
}
