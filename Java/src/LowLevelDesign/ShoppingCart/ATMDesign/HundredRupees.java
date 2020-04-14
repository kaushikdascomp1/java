package Java.src.LowLevelDesign.ShoppingCart.ATMDesign;

public class HundredRupees implements DispenseChain {

    DispenseChain chain;

    @Override
    public void setNextChain(DispenseChain chain) {
        this.chain = chain;
    }

    @Override
    public void dispense(Currency currency) {
        if(currency.getAmount()>=100){
            int num = currency.getAmount()/100;
            int rem = currency.getAmount()%100;
            System.out.println("Dispensing amount of:  "+num+"  of 100 rupees notes");
            if(rem !=0)
                chain.dispense(new Currency(rem));
        }else{
            chain.dispense(currency);
        }
    }
}
