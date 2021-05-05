
//package Version1;
import java.util.*;

public class Seller extends User implements ViewTotalNo {
    private int productsNum = 0, num; // number of products seller added
    Product[] myProducts;
    Product c;

    // constructors
    Seller() {

    }

    public Seller(int userId, String name) {
        super(userId, name);

        super.accountType = "Seller";
        myProducts = new Product[20];
    }

    // accessors
    public int getProductsNum() {
        int count = 0;
        c = myProducts[count];
        while (c != null) {
            count++;
            c = myProducts[count];
        }
        return count;
    }

    public Product[] getMyProducts() {
        return myProducts;
    }

    // mutators
    public void setMyProducts(Product[] myProducts) {
        this.myProducts = myProducts;
    }

    public void setProductsNum(int productsNum) {
        this.productsNum = productsNum;
    }

    @Override
    public void addProduct(Product p) {
        myProducts[productsNum] = p;
        productsNum++;
    }

    private boolean checkProduct(Product p) {
        boolean x = true;
        for (Object o : myProducts) {

            if (Objects.equals(o, p)) {
                x = false;
            }
        }
        return x;
    }

    public void removeProduct(int index) {
        if (!checkProduct(myProducts[index])) {
            for (int i = index; i < myProducts.length - 1; i++) {
                myProducts[i] = myProducts[i + 1];
            }
        }
        ;
    }

    public void updateQuantity(Product p, int q) {
        p.setQuantity(q);
    }

    @Override
    public void printInfo() {
        System.out.println("    Seller Information");
        System.out.println("********************************");
        super.printInfo();
        getTotalItemsNo();
    }

    @Override
    public void getTotalItemsNo() {
        num = getProductsNum();
        System.out.println("Number of products: " + num);

    }
}
