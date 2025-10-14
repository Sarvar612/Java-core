package CourseControlSystemPr;

public class Teacher extends Person {
    private String department;

    public Teacher(String id, String name, String department) {
        super(id, name);
        this.department = department;
    }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    @Override
    public String getRole() { return "CourseControlSystemPr.Teacher"; }

    @Override
    public String toString() {
        return getName() + " [" + department + "]";
    }
}

