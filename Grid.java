public class Grid {
    private Ladder[] ladders;
    private Snake[] snakes;

    public Grid(int numberOfSnakes, int numberOfLadders) {
        snakes = new Snake[numberOfSnakes];
        snakes[0] = new Snake(16, 8);
        snakes[1] = new Snake(52, 28);
        snakes[2] = new Snake(78, 25);
        snakes[3] = new Snake(99, 21);
        snakes[4] = new Snake(95, 75);
        snakes[5] = new Snake(93, 89);
        ladders = new Ladder[numberOfLadders];
        ladders[0] = new Ladder(2, 45);
        ladders[1] = new Ladder(4, 27);
        ladders[2] = new Ladder(9, 31);
        ladders[3] = new Ladder(47, 84);
        ladders[4] = new Ladder(70, 87);
        ladders[5] = new Ladder(71, 91);
    }

    private Snake getSnake(int position) {
        for (int snakeIndex = 0; snakeIndex < snakes.length; snakeIndex++) {
            if (snakes[snakeIndex].getHeadPosition() == position) {
                return snakes[snakeIndex];
            }
        }
        return null;
    }

    private Ladder getLadder(int position) {
        for (int ladderIndex = 0; ladderIndex < ladders.length; ladderIndex++) {
            if (ladders[ladderIndex].getStartPosition() == position) {
                return ladders[ladderIndex];
            }
        }
        return null;
    }

    public int getUpdatedPosition(int position, int diceValue) {
        final int target = 100;
        int updatedPosition = -1;
        Snake snake = getSnake(position + diceValue);
        if (snake != null) {
            updatedPosition = new Position(snake.getTailPosition()).getPosition();
        }
        Ladder ladder = getLadder(position + diceValue);
        if (ladder != null) {
            updatedPosition = new Position(ladder.getEndPosition()).getPosition();
        }
        if (ladder == null && snake == null) {
            if ((position + diceValue) <= target) {
                updatedPosition = new Position(position + diceValue).getPosition();
            }
        }
//        System.out.println("Position: "+player.getPosition());
//        System.out.println("After Rolling " + player.getName() + "'s Position is: " + player.getPosition());
        return updatedPosition;
    }

    public boolean isGameCompleted(int player1Position, int player2Position) {
        final int target = 100;
        if (player1Position == target || player2Position == target) {
            return true;
        }
        return false;
    }
}
