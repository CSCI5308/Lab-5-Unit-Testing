package model;

import java.time.LocalDate;

public class Customer {
    private String customerID;
    private int points = 1;
    private LocalDate joinedOn;
    private ShoppingCart shoppingCart;
    private double balance;

    public Customer(String customerID, LocalDate joinedOn, ShoppingCart shoppingCart, double balance) {
        this.customerID = customerID;
        this.joinedOn = joinedOn;
        this.shoppingCart = shoppingCart;
        this.balance = balance;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public LocalDate getJoinedOn() {
        return joinedOn;
    }

    public void setJoinedOn(LocalDate joinedOn) {
        this.joinedOn = joinedOn;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }
}
