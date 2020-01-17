import java.util.Scanner;

public class Player {
    private static final int STARTING_POSITION = 0;
    private String name;
    private Position position;

    public Player(String name) {
        this.name = name;
        this.position = new Position(STARTING_POSITION);
    }

    public int play(Dice DICE) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\n" + name + "'s Previous Position: " + position.getPosition());
        System.out.print("Press Enter to roll a Dice! ");
        scanner.nextLine();
        int diceValue = DICE.roll();
        System.out.println("Dice Value: " + diceValue);
        return diceValue;
    }

    public String getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
