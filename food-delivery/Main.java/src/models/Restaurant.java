package models;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private String name;
    private ArrayList<FoodItem> menu = new ArrayList<>();

    public Restaurant(String name) { this.name = name; }
    public String getName() { return name; }
    public void addItem(FoodItem item) { menu.add(item); }
    public List<FoodItem> getMenu() { return menu; }

    public FoodItem findItem(String itemName) {
        for (FoodItem item : menu) {
            if (item.getName().equalsIgnoreCase(itemName)) return item;
        }
        return null;
    }
}