package CourseControlSystemPr;

import java.util.*;

public class GradeSystem {
    private final Map<Student, List<Double>> grades = new HashMap<>();

    public void addGrade(Student student, double grade) {
        grades.computeIfAbsent(student, k -> new ArrayList<>()).add(grade);
    }

    public double getAverage(Student student) {
        List<Double> g = grades.get(student);
        if (g == null || g.isEmpty()) return 0.0;
        double sum = 0;
        for (double v : g) sum += v;
        return sum / g.size();
    }

    public OptionalDouble getCourseAverage() {
        return grades.values().stream()
                .filter(list -> !list.isEmpty())
                .mapToDouble(list -> list.stream().mapToDouble(Double::doubleValue).average().orElse(0.0))
                .average();
    }

    public Map<Student, List<Double>> getAllGrades() {
        return Collections.unmodifiableMap(grades);
    }
}
