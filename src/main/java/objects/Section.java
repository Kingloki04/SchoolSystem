package objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import objects.serialization.SectionDeserializer;
import objects.serialization.SectionSerializer;

@Data
@AllArgsConstructor
public class Section {

    public static SectionSerializer SERIALIZER = new SectionSerializer();
    public static SectionDeserializer DESERIALIZER = new SectionDeserializer();

    String name;
    int weight;
}