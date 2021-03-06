public class SnakeLadderGame {
    private static final Dice DICE = new Dice();
    private Grid grid;
    private Player player1;
    private Player player2;

    public SnakeLadderGame(int numberOfSnakes, int numberOfLadders, String player1Name, String player2Name) {
        grid = new Grid(numberOfSnakes, numberOfLadders);
        player1 = new Player(player1Name);
        player2 = new Player(player2Name);
    }

    public void play() {
        Player currentPlayer = player1;
        while (!grid.isGameCompleted(player1.getPosition(), player2.getPosition())) {
            int diceValue = currentPlayer.play(DICE);
            Position position = grid.getUpdatedPosition(currentPlayer.getPosition(), diceValue);
            currentPlayer.setPosition(position);
            System.out.println(currentPlayer.getName() + "'s current Position: " + currentPlayer.getPosition().getPosition());
            currentPlayer = switchPlayer(currentPlayer);
        }
    }

    private Player switchPlayer(Player currentPlayer) {
        if (currentPlayer.equals(player1)) {
            return player2;
        } else {
            return player1;
        }
    }

    public static void main(String[] args) {
        final int numberOfSnakes = 6;
        final int numberOfLadders = 6;
        final String player1Name = "Yousuf";
        final String player2Name = "Naveen";
        new SnakeLadderGame(numberOfSnakes, numberOfLadders, player1Name, player2Name).play();
    }
}
