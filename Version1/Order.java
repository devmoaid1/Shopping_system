
//package Version1;
import java.util.*;

public class Order implements ViewTotalNo {
    Product[] orderItems;
    Customer C;
    Seller S;
    private Date dateCreated;
    private int orderId;
    private double orderPrice;
    Product p;

    // constructors
    Order() {

    }

    Order(int orderId) {
        orderItems = new Product[20];
        C = new Customer();
        S = new Seller();
        this.orderId = orderId;
    }

    // accessors
    public int getOrderId() {
        return orderId;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public Customer getC() {
        return C;
    }

    public Seller getS() {
        return S;
    }

    public Product[] getOrderItems() {
        return orderItems;
    }

    public double getOrderPrice() {
        return orderPrice;
    }

    // mutators
    public void setCart(Product[] orderItems) {
        this.orderItems = orderItems;
    }

    public void setCustomer(Customer c) {
        C = c;
    }

    public void setSeller(Seller s) {
        S = s;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public void setOrderItems(Product[] orderItems) {
        this.orderItems = orderItems;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setP(Product p) {
        this.p = p;
    }

    // methods
    public double calcPrice() {
        orderPrice = 0;
        for (int i = 0; i < getProductsNum(); i++) {
            orderPrice += orderItems[i].getProductCost();
        }
        return orderPrice;
    }

    public void getTotalItemsNo() {
        System.out.println("Number of products in the Order: " + getProductsNum());

    }

    public int getProductsNum() {
        int count = 0;
        p = orderItems[count];
        while (p != null) {
            count++;
            p = orderItems[count];
        }
        return count;
    }

    public void printOrder() {
        System.out.println(" ");
        System.out.println("Viewing Order: " + orderId + ". Sold by: " + S.getName() + ". To: " + C.getName() + ".");
        dateCreated = new Date();
        S.printInfo();
        C.printInfo();
        System.out.println("        Order Details");
        System.out.println("********************************");
        System.out.println("Order ID: " + orderId);
        System.out.println("Date: " + dateCreated);
        getTotalItemsNo();
        System.out.println("        Products");
        System.out.println("********************************");
        for (int i = 0; i < getProductsNum(); i++) {
            System.out.println("* " + (i + 1) + " *");
            orderItems[i].printInfo();
        }
        System.out.println("Total order price: " + calcPrice());
        System.out.println("********************************");
        System.out.println(" ");
    }

}
