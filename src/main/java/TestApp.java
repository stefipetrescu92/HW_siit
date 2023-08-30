import java.time.LocalDate;
import java.util.List;
public class TestApp {
    public static void main(String[] args) {
        StudentRepository repository = new StudentRepository();

        try {
            repository.addStudent("John", "Doe", LocalDate.of(2000, 1, 1), "Male", "1234567890123");
            repository.addStudent("Jane", "Smith", LocalDate.of(1995, 5, 15), "Female", "9876543210987");
        } catch (IllegalArgumentException e) {
            System.out.println("Error adding student: " + e.getMessage());
        }

        try {
            repository.addStudent("", "Invalid", LocalDate.of(2005, 3, 20), "M", "0000000000000");
        } catch (IllegalArgumentException e) {
            System.out.println("Error adding student: " + e.getMessage());
        }

        try {
            repository.deleteStudent("");
        } catch (IllegalArgumentException e) {
            System.out.println("Error deleting student: " + e.getMessage());
        }

        List<Student> ageFilteredStudents = repository.retrieveStudentsWithAge(25);
        System.out.println("Students with age 25:");
        for (Student student : ageFilteredStudents) {
            System.out.println(student.getFirstName() + " " + student.getLastName());
        }

        List<Student> studentsByLastName = repository.listStudentsOrderedByLastName();
        System.out.println("Students ordered by last name:");
        for (Student student : studentsByLastName) {
            System.out.println(student.getLastName() + ", " + student.getFirstName());
        }
    }
}
