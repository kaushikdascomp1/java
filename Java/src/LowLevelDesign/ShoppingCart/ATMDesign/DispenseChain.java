package Java.src.LowLevelDesign.ShoppingCart.ATMDesign;

public interface DispenseChain {

    void dispense(Currency currency);
    void setNextChain(DispenseChain chain);



}
