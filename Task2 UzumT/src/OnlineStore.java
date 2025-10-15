import java.util.ArrayList;

public class OnlineStore {
    String code;
    String name;
    double price;
    int count;

    static ArrayList<OnlineStore> products = new ArrayList<>();

    public void addProduct(OnlineStore product) {
        products.add(product);
    }

    public void buyProduct(int amount) {
        if (count >= amount) {
            count -= amount;
            System.out.println("You bought " + amount + " of " + name);
        } else {
            System.out.println("Not enough items in stock!");
        }
    }

    public void getProductInfo() {
        System.out.println("Product: " + name + " | Price: " + price + " | In stock: " + count);
    }

    public static void getProducts() {
        for (OnlineStore p : products) {
            p.getProductInfo();
            System.out.println();
        }
    }
}

