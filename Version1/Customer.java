
//package Version1;
import java.util.*;

public class Customer extends User {
    private Seller S;
    private Address address;
    private double accountBalance;
    private Product[] cart;
    private int L = 0;

    // constructors
    public Customer() {

    }

    public Customer(int userId, String name, double accountBalance) {
        super(userId, name);
        this.accountBalance = accountBalance;
        super.accountType = "Customer";
        address = new Address();
        Seller S = new Seller();
        cart = new Product[10];
        L = 0;
    }

    // mutators
    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public void setCart(Product[] cart) {
        this.cart = cart;
    }

    public void setSeller(Seller s) {
        S = s;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    // accessors
    public double getAccountBalance() {
        return accountBalance;
    }

    public Product[] getCart() {
        return cart;
    }

    public Address getAddress() {
        return address;
    }

    public Seller getSeller() {
        return S;
    }

    // methods
    private boolean checkProduct(Product p) {
        boolean x = true;
        for (Object o : S.getMyProducts()) {

            if (Objects.equals(o, p)) {
                x = false;
            }
        }
        return x;
    }

    @Override
    public void addProduct(Product p) {

        if (accountBalance < p.getProductCost() && !checkProduct(p)) {
            System.out.println("You (" + name + ") Have insufficient balance to add product: " + p.getProductName());
        }

        if (p.getQuantity() == 0) {
            System.out.println("Product: " + p.getProductName() + " is sold out.");
        }

        if (checkProduct(p)) {
            System.out.println("Product: " + p.getProductName() + " is not Sold by " + S.getName());
        }

        if ((accountBalance >= p.getProductCost()) && (p.getQuantity() > 0) && !checkProduct(p)) {
            accountBalance -= p.getProductCost();
            p.setQuantity(p.getQuantity() - 1);
            cart[L] = p;
            L++;
        }
    }

    @Override
    public void removeProduct(int o) {
        accountBalance = accountBalance + (cart[o].getProductCost());
        if (!checkProduct(cart[o])) {
            accountBalance += cart[o].getProductCost();
            cart[o].setQuantity(cart[o].getQuantity() + 1);
            for (int i = o; i < cart.length - 1; i++) {
                cart[i] = cart[i + 1];
            }
        }
    }

    @Override
    public void printInfo() {
        System.out.println("    Customer Information");
        System.out.println("********************************");
        super.printInfo();
        System.out.println("Address: " + address.getFullAddress());

    }

}
