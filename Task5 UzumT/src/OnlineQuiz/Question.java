package OnlineQuiz;


public abstract class Question {
    private final String prompt;
    private final double maxPoints;

    public Question(String prompt, double maxPoints) {
        this.prompt = prompt;
        this.maxPoints = maxPoints;
    }

    public String getPrompt() {
        return prompt;
    }
    public double getMaxPoints() {
        return maxPoints;
    }

    public abstract double askAndEvaluate();
}
