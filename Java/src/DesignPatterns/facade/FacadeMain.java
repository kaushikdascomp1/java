package DesignPatterns.facade;

public class FacadeMain {

    public static void main(String[] args) {
        FacadeContext context = new FacadeContext();
        context.addition(1,2);
        context.substraction(2,1);
    }
}
