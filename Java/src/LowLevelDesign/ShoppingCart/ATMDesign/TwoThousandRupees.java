package Java.src.LowLevelDesign.ShoppingCart.ATMDesign;

public class TwoThousandRupees implements DispenseChain {

    private DispenseChain chain;

    @Override
    public void setNextChain(DispenseChain chain) {
        this.chain = chain;
    }

    @Override
    public void dispense(Currency currency) {
        if(currency.getAmount()>=2000){
            int num = currency.getAmount()/2000;
            int rem = currency.getAmount()%2000;
            System.out.println("Dispensing Amount::  "+num+" 2000 rupees note");
            if(rem !=0)
                chain.dispense(new Currency(rem));
        }else {
            chain.dispense(currency);
        }
    }
}
