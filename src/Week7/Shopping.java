package Week7;

import java.util.ArrayList;
import java.util.List;

public class Shopping {
    private List<Fruit> fruits;
    private List<Order> orders;

    public Shopping() {
        fruits = new ArrayList<>();
        orders = new ArrayList<>();
    }
    
    public void createFruit(int fruitID, String fruitName, double price, int quantity, String origin) {
        fruits.add(new Fruit(fruitID, fruitName, price, quantity, origin));
    }
    
    public Fruit getFruitByName(String fruitName) {
        for (Fruit fruit : fruits) {
            if (fruit.getName().equalsIgnoreCase(fruitName)) {
                return fruit;
            }
        }
        return null;
    }

    public void createOrder(String customerName, ArrayList<OrderItem> items) {
        Order order = new Order(customerName, new ArrayList<>());
        for (OrderItem item : items) {
            order.addItem(item);
        }
        orders.add(order);
    }
    
    public void viewOrders() {
        if (orders.isEmpty()) {
            System.out.println("No orders available.");
            return;
        }
        for (Order order : orders) {
            order.viewOrder();
        }
    }

}
