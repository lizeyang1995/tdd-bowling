public class BowlingGame {

    public int calculate(int[] numberOfKnockdowns) {
        if (numberOfKnockdowns.length < 12 || numberOfKnockdowns.length > 20) {
            throw new IllegalArgumentException();
        }
        int sumScores = 0;
        for(int number : numberOfKnockdowns) {
            if (number < 0) {
                throw new IllegalArgumentException();
            }
            sumScores += number;
        }
        return sumScores;
    }
}
