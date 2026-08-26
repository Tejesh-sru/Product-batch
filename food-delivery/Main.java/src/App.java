import models.Customer;
import models.FoodItem;
import models.Order;
import models.Restaurant;
import services.foodservices;

public class App {
    public static void main(String[] args) {
        foodservices service = new foodservices();
        Restaurant restaurant = new Restaurant("Home Kitchen");
        restaurant.addItem(new FoodItem("Veg Burger", 120));
        restaurant.addItem(new FoodItem("French Fries", 60));
        service.addRestaurant(restaurant);

        Customer customer = new Customer("alex", "pass123");
        service.displayMenu(restaurant);
        Order order = service.placeOrder(customer, restaurant, "Veg Burger", 2);
        service.makePayment(order, "card");
        System.out.println(service.trackOrder(order));
    }
}
