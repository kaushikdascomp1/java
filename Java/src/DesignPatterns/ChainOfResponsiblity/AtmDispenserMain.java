package Java.src.DesignPatterns.ChainOfResponsiblity;

import java.util.EnumMap;
import java.util.Scanner;

public class AtmDispenserMain {

    private DispenseChain chain;

    public AtmDispenserMain(){
       this.chain = new FiftyDollarDispenser();
       DispenseChain c2 = new TwentyDollarDispenser();
       DispenseChain c3 = new TenDollarDispenser();

       chain.setNextChain(c2);
       c2.setNextChain(c3);

    }

    public static void main(String[] args) {


       AtmDispenserMain dispenserMain = new AtmDispenserMain();

       int amount = 0;
        System.out.println("Enter amount to dispense:");
        Scanner in = new Scanner(System.in);
        amount = in.nextInt();
        if(amount%10 != 0)
            System.out.println("Amount should be in units of 10:");
        else{
            //use enum map
           // EnumMap<>
            dispenserMain.chain.dispense(new Currency(amount));
        }


    }

}
