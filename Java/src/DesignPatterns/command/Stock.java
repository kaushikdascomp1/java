package Java.src.DesignPatterns.command;

/*
Request class
 */
public class Stock {

    private String name = "ABC";
    private int quantity = 10;

    public void buy() {
        System.out.println("Stock bought of [" + name + "] with quantity [" + quantity + "]");
    }

    public void sell() {
        System.out.println("Stock sold of [" + name + "] with quantity [" + quantity + "]");
    }
}
