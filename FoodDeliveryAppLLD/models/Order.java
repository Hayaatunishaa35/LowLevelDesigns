package models;

import java.util.*;

import strategies.PaymentStrategy;

public abstract class Order {
    private static int nextOrderId = 0;

    protected int orderId;
    protected User user;
    protected Restaurant restaurant;
    protected List<MenuItem> items;
    protected PaymentStrategy paymentStrategy;
    protected double total;
    protected String scheduled;

    public Order(){
        this.user = null;
        this.restaurant = null;
        this.paymentStrategy = null;
        this.total = 0.0;
        this.scheduled = "";
        this.orderId = ++nextOrderId;
    }
    

    public int getOrderId() {
        return this.orderId;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return this.user;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Restaurant getRestaurant() {
        return this.restaurant;
    }

    public void setItems(List<MenuItem> items) {
        this.items = items;
        total = 0;
        for (MenuItem i : items) {
            total += i.getPrice();
        }
    }

    public List<MenuItem> getItems() {
        return this.items;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void setScheduled(String scheduled) {
        this.scheduled = scheduled;
    }

    public String getScheduled() {
        return this.scheduled;
    }

    public double getTotal() {
        return this.total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public abstract String getType();

    public boolean processPayment(){
        if(paymentStrategy != null){
            paymentStrategy.pay(total);
            return true;
        }

        System.out.println("Please choose a payment mode");

        return false;
    }
}
