import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
public class StudentRepository {
    private List<Student> students = new ArrayList<>();

    public void addStudent(String firstName, String lastName, LocalDate dateOfBirth, String gender, String id) {
        students.add(new Student(firstName, lastName, dateOfBirth, gender, id));
    }

    public void deleteStudent(String id) {
        if (id.isEmpty()) {
            throw new IllegalArgumentException("ID should not be empty.");
        }

        boolean removed = students.removeIf(student -> student.getId().equals(id));
        if (!removed) {
            throw new IllegalArgumentException("Student with the given ID does not exist.");
        }
    }

    public List<Student> retrieveStudentsWithAge(int age) {
        if (age <= 0) {
            throw new IllegalArgumentException("Age should be a positive number.");
        }

        LocalDate today = LocalDate.now();
        return students.stream()
                .filter(student -> today.minusYears(age).isBefore(student.getDateOfBirth()))
                .collect(Collectors.toList());
    }

    public List<Student> listStudentsOrderedByLastName() {
        return students.stream()
                .sorted((s1, s2) -> s1.getLastName().compareToIgnoreCase(s2.getLastName()))
                .collect(Collectors.toList());
    }

    public List<Student> listStudentsOrderedByBirthDate() {
        return students.stream()
                .sorted((s1, s2) -> s1.getDateOfBirth().compareTo(s2.getDateOfBirth()))
                .collect(Collectors.toList());
    }
}
