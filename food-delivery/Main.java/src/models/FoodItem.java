package models;

public class FoodItem {
    private String name;
    private double price;

    public FoodItem(String name, double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        this.name = name;
        this.price = price;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return name + " - $" + String.format("%.2f", price);
    }
}