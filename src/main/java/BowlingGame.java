public class BowlingGame {
    int sumScores = 0;

    public int calculate(int[] numberOfKnockdowns) {
        throwError(numberOfKnockdowns);
        for(int index = 0; index < numberOfKnockdowns.length; index++) {
            int value = numberOfKnockdowns[index];
            if (value != 10) {
                sumScores += value;
            } else {
                strikeFrame(numberOfKnockdowns, index);
            }
        }
        return sumScores;
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
