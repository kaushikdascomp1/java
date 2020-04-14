package Java.src.DesignPatterns.ChainOfResponsiblity;

public class TenDollarDispenser implements DispenseChain {

        private DispenseChain chain;

    @Override
    public void setNextChain(DispenseChain chain) {
        this.chain = chain;
    }

    @Override
    public void dispense(Currency currency) {
        if(currency.getAmount()>=10){
            int num = currency.getAmount()/10;
            int rem = currency.getAmount()%10;
            System.out.println("Dispensing::  "+num+ " 10$ notes");
            if(rem != 0)
                chain.dispense(new Currency(rem));
        }else {
            chain.dispense(currency);
        }
    }
}
