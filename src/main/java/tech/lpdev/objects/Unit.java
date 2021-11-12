package tech.lpdev.objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import tech.lpdev.objects.serialization.UnitDeserializer;
import tech.lpdev.objects.serialization.UnitSerializer;

import java.util.List;

@Data
@AllArgsConstructor
public class Unit {

    public static UnitSerializer SERIALIZER = new UnitSerializer();
    public static UnitDeserializer DESERIALIZER = new UnitDeserializer();

    String name;
    int weight;
    List<Section> sections;

    public Section getSection(int section) {
        return sections.get(section - 1);
    }
}
