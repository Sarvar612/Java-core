package OnlineQuiz;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Quiz quiz = new Quiz("General Knowledge");

        quiz.addQuestion(new MultipleChoiceQuestion(
                "What is the capital of France?",
                Arrays.asList("Berlin", "Madrid", "Paris", "Rome"),
                2,
                10.0));

        quiz.addQuestion(new MultipleChoiceQuestion(
                "Which language runs on the JVM?",
                Arrays.asList("Python", "Kotlin", "JavaScript", "Ruby"),
                1,
                10.0));

        Team alpha = new Team("Alpha");
        alpha.addMember("Alice");
        alpha.addMember("Bob");
        Team beta = new Team("Beta");
        beta.addMember("Carol");

        quiz.addTeam(alpha);
        quiz.addTeam(beta);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Would you like to add another team? (y/n)");
        if (scanner.nextLine().trim().equalsIgnoreCase("y")) {
            System.out.print("Team name: ");
            String name = scanner.nextLine().trim();
            Team t = new Team(name);
            System.out.print("Comma separated members: ");
            String members = scanner.nextLine().trim();
            if (!members.isEmpty()) {
                for (String m : members.split(",")) t.addMember(m.trim());
            }
            quiz.addTeam(t);
        }

        quiz.run();
    }
}

