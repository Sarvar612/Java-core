package CourseControlSystemPr;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== СИСТЕМА УПРАВЛЕНИЯ КУРСОМ ===");

        // creating teacher
        System.out.print("Введите ID преподавателя: ");
        String teacherId = scanner.nextLine();
        System.out.print("Введите имя преподавателя: ");
        String teacherName = scanner.nextLine();
        System.out.print("Введите кафедру: ");
        String department = scanner.nextLine();

        Teacher teacher = new Teacher(teacherId, teacherName, department);

        // creating course
        System.out.print("\nВведите код курса: ");
        String courseCode = scanner.nextLine();
        System.out.print("Введите название курса: ");
        String courseTitle = scanner.nextLine();

        Course course = new Course(courseCode, courseTitle, teacher);
        System.out.println("\n✅ Курс успешно создан!");
        System.out.println("Преподаватель: " + teacher.getName());

        // main menu
        while (true) {
            System.out.println("\n------ МЕНЮ ------");
            System.out.println("1. Добавить студента");
            System.out.println("2. Отметить посещаемость");
            System.out.println("3. Выставить оценку");
            System.out.println("4. Показать отчёт");
            System.out.println("5. Выйти");
            System.out.print("Выберите действие (1-5): ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1": // creating student
                    System.out.print("ID студента: ");
                    String id = scanner.nextLine();
                    System.out.print("Имя студента: ");
                    String name = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    Student s = new Student(id, name, email);
                    if (course.addStudent(s)) {
                        System.out.println("✅ Студент добавлен: " + s.getName());
                    } else {
                        System.out.println("⚠ Такой студент уже есть!");
                    }
                    break;

                case "2": // Attendance check
                    if (course.getStudents().isEmpty()) {
                        System.out.println("⚠ Нет студентов в курсе!");
                        break;
                    }
                    LocalDate date = LocalDate.now();
                    System.out.println("Отмечаем посещаемость за " + date);
                    for (Student st : course.getStudents()) {
                        System.out.print("Был ли " + st.getName() + " на занятии? (y/n): ");
                        String answer = scanner.nextLine().trim().toLowerCase();
                        boolean present = answer.equals("y") || answer.equals("yes");
                        course.recordAttendance(date, st, present);
                    }
                    System.out.println("✅ Посещаемость за " + date + " сохранена!");
                    break;

                case "3": // grade marking
                    if (course.getStudents().isEmpty()) {
                        System.out.println("⚠ Нет студентов для оценки!");
                        break;
                    }
                    System.out.println("Выберите студента для оценки:");
                    for (Student st : course.getStudents()) {
                        System.out.println(" - " + st.getId() + ": " + st.getName());
                    }
                    System.out.print("Введите ID студента: ");
                    String sid = scanner.nextLine().trim();
                    Student selected = null;
                    for (Student st : course.getStudents()) {
                        if (st.getId().equalsIgnoreCase(sid)) {
                            selected = st;
                            break;
                        }
                    }
                    if (selected == null) {
                        System.out.println("⚠ Студент не найден!");
                        break;
                    }
                    System.out.print("Введите оценку (0-100): ");
                    try {
                        double grade = Double.parseDouble(scanner.nextLine());
                        course.gradeStudent(selected, grade);
                        System.out.println("✅ Оценка добавлена!");
                    } catch (NumberFormatException e) {
                        System.out.println("❌ Ошибка: введите число!");
                    }
                    break;

                case "4": // report
                    course.printReport();
                    break;

                case "5": // exit
                    System.out.println("Программа завершена. До свидания!");
                    scanner.close();
                    return;

                default:
                    System.out.println("⚠ Неверный выбор! Введите число от 1 до 5.");
            }
        }
    }
}
