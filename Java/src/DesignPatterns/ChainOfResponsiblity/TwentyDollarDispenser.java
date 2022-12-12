package DesignPatterns.ChainOfResponsiblity;

public class TwentyDollarDispenser implements DispenseChain {

    DispenseChain chain;

    @Override
    public void setNextChain(DispenseChain chain) {
        this.chain = chain;
    }

    @Override
    public void dispense(Currency currency) {
        if(currency.getAmount()>=20){
            int num = currency.getAmount()/20;
            int rem = currency.getAmount()%20;
            System.out.println("Dispensing ::  "+num+" 20$ notes");
            if(rem!=0)
                chain.dispense(new Currency(rem));
        }else {
            this.chain.dispense(currency);
        }
    }
}
