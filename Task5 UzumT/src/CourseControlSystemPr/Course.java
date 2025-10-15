package CourseControlSystemPr;

import java.time.LocalDate;
import java.util.*;

public class Course {
    private final String code;
    private String title;
    private Teacher teacher;
    private final Set<Student> students = new HashSet<>();


    private final Map<LocalDate, Set<Student>> attendance = new HashMap<>();
    private final GradeSystem gradeSystem = new GradeSystem();

    public Course(String code, String title, Teacher teacher) {
        this.code = code;
        this.title = title;
        this.teacher = teacher;
    }

    public String getCode() {
        return code; }
    public String getTitle() {
        return title; }
    public void setTitle(String title) {
        this.title = title; }

    public Teacher getTeacher() {
        return teacher; }
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher; }

    public boolean addStudent(Student s) {
        return students.add(s);
    }

    public boolean removeStudent(Student s) {
        return students.remove(s);
    }

    public Set<Student> getStudents() {
        return Collections.unmodifiableSet(students);
    }

    public void recordAttendance(LocalDate date, Student student, boolean present) {
        attendance.computeIfAbsent(date, d -> new HashSet<>());
        if (present) {
            attendance.get(date).add(student);
        } else {
            attendance.get(date).remove(student);
        }
    }

    public boolean wasPresent(LocalDate date, Student student) {
        return attendance.getOrDefault(date, Collections.emptySet()).contains(student);
    }

    public Map<LocalDate, Set<Student>> getAttendanceRecords() {
        return Collections.unmodifiableMap(attendance);
    }

    public GradeSystem getGradeSystem() {
        return gradeSystem;
    }

    public void gradeStudent(Student s, double grade) {
        gradeSystem.addGrade(s, grade);
    }

    public void printReport() {
        System.out.println("CourseControlSystemPr.Course: " + code + " - " + title);
        System.out.println("CourseControlSystemPr.Teacher: " + (teacher == null ? "None" : teacher));
        System.out.println("Students:");
        for (Student s : students) {
            System.out.printf("  %s - avg grade: %.2f\n", s, gradeSystem.getAverage(s));
        }
        System.out.println("Attendance records:");
        List<LocalDate> dates = new ArrayList<>(attendance.keySet());
        Collections.sort(dates);
        for (LocalDate d : dates) {
            System.out.println("  " + d + ": " + attendance.get(d));
        }
    }
}
