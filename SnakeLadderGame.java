public class SnakeLadderGame {
    public static void main(String[] args){
        final int noOfSnakes = 6;
        final int noOfLadders = 6;
        Grid grid = new Grid(noOfSnakes,noOfLadders);
        Player player1 = new Player("Praveen",grid);
        Player player2 = new Player("Naveen",grid);
        while (true) {
            player1.play();
            if (player1.reachedGoal()) {
                break;
            }
            player2.play();
            if (player2.reachedGoal()) {
                break;
            }
        }
        if (player1.reachedGoal()) {
            System.out.println("Winner is "+player1.getName());
        }
        else if (player2.reachedGoal()) {
            System.out.println("Winner is "+player2.getName());
        }
    }
}
