package DesignPatterns.abstractfactory;

public class FactoryProducer {

    public static AbstractFactory getFactory(boolean rounded){
        if(rounded){
            return new RoundedAbstractFactory();
        }
        return new NormalAbstractFactory();
    }
}
