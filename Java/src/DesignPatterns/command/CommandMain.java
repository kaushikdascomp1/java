package DesignPatterns.command;

public class CommandMain {

    public static void main(String[] args) {
        //Creating the request class
        Stock stock = new Stock();
        //Creating the command Invoker class
        Broker broker = new Broker();
        //Create commands
        BuyStock buyStock = new BuyStock(stock);
        SellStock sellStock = new SellStock(stock);

        //Tell the command invoker class to take orders in queue
        broker.takeOrder(buyStock);
        broker.takeOrder(sellStock);
        //Command Invoker to invoke
        broker.placeOrder();
    }
}
