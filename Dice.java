public class Dice {
    private static int range = 6;
    private static int min = 1;

    public int roll() {
        return (int) (Math.random() * range) + min;
    }
}