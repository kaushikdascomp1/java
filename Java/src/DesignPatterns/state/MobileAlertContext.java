package Java.src.DesignPatterns.state;

public class MobileAlertContext {

    MobileAlertState state;

    public void setState(MobileAlertState state) {
        this.state = state;
    }

    public void doAction(){
        this.state.alert();
    }
}
