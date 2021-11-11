package utils.json;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import objects.Grades;
import objects.Section;

import java.lang.reflect.Type;
import java.util.List;

public class JsonConversion {

    public static List<JsonObject> toJsonList(String value) {
        Gson gson = new Gson();
        Type jsonObjectType = new TypeToken<List<JsonObject>>(){}.getType();
        return gson.fromJson(value, jsonObjectType);
    }

    public static List<Section> toSectionList(String value) {
        Gson gson = new Gson();
        Type sectionObjectType = new TypeToken<List<Section>>(){}.getType();
        return gson.fromJson(value, sectionObjectType);
    }

    public static List<Integer> toIntegerList(String value) {
        Gson gson = new Gson();
        Type integerType = new TypeToken<List<Integer>>(){}.getType();
        return gson.fromJson(value, integerType);
    }
}

