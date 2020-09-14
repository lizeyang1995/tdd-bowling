import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BowlingGameTest {
    @Test
    void should_throw_exception_when_calculation_given_number_is_negative() {
        BowlingGame bowlingGame = new BowlingGame();
        int[] numberOfKnockdowns = {0, 0, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        assertThrows(IllegalArgumentException.class, () -> bowlingGame.calculate(numberOfKnockdowns));
    }
}
