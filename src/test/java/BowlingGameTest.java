import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BowlingGameTest {
    @Test
    void should_throw_exception_when_calculation_given_number_is_negative() {
        BowlingGame bowlingGame = new BowlingGame();
        int[] numberOfKnockdowns = {0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        assertThrows(IllegalArgumentException.class, () -> bowlingGame.calculate(numberOfKnockdowns));
    }

    @Test
    void should_throw_exception_when_calculation_given_number_is_larger_than_10() {
        BowlingGame bowlingGame = new BowlingGame();
        int[] numberOfKnockdowns = {0, 0, 11, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        assertThrows(IllegalArgumentException.class, () -> bowlingGame.calculate(numberOfKnockdowns));
    }

    @Test
    void should_throw_exception_when_calculation_given_array_less_than_12() {
        BowlingGame bowlingGame = new BowlingGame();
        int[] numberOfKnockdowns = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        assertThrows(IllegalArgumentException.class, () -> bowlingGame.calculate(numberOfKnockdowns));
    }

    @Test
    void should_throw_exception_when_calculation_given_array_larger_than_20() {
        BowlingGame bowlingGame = new BowlingGame();
        int[] numberOfKnockdowns = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        assertThrows(IllegalArgumentException.class, () -> bowlingGame.calculate(numberOfKnockdowns));
    }

    @Test
    void should_throw_exception_when_two_throw_numbers_larger_than_10() {
        BowlingGame bowlingGame = new BowlingGame();
        int[] numberOfKnockdowns = {0, 0, 9, 9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        assertThrows(IllegalArgumentException.class, () -> bowlingGame.calculate(numberOfKnockdowns));
    }

    @Test
    void should_return_sum_when_every_frame_less_than_10() {
        BowlingGame bowlingGame = new BowlingGame();
        int[] numberOfKnockdowns = {1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2};
        int result = bowlingGame.calculate(numberOfKnockdowns);
        assertEquals(30, result);
    }

    @Test
    void should_return_sum_when_calculate_given_array_exists_strike() {
        BowlingGame bowlingGame = new BowlingGame();
        int[] numberOfKnockdowns = {10, 1, 2, 10, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2};
        int result = bowlingGame.calculate(numberOfKnockdowns);
        assertEquals(50, result);
    }

    @Test
    void should_return_sum_when_calculate_given_array_exists_spare() {
        BowlingGame bowlingGame = new BowlingGame();
        int[] numberOfKnockdowns = {10, 1, 2, 10, 5, 5, 1, 2, 1, 2, 5, 5, 1, 2, 1, 2, 1, 2};
        int result = bowlingGame.calculate(numberOfKnockdowns);
        assertEquals(73, result);
    }

    @Test
    void should_return_sum_when_calculate_given_Round_10_is_strike() {
        BowlingGame bowlingGame = new BowlingGame();
        int[] numberOfKnockdowns = {10, 1, 2, 10, 5, 5, 1, 2, 1, 2, 5, 5, 1, 2, 1, 2, 10, 10, 10};
        int result = bowlingGame.calculate(numberOfKnockdowns);
        assertEquals(120, result);
    }

    @Test
    void should_return_sum_when_calculate_given_Round_10_is_spare() {
        BowlingGame bowlingGame = new BowlingGame();
        int[] numberOfKnockdowns = {10, 1, 2, 10, 5, 5, 1, 2, 1, 2, 5, 5, 1, 2, 1, 2, 5, 5, 10};
        int result = bowlingGame.calculate(numberOfKnockdowns);
        assertEquals(100, result);
    }
}
