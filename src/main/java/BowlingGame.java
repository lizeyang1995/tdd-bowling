public class BowlingGame {

    public void calculate(int[] numberOfKnockdowns) {
        if (numberOfKnockdowns.length < 12 || numberOfKnockdowns.length > 20) {
            throw new IllegalArgumentException();
        }
        for(int number : numberOfKnockdowns) {
            if (number < 0) {
                throw new IllegalArgumentException();
            }
        }
    }
}
