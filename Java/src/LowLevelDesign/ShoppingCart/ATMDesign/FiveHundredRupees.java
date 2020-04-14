package Java.src.LowLevelDesign.ShoppingCart.ATMDesign;

public class FiveHundredRupees implements DispenseChain {

    DispenseChain chain;

    @Override
    public void setNextChain(DispenseChain chain) {
            this.chain = chain;
    }

    @Override
    public void dispense(Currency currency) {
        if(currency.getAmount()>=500){
            int num = currency.getAmount()/500;
            int rem = currency.getAmount()%500;
            System.out.println("Dispensing amount::  "+num+" of 500 rupees notes");
            if(rem != 0)
                chain.dispense(new Currency(rem));
        }else{
            chain.dispense(currency);
        }
    }


}
