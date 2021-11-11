package objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import objects.serialization.GradeDeserializer;
import objects.serialization.GradeSerializer;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
public class Grades {

    public static GradeSerializer SERIALIZER = new GradeSerializer();
    public static GradeDeserializer DESERIALIZER = new GradeDeserializer();

    UUID courseUUID;
    List<Integer> grades;

    public int getMark(int index) {
        return grades.get(index - 1);
    }
}
