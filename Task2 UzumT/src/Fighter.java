import java.util.ArrayList;
import java.util.Random;

public class Fighter {
    int code;
    String name;
    int health;
    int attack;
    

    static ArrayList<Fighter> fighters = new ArrayList<>();

    public void getFighterInfo() {
        System.out.println("Fighter: " + name + " | HP: " + health + " | ATK: " + attack);
    }

    public static void getFighters() {
        for (Fighter f : fighters) {
            f.getFighterInfo();
        }
    }

    public void fight(Fighter opponent) {
        Random r = new Random();
        Fighter first = r.nextBoolean() ? this : opponent;
        Fighter second = (first == this) ? opponent : this;

        System.out.println(first.name + " attacks first!");

        while (this.health > 0 && opponent.health > 0) {
            second.health -= first.attack;
            if (second.health <= 0) {
                System.out.println(first.name + " wins!");
                break;
            }
            // Switch turns
            Fighter temp = first;
            first = second;
            second = temp;
        }
    }
}
