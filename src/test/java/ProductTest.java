import org.junit.Test;

import static org.junit.Assert.*;

public class ProductTest {
    @Test
    public void test() {
        Product a = new Product("Milk",new Price(10,0),1);
        Product b = new Product("Milk",new Price(10,0),1);
        Product c = new Product("Milk",new Price(12,0),1);
        assertEquals(a, b);
        assertNotEquals(a, c);
        assertEquals(a.toString(), "Code: 1; Name: Milk; Price: 10.0;");
    }
}