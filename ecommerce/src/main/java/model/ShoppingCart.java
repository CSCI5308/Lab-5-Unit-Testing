package model;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    List<Product> items;
    Customer customer;

    public ShoppingCart(Customer customer) {
        this.items = new ArrayList<>();
        this.customer = customer;
    }

    public List<Product> getItems() {
        return items;
    }

    public void setItems(List<Product> items) {
        this.items = items;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void addProduct(Product product) {
        this.items.add(product);
    }

    public boolean removeProduct(Product product) {
        return this.items.remove(product);
    }

    public double getTotal() {
        double total = 0;
        for (Product product: this.items) {
            total += product.getQty() * product.getPrice();
        }

        return total;
    }

    public int getPoints() {
        int totalPoints = 0;
        for (Product product: this.items) {
            totalPoints += product.getPoints();
        }

        return totalPoints;
    }
}
