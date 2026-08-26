package models;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User {
    private String phone;
    private String address;
    private List<Order> orders = new ArrayList<>();

    public Customer(String username, String password) {
        super(username, password);
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }
}
