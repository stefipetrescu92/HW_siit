import java.time.LocalDate;
public class Student {

    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String gender;
    private String id;

    public Student(String firstName, String lastName, LocalDate dateOfBirth, String gender, String id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.id = id;
        validateData();
    }

    private void validateData() {
        int currentYear = LocalDate.now().getYear();
        if (dateOfBirth.getYear() < 1900 || dateOfBirth.getYear() > currentYear - 18) {
            throw new IllegalArgumentException("Date of birth must be between 1900 and (current year - 18).");
        }
        if (firstName.isEmpty() || lastName.isEmpty()) {
            throw new IllegalArgumentException("First name and last name should not be empty.");
        }
        if (!gender.equalsIgnoreCase("male") && !gender.equalsIgnoreCase("female") &&
                !gender.equalsIgnoreCase("m") && !gender.equalsIgnoreCase("f")) {
            throw new IllegalArgumentException("Gender should be male (M) or female (F).");
        }
        if (!id.matches("\\d{13}")) {
            throw new IllegalArgumentException("ID (CNP) should contain 13 digits.");
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
