package Java.src.DesignPatterns.ChainOfResponsiblity;

public class FiftyDollarDispenser implements DispenseChain{

    DispenseChain chain;

    @Override
    public void setNextChain(DispenseChain chain) {
            this.chain = chain;
    }

    @Override
    public void dispense(Currency currency) {
        if(currency.getAmount()>=50){
            int num = currency.getAmount()/50;
            int rem = currency.getAmount()%50;
            System.out.println("Dispensing::   "+num+" 50$");
            if(rem != 0)
                chain.dispense(new Currency(rem));
        }else{
            chain.dispense(currency);
        }
    }
}
