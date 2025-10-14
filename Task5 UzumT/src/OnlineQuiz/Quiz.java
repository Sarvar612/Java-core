package OnlineQuiz;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Quiz {
    private final String title;
    private final List<Question> questions = new ArrayList<>();
    private final List<Team> teams = new ArrayList<>();

    public Quiz(String title) {
        this.title = title;
    }

    public void addQuestion(Question q) { questions.add(q); }
    public void addTeam(Team t) { teams.add(t); }

    public void run() {
        System.out.println("Starting quiz: " + title);
        Scanner scanner = new Scanner(System.in);
        for (Team team : teams) {
            System.out.println("\nTeam '" + team.getName() + "' turn. Members: " + team.getMembers());
            System.out.println("Press Enter to start for this team...");
            scanner.nextLine();
            for (Question q : questions) {
                System.out.println("\nQuestion for team " + team.getName() + ":");
                double points = q.askAndEvaluate();
                team.addScore(points);
                System.out.printf("Awarded %.2f points. Team total: %.2f\n", points, team.getScore());
            }
        }
        printResults();
    }

    public void printResults() {
        System.out.println("\n=== Quiz Results ===");
        teams.sort((a,b) -> Double.compare(b.getScore(), a.getScore()));
        for (int i = 0; i < teams.size(); i++) {
            Team t = teams.get(i);
            System.out.printf("%d. %s - %.2f points\n", i+1, t.getName(), t.getScore());
        }
    }
}

