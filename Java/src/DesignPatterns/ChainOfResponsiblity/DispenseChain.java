package Java.src.DesignPatterns.ChainOfResponsiblity;



public interface DispenseChain {

    void dispense(Currency currency);

    void setNextChain(DispenseChain chain);


}
