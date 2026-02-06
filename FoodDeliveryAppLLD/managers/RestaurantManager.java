package managers;

import java.util.ArrayList;
import java.util.List;

import models.Restaurant;

public class RestaurantManager {
    private List<Restaurant> restaurants = new ArrayList<>();
    private static RestaurantManager instance = null;

    private RestaurantManager() {
    }

    public static RestaurantManager getInstance() {
        if (instance == null) {
            instance = new RestaurantManager();
        }
        return instance;
    }

    public void addRestaurant(Restaurant r) {
        restaurants.add(r);
    }

    public List<Restaurant> searchByLocation(String location) {
        List<Restaurant> restaurants = new ArrayList<>();
        for (Restaurant r : restaurants) {
            String loc = r.getLocation();
            if (loc.equalsIgnoreCase(location)) {
                restaurants.add(r);
            }
        }
        return restaurants;
    }
}
