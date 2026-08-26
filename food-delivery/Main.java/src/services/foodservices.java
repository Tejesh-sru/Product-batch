package services;
import java.util.ArrayList;
import java.util.List;
import models.Customer;
import models.FoodItem;
import models.Order;
import models.Payment;
import models.Restaurant;

public class foodservices {
  private final List<Restaurant> restaurants = new ArrayList<>();
  private int nextPaymentId = 1;

  public void addRestaurant(Restaurant restaurant) { restaurants.add(restaurant); }

  public List<Restaurant> searchRestaurant(String name) {
    List<Restaurant> matches = new ArrayList<>();
    for (Restaurant restaurant : restaurants) {
      if (restaurant.getName().toLowerCase().contains(name.toLowerCase())) matches.add(restaurant);
    }
    return matches;
  }

  public void displayMenu(Restaurant restaurant) {
    System.out.println("Menu: " + restaurant.getName());
    for (FoodItem item : restaurant.getMenu()) System.out.println(item);
  }

  public Order placeOrder(Customer customer, Restaurant restaurant, String itemName, int quantity) {
    FoodItem item = restaurant.findItem(itemName);
    if (item == null) throw new IllegalArgumentException("Food item not found: " + itemName);
    Order order = new Order(customer, restaurant, item, quantity);
    customer.addOrder(order);
    return order;
  }

  public Payment makePayment(Order order, String method) {
    Payment payment = new Payment(nextPaymentId++, order.getTotal(), method);
    if (!payment.proceed()) throw new IllegalArgumentException("Payment method must be card or cash");
    return payment;
  }

  public String trackOrder(Order order) {
    return "Order #" + order.getOrderId() + " status: " + order.getStatus();
  }

  public void cancelOrder(Order order) {
    if (order.getStatus().equals("Delivered")) {
      throw new IllegalStateException("Delivered orders cannot be cancelled");
    }
    order.setStatus("Cancelled");
  }
}