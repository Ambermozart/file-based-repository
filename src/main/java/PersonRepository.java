import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;

public class PersonRepository {
    private Set<Person> people;

    public PersonRepository(String fileName) {
Path filePath = Paths.get(fileName);
        try {
            Files.lines(filePath)
            .map(fileLine -> createPerson(fileLine));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private Person createPerson(String fileLine) {
        String[] fileLineParts = fileLine.split(",");
        String firstName = fileLineParts[0];
        String lastName = fileLineParts[1];
        int age = Integer.parseInt(fileLineParts[2]);
        return new Person(firstName, lastName, age);
    }
}
