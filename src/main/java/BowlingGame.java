public class BowlingGame {

    public int calculate(int[] numberOfKnockdowns) {
        throwError(numberOfKnockdowns);
        int sumScores = 0;
        for(int number : numberOfKnockdowns) {
            sumScores += number;
        }
        return sumScores;
    }

    private void throwError(int[] numberOfKnockdowns) {
        if (numberOfKnockdowns.length < 12 || numberOfKnockdowns.length > 20) {
            throw new IllegalArgumentException();
        }
        boolean isFirstThrow = true;
        int frameScore = 0;
        for(int number : numberOfKnockdowns) {
            if (number < 0 || number > 10) {
                throw new IllegalArgumentException();
            }
            if (isFirstThrow && number > 0 && number < 10) {
                isFirstThrow = false;
                frameScore += number;
                continue;
            }
            if (frameScore + number > 10) {
                throw new IllegalArgumentException();
            }
            isFirstThrow = true;
            frameScore = 0;
        }
    }
}
