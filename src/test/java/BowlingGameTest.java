import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BowlingGameTest {

    BowlingGame bowlingGame;

    @BeforeEach
    void initBowlingGame() {
        bowlingGame = new BowlingGame();
    }

    @Test
    void should_throw_exception_when_calculation_given_number_is_negative() {
        int[] numberOfKnockdowns = {0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        assertThrows(IllegalArgumentException.class, () -> bowlingGame.calculate(numberOfKnockdowns));
    }

    @Test
    void should_throw_exception_when_calculation_given_number_is_larger_than_10() {
        int[] numberOfKnockdowns = {0, 0, 11, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        assertThrows(IllegalArgumentException.class, () -> bowlingGame.calculate(numberOfKnockdowns));
    }

    @Test
    void should_throw_exception_when_calculation_given_array_less_than_11() {
        int[] numberOfKnockdowns = {10, 10, 10, 10, 10, 10, 10, 10, 10, 1};
        assertThrows(IllegalArgumentException.class, () -> bowlingGame.calculate(numberOfKnockdowns));
    }

    @Test
    void should_throw_exception_when_calculation_given_array_larger_than_21() {
        int[] numberOfKnockdowns = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 5, 5};
        assertThrows(IllegalArgumentException.class, () -> bowlingGame.calculate(numberOfKnockdowns));
    }

    @Test
    void should_throw_exception_when_two_throw_numbers_larger_than_10() {
        int[] numberOfKnockdowns = {0, 0, 9, 9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        assertThrows(IllegalArgumentException.class, () -> bowlingGame.calculate(numberOfKnockdowns));
    }

    @Test
    void should_return_sum_when_every_frame_less_than_10() {
        int[] numberOfKnockdowns = {1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2};
        int result = bowlingGame.calculate(numberOfKnockdowns);
        assertEquals(30, result);
    }

    @Test
    void should_return_sum_when_calculate_given_array_exists_strike() {
        int[] numberOfKnockdowns = {10, 1, 2, 10, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2};
        int result = bowlingGame.calculate(numberOfKnockdowns);
        assertEquals(50, result);
    }

    @Test
    void should_return_sum_when_calculate_given_array_exists_spare() {
        int[] numberOfKnockdowns = {10, 1, 2, 10, 5, 5, 1, 2, 1, 2, 5, 5, 1, 2, 1, 2, 1, 2};
        int result = bowlingGame.calculate(numberOfKnockdowns);
        assertEquals(73, result);
    }

    @Test
    void should_return_sum_when_calculate_given_Round_10_is_strike() {
        int[] numberOfKnockdowns = {10, 1, 2, 10, 5, 5, 1, 2, 1, 2, 5, 5, 1, 2, 1, 2, 10, 10, 10};
        int result = bowlingGame.calculate(numberOfKnockdowns);
        assertEquals(100, result);
    }

    @Test
    void should_return_sum_when_calculate_given_Round_10_is_spare() {
        int[] numberOfKnockdowns = {10, 1, 2, 10, 5, 5, 1, 2, 1, 2, 5, 5, 1, 2, 1, 2, 5, 5, 10};
        int result = bowlingGame.calculate(numberOfKnockdowns);
        assertEquals(90, result);
    }

    @Test
    void should_return_sum_when_calculate_given_all_strike() {
        int[] numberOfKnockdowns = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        int result = bowlingGame.calculate(numberOfKnockdowns);
        assertEquals(300, result);
    }
}
