import java.util.Scanner;

public class Player {
    private String name;
    private Position position;
    private final Grid grid;
    private static final Dice DICE = new Dice();
    private static final Scanner SCANNER = new Scanner(System.in);

    public Player(String name, Grid grid) {
        this.name = name;
        this.position = new Position(0);
        this.grid = grid;
    }

    public Player(Grid grid) {
        this.name = "Yousuf";
        this.position = new Position(0);
        this.grid = grid;
    }

    public void play() {
        System.out.println("\n\nCurrent Position: " + position);
        System.out.print("Press Enter to roll a Dice! ");
        SCANNER.nextLine();
        int diceValue = DICE.roll();
        System.out.println("Dice Value "+diceValue);
        int currentPosition = position.getPosition() + diceValue;
        Snake snake = grid.isGridHasSnake(currentPosition);
        if (snake != null) {
            position = new Position(snake.getTailPosition());
        }
        Ladder ladder = grid.isGridHasLadder(currentPosition);
        if (ladder != null) {
            position = new Position(ladder.getEndPosition());
        }
        if (ladder == null && snake == null) {
            position = (position.getPosition() + diceValue) > 100 ? position : new Position(position.getPosition() + diceValue);
        }
        System.out.println("After Rolling Position is: " + position.getPosition());
    }

    public boolean reachedGoal() {
        if (position.getPosition() != 100) {
            return false;
        }
        return true;
    }

    public String getName() {
        return name;
    }
}
