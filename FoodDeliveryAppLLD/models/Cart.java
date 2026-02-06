package models;

import java.util.*;


public class Cart {
    private Restaurant restaurant;
    private List<MenuItem> items = new ArrayList<>();

    public Cart(){
        restaurant = null;
    }

    public void setRestaurant(Restaurant r) {
        restaurant = r;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public List<MenuItem> getItems() {
        return items;
    }


    public void addItem(MenuItem item){
        if(restaurant == null){
            System.err.println("Cart: Set a restaurant before adding items");
            return;
        }
        items.add(item);
    }

    public double getTotalCost(){
        double cost = 0;
        for(MenuItem item: items){
            cost += item.getPrice();
        }
        return cost;
    }

    public boolean isEmpty(){
        return restaurant == null || items.size()==0;
    }

    public void clear(){
        items.clear();
        restaurant = null;
    }
}
