package files;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.List;

class Person {
    public String name;
    public int age;
    public List<String> skills;
}

public class ReadJsonExample {
    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper();
           
            Person person = mapper.readValue(new File("d:\\blaptop\\data.json"), Person.class);
            System.out.println(person.name + " - " + person.age);
            System.out.println("Skills: " + person.skills);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}