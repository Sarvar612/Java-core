package CourseControlSystemPr;
import java.util.Objects;

public class Student extends Person {
    private String email;

    public Student(String id, String name, String email) {
        super(id, name);
        this.email = email;
    }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public String getRole() { return "CourseControlSystemPr.Student"; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student s = (Student) o;
        return Objects.equals(getId(), s.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return getName() + " (" + getId() + ")";
    }
}

