import models.*;
import strategies.*;

public class Main{
    public static void main(String[] args){
        // Simulating a happy flow
        // Create ZomatoApp Object
        ZomatoApp zomato = new ZomatoApp();

        // Simulating a user coming in (Happy flow)
        User user = new User(101,"Hayat","Delhi");
        System.out.println("User: "+user.getName()+ " is active.");

        // User searches restaurants by location
        java.util.List<Restaurant> restaurantList = zomato.searchRestaurants("Delhi");

        if(restaurantList.isEmpty()){
            System.out.println("No restaurant found");
        }

        System.out.println("Found Restaurants:");
        for(Restaurant restaurant: restaurantList){
            System.out.println(restaurant.getName());
        }

        // User selects a restaurant
        zomato.selectRestaurant(user, restaurantList.get(0));
        System.out.println("Selected restaurant: "+restaurantList.get(0).getName());

        // User adds items to the cart
        zomato.addToCart(user, "P1");
        zomato.addToCart(user, "P2");

        zomato.printUserCart(user);

        // Checkout 
        Order order = zomato.checkoutNow(user, "Delivery", new UpiPaymentStrategy("999999999"));

        // Payment
        zomato.payForOrder(user, order);

    }
}