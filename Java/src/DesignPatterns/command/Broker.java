package Java.src.DesignPatterns.command;

import java.util.ArrayList;
import java.util.List;

/*
This is the command invoker class
 */
public class Broker {

    List<Order> orderList = new ArrayList<>();

    public void takeOrder(Order order){
        this.orderList.add(order);
    }

    public void placeOrder(){
        for(Order ord: orderList){
            ord.execute();
        }
        orderList.clear();
    }

}
