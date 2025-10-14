package OnlineQuiz;


import java.util.ArrayList;
import java.util.List;

public class Team {
    private final String name;
    private final List<String> members = new ArrayList<>();
    private double score = 0.0;

    public Team(String name) {
        this.name = name;
    }

    public void addMember(String memberName) {
        members.add(memberName);
    }

    public List<String> getMembers() {
        return List.copyOf(members);
    }

    public String getName() {
        return name;
    }

    public double getScore() { return score; }
    public void addScore(double points) { score += points; }

    @Override
    public String toString() {
        return name + " members: " + members + " score: " + score;
    }
}

