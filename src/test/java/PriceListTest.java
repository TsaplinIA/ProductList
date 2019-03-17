import org.junit.Test;

import static org.junit.Assert.*;

public class PriceListTest {
    PriceList first = new PriceList();
    PriceList second = new PriceList();
    Price a = new Price(10,0);
    Price b = new Price(20,0);
    Product milk = new Product("Milk", new Price(15, 0), 1);
    Product meat = new Product("Meat", new Price(50, 0), 2);

    @Test
    public void addProduct() {
        first.addProduct(milk);
        assertNotEquals(first, second);
        assertNotEquals(first.getCount(), second.getCount());
    }

    @Test
    public void changePrice() {
        first.addProduct("ball", new Price(15, 0), 3);
        first.changePrice(3, new Price(16, 0));
        assertNotEquals(first.amount(3, 3), 45);
        assertEquals(first.amount(3, 3), 48, 0.001f);
    }

    @Test
    public void changeName() {
        first.addProduct(meat);
        first.changeName(2, "NewMeat");
        assertNotEquals("Meat", first.getProductName(2));
        assertEquals("NewMeat", first.getProductName(2));
    }

    @Test
    public void deleteProduct() {
        int oldCount = first.getCount();
        first.addProduct("gun", new Price(1000, 0), 5);
        assertEquals(first.getCount(), oldCount + 1);
        first.deleteProduct(5);
        assertEquals(first.getCount(), oldCount);
    }

    @Test
    public void amount() {
        second.addProduct("Knife", new Price(200, 50), 6);
        assertEquals(second.amount(6, 3), 601.5f, 0.00001f);
    }
}