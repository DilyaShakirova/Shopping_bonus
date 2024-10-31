import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class BonusServiceTest {
    @Test
    void shouldCalculateForRegisteredAndUnderLimit() {
        BonusService service = new BonusService();
        long expected = 30;
        long actual = service.calculate(1000, true);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForRegisteredAndOverLimit() {
        BonusService service = new BonusService();
        long expected = 500;
        long actual = service.calculate(1_000_000, true);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForUnregisteredUnderLimit() {
        BonusService service = new BonusService();
        long expected = 10;
        long actual = service.calculate(1000, false);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForUnregisteredOverLimit() {
        BonusService service = new BonusService();
        long expected = 500;
        long actual = service.calculate(60_000, false);
        Assertions.assertEquals(expected, actual);
    }
}
