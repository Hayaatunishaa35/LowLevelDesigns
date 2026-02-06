import java.util.*;
import factories.*;
import managers.*;
import models.*;
import services.*;
import strategies.PaymentStrategy;
import utils.*;

public class ZomatoApp {

    public ZomatoApp(){
        initializeRestaurant();
    }

    public void initializeRestaurant(){
        Restaurant Haldiram = new Restaurant("Haldiram", "Delhi");
        Haldiram.addMenuItem(new MenuItem("P1", "Chole Bhature", 120));
        Haldiram.addMenuItem(new MenuItem("P2", "Samosa", 15));

        Restaurant Karims = new Restaurant("Karims", "Delhi");
        Karims.addMenuItem(new MenuItem("P1", "Biryani", 200));
        Karims.addMenuItem(new MenuItem("P2", "Nihari", 100));

        RestaurantManager restaurantManager = RestaurantManager.getInstance();
        restaurantManager.addRestaurant(Haldiram);
        restaurantManager.addRestaurant(Karims);

    }

    public List<Restaurant> searchRestaurants(String location){
        return RestaurantManager.getInstance().searchByLocation(location);
    }

    public void selectRestaurant(User user, Restaurant restaurant){
        Cart cart = user.getCart();
        cart.setRestaurant(restaurant);
    }

    public void addToCart(User user, String itemCode){
        Restaurant restaurant = user.getCart().getRestaurant();

        if(restaurant==null){
            System.out.println("Please select a restaurant");
            return ;
        }

        for(MenuItem item: restaurant.getMenu()){
            if(item.getCode().equals(itemCode)){
                user.getCart().addItem(item);
                return;
            }
        }
    }

    public Order checkoutNow(User user, String orderType, PaymentStrategy pauPaymentStrategy){
        return checkout(user, orderType, pauPaymentStrategy, new NowOrderFactory());
    }

    public Order checkoutScheduled(User user, String orderType, PaymentStrategy pauPaymentStrategy, String scheduleTime){
        return checkout(user, orderType, pauPaymentStrategy, new ScheduledOrderFactory(scheduleTime));
    }


    public Order checkout(User user, String orderType, PaymentStrategy paymentStrategy, OrderFactory orderFactory){

        Cart userCart = user.getCart();
        if(userCart.isEmpty()){return null;}

        Restaurant restaurant = userCart.getRestaurant();
        List<MenuItem> itemsOrdered = userCart.getItems();
        double totalCost = userCart.getTotalCost();

        Order order = orderFactory.createOrder(user,userCart, restaurant, itemsOrdered, paymentStrategy, totalCost, orderType);
        OrderManager.getInstance().addOrder(order);
        return order;
    }

    public void payForOrder(User user, Order order){
        boolean isPaymentSuccess = order.processPayment();

        if(isPaymentSuccess){
            NotificationService.notify(order);
            user.getCart().clear();
        }
    }

    public void printUserCart(User user){
        System.out.println("Items in cart:");
        System.out.println("---------------------------------------");

        for(MenuItem item: user.getCart().getItems()){
            System.out.println(item.getCode() + " : " + item.getName() + " : ₹" + item.getPrice());
        }
        System.out.println("------------------------------------");
        System.out.println("Grand total : ₹" + user.getCart().getTotalCost());
    }
}
