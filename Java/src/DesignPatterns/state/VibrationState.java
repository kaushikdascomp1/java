package Java.src.DesignPatterns.state;

public class VibrationState implements MobileAlertState {


    @Override
    public void alert() {
        System.out.println("Vibrating.....");
    }
}
