import java.util.ArrayList;

public class PriceList {
    private ArrayList<Product> list = new ArrayList<>();

    void addProduct(String name, Price price, int code) {
        if (itsFreeCode(code)) list.add(new Product(name, price, code));
        else throw new IllegalArgumentException("Product with this code already exists");
    }

    void addProduct(Product product) {
        if (itsFreeCode(product.code)) list.add(product);
        else throw new IllegalArgumentException("Product with this code already exists");
    }

    private Product findProduct(int code) {
        for(Product productNow : list)
            if(productNow.code == code) return productNow;
        throw new IllegalArgumentException("Product with this code not found");
    }

    int getCount() { return list.size(); }

    String getProductName(int code) { return findProduct(code).name; }

    void changePrice(int code, Price price) {
        findProduct(code).setPrice(price);
    }

    void changeName(int code, String name) {
        findProduct(code).setName(name);
    }

    void deleteProduct(int code) {
        list.removeIf(el -> el.code == code);
    }

    double amount(int code, int qt) {
        if(qt < 0) throw new IllegalArgumentException("wrong amount");
        Price priceNow = findProduct(code).price;
        return qt * (priceNow.rub + priceNow.cop / 100f);
    }

    private boolean itsFreeCode(int code) {
        for(Product el : list)
            if(el.code == code) return false;
        return true;
    }

    public String toString() {
        String result = "";
        for(Product el: list)
            result += el.toString() + "\n";
        return  result;
    }

    public boolean equals(PriceList other) {
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        try {
            if (obj.getClass() == this.getClass()) {
                PriceList other = (PriceList) obj;
                for(Product el: list) {
                    if (!el.equals(other.findProduct(el.code))) return false;
                }
                return true;
            }
            else return false;
        }catch (Exception e) {
            return false;
        }
    }
}

class Product {
    int code;
    String name;
    Price price;

    void setName(String name) {
        this.name = name;
    }

    void setPrice(Price price) {
        this.price = price;
    }

    Product(String name, Price price, int code) {
        if(code > -1)
            this.code = code;
        else
            throw new IllegalArgumentException("Incorrect code!");
        setName(name);
        setPrice(price);
    }

    public String toString() {
        return "Code: " + code + "; Name: " + name + "; Price: " + price.rub + "." + price.cop + ";";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() == this.getClass()) {
            Product other = (Product) obj;
            return code == other.code && name == other.name && price.equals(other.price);
        }
        else return false;
    }
}

class Price {
    int rub;
    int cop;
    Price(int rub, int cop) {
        if (-1 < cop && cop < 100 && rub > -1) {
            this.cop = cop;
            this.rub = rub;
        }
        else
            throw new IllegalArgumentException("Incorrect price");
    }
    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() == this.getClass()) {
            Price other = (Price) obj;
            return rub == other.rub && cop == other.cop;
        }
        else return false;
    }
}