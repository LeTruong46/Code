package Week7;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private String customerName;
    private List<OrderItem> orderList;

    public Order(String customerName, List<OrderItem> orderList) {
        this.customerName = customerName;
        this.orderList = new ArrayList<>();
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<OrderItem> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<OrderItem> orderList) {
        this.orderList = orderList;
    }
    
    public void addItem(OrderItem item){
        orderList.add(item);
    }
    
    public void viewOrder() {
        double totalAmount = 0;
        System.out.println("Customer: " + customerName);
        System.out.println("Product | Quantity | Price | Amount");
        for (OrderItem orderItem : orderList) {
            System.out.printf("%-10s | %-8d | %-5.2f | %6.2f\n",
                    orderItem.getProductName(), orderItem.getQuantity(), orderItem.getPrice(), orderItem.getAmount());
            totalAmount += orderItem.getAmount();
        }
        System.out.printf("Total: %.2f$\n", totalAmount); 
    }
}
