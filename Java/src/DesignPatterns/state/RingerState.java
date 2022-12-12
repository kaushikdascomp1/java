package DesignPatterns.state;

public class RingerState implements MobileAlertState {

    @Override
    public void alert() {
        System.out.println("Ringing....");
    }
}
