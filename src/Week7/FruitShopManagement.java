package Week7;

import java.util.ArrayList;

public class FruitShopManagement {
    public static void main(String[] args) {
        Shopping shopping = new Shopping();
        
        shopping.createFruit(1, "Apple", 1.0, 100, "USA");
        shopping.createFruit(2, "Mango", 2.0, 50, "India");
        shopping.createFruit(3, "Banana", 0.5, 200, "Vietnam");
        
        ArrayList<OrderItem> bag1 = new ArrayList<>();
        OrderItem item1 = new OrderItem("Banana", 10, 0.5, 10 * 0.5); 
        OrderItem item2 = new OrderItem("Mango", 10, 2.0, 10 * 2.0); 
        bag1.add(item1);
        bag1.add(item2);
        shopping.createOrder("Hung", bag1);

        ArrayList<OrderItem> bag2 = new ArrayList<>();
        item1 = new OrderItem("Banana", 10, 0.5, 10 * 0.5);
        item2 = new OrderItem("Mango", 10, 2.0, 10 * 2.0);
        bag2.add(item1);
        bag2.add(item2);
        shopping.createOrder("John", bag2);

        shopping.viewOrders();
    }
    
}
