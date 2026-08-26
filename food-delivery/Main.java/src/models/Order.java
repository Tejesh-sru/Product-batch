package models;

public class Order {
    private static int nextId = 1;
    private int orderId = nextId++;
    private Customer customer;
    private Restaurant restaurant;
    private FoodItem item;
    private int quantity;
    private String status = "Placed";

    public Order(Customer customer, Restaurant restaurant, FoodItem item, int quantity) {
        if (quantity <= 0) throw new IllegalArgumentException("Quantity must be positive");
        this.customer = customer;
        this.restaurant = restaurant;
        this.item = item;
        this.quantity = quantity;
    }

    public int getOrderId() { return orderId; }
    public Customer getCustomer() { return customer; }
    public Restaurant getRestaurant() { return restaurant; }
    public FoodItem getItem() { return item; }
    public int getQuantity() { return quantity; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public double getTotal() { return item.getPrice() * quantity; }

    public String toString() {
        return "Order #" + orderId + " - " + quantity + " x " + item.getName()
                + " from " + restaurant.getName() + " (" + status + ")";
    }
}