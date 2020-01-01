public class Grid {
    private int noOfSnakes, noOfLadders;
    private Ladder[] ladders;
    private Snake[] snakes;

    public Grid(int noOfSnakes, int noOfLadders) {
        this.noOfSnakes = noOfSnakes;
        this.noOfLadders = noOfLadders;
        snakes = new Snake[noOfSnakes];
        ladders = new Ladder[noOfLadders];
        snakes[0] = new Snake(16, 8);
        snakes[1] = new Snake(52, 28);
        snakes[2] = new Snake(78, 25);
        snakes[3] = new Snake(99, 21);
        snakes[4] = new Snake(95, 75);
        snakes[5] = new Snake(93, 89);
        ladders[0] = new Ladder(2, 45);
        ladders[1] = new Ladder(4, 27);
        ladders[2] = new Ladder(9, 31);
        ladders[3] = new Ladder(47, 84);
        ladders[4] = new Ladder(70, 87);
        ladders[5] = new Ladder(71, 91);
    }

    public Snake isGridHasSnake(int currentPosition) {
        for (int i = 0; i < noOfSnakes; i++) {
            if (snakes[i].getHeadPosition() == currentPosition) {
                return snakes[i];
            }
        }
        return null;
    }

    public Ladder isGridHasLadder(int currentPosition) {
        for (int i = 0; i < noOfLadders; i++) {
            if (ladders[i].getStartPosition() == currentPosition) {
                return ladders[i];
            }
        }
        return null;
    }
}
