package OnlineQuiz;


import java.util.List;
import java.util.Scanner;

public class MultipleChoiceQuestion extends Question {
    private final List<String> options;
    private final int correctIndex;

    public MultipleChoiceQuestion(String prompt, List<String> options, int correctIndex, double maxPoints) {
        super(prompt, maxPoints);
        this.options = options;
        this.correctIndex = correctIndex;
    }

    @Override
    public double askAndEvaluate() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(getPrompt());
        for (int i = 0; i < options.size(); i++) {
            System.out.printf("  %d) %s\n", i + 1, options.get(i));
        }
        System.out.print("Your answer (number): ");
        String line = scanner.nextLine().trim();
        try {
            int choice = Integer.parseInt(line) - 1;
            if (choice == correctIndex) {
                System.out.println("Correct!");
                return getMaxPoints();
            } else {
                System.out.println("Incorrect. Correct answer: " + (correctIndex + 1));
                return 0.0;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input, counted as incorrect.");
            return 0.0;
        }
    }
}

