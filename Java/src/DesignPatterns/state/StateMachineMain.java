package Java.src.DesignPatterns.state;

public class StateMachineMain {

    public static void main(String[] args) {
        MobileAlertContext mobileAlertContext = new MobileAlertContext();
        MobileAlertState vibrationState = new VibrationState();
        mobileAlertContext.setState(vibrationState);
        mobileAlertContext.doAction();
        mobileAlertContext.doAction();

        MobileAlertState ringerState = new RingerState();
        mobileAlertContext.setState(ringerState);
        mobileAlertContext.doAction();
        mobileAlertContext.doAction();
    }
}
