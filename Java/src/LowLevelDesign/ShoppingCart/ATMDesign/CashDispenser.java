package Java.src.LowLevelDesign.ShoppingCart.ATMDesign;

import java.util.Map;

public class CashDispenser  {

    private DispenseChain chain;

    public CashDispenser(){
        this.chain = new TwoThousandRupees();
        DispenseChain c2 = new FiveHundredRupees();
        DispenseChain c3 = new HundredRupees();

        chain.setNextChain(c2);
        c2.setNextChain(c3);

    }

    public void withdrawCash(Currency currency){
        CashDispenser dispenser = new CashDispenser();
        if(currency.getAmount()%100 != 0){
            System.out.println("Please enter amounts in multiples of 100:  ");
            //Redirect back to enter amount screen

        }else {
            //Withdraw Cash
            dispenser.chain.dispense(currency);
        }

    }
}
