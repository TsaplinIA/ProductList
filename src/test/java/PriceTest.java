import org.junit.Test;

import static org.junit.Assert.*;

public class PriceTest {
    @Test
    public void test() {
        Price a = new Price(15, 15);
        Price b = new Price(15, 15);
        assertEquals(a, b);
    }
}