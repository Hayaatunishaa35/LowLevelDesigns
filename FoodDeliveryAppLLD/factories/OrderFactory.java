package factories;

import java.util.*;
import models.*;
import strategies.*;

public interface OrderFactory {
    Order createOrder(User user, Cart cart, Restaurant restaurant, List<MenuItem> items, PaymentStrategy paymentStrategy, double totalCost, String orderType);
}
