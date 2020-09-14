public class BowlingGame {

    public void calculate(int[] numberOfKnockdowns) {
        for(int number : numberOfKnockdowns) {
            if (number < 0) {
                throw new IllegalArgumentException();
            }
        }
    }
}
