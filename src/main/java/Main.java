public class Main {
    public static void main(String[] args) {
        PriceList listNow = new PriceList();
        listNow.addProduct("Moloko", new Price(10, 0), 13);
        listNow.addProduct("Milk", new Price(10, 50),12);
        System.out.println(listNow);
        System.out.println(listNow.amount(12,3));
        System.out.println(listNow.amount(13,15));
    }
}
