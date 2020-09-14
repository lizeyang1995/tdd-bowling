public class BowlingGame {
    private int sumScores = 0;
    private boolean isFirstThrow = true;
    private int frameScore = 0;

    public int calculate(int[] numberOfKnockdowns) {
        throwError(numberOfKnockdowns);
        for(int index = 0; index < numberOfKnockdowns.length; index++) {
            int value = numberOfKnockdowns[index];
            if (isFirstThrow && value != 10) {
                isFirstThrow = false;
                sumScores += value;
                frameScore += value;
                continue;
            } else if (value == 10){
                strikeFrame(numberOfKnockdowns, index);
            } else if (frameScore + value == 10){
                spareFrame(numberOfKnockdowns, index);
            } else {
                sumScores += value;
            }
            isFirstThrow = true;
            frameScore = 0;
        }
        return sumScores;
    }

    private void spareFrame(int[] numberOfKnockdowns, int index) {
        sumScores += numberOfKnockdowns[index];
        sumScores += numberOfKnockdowns[index + 1];
    }

    private void strikeFrame(int[] numberOfKnockdowns, int index) {
        sumScores += numberOfKnockdowns[index];
        sumScores += numberOfKnockdowns[index + 1];
        sumScores += numberOfKnockdowns[index + 2];
    }

    private void throwError(int[] numberOfKnockdowns) {
        if (numberOfKnockdowns.length < 12 || numberOfKnockdowns.length > 20) {
            throw new IllegalArgumentException();
        }
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
