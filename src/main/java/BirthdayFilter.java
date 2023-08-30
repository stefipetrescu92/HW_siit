import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.time.LocalDate;

public class BirthdayFilter {

    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("args are not introduced");
            return;
        }

        String inputFileName = args[0];
        int targetMonth = Integer.parseInt(args[1]);
        String outputFileName = args[2];

        List<Person> people = readPeopleFromFile(inputFileName);
        List<Person> filteredPeople = filterPeopleByBirthMonth(people, targetMonth);
        List<Person> sortedPeople = sortPeopleAlphabetically(filteredPeople);

        writePeopleToFile(sortedPeople, outputFileName);
    }

    private static List<Person> readPeopleFromFile(String fileName) {
        List<Person> people = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("src\\main\\resources\\person.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String firstName = parts[0].trim();
                String lastName = parts[1].trim();
                LocalDate dateOfBirth = LocalDate.parse(parts[2].trim());
                people.add(new Person(firstName, lastName, dateOfBirth));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return people;
    }

    private static List<Person> filterPeopleByBirthMonth(List<Person> people, int targetMonth) {
        return people.stream()
                .filter(person -> person.getDateOfBirth().getMonthValue() == targetMonth)
                .collect(Collectors.toList());
    }

    private static List<Person> sortPeopleAlphabetically(List<Person> people) {
        return people.stream()
                .sorted(Comparator.comparing(Person::getLastName).thenComparing(Person::getFirstName))
                .collect(Collectors.toList());
    }

    private static void writePeopleToFile(List<Person> people, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Person person : people) {
                writer.write(person.getFirstName() + ", " + person.getLastName());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
