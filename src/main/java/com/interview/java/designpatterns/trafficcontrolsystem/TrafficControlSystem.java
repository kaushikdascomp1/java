package com.interview.java.designpatterns.trafficcontrolsystem;

public class TrafficControlSystem implements Runnable {

    public final static int BUTTON_THRESHOLD = 1;

    public LightColor state;
    public int stateSecondsRemaining;

    //If you want to run the TCS for specific number of times use a for loop
    @Override
    public void run() {
        //for loop to run specific number of times
        while (true) {
            try {
                Thread.sleep(1000);
                this.secondElapsed();
            } catch (InterruptedException e) {

                e.printStackTrace();
            }
        }
    }

    public void buttonPressed() {

        if (this.stateSecondsRemaining > BUTTON_THRESHOLD)
            this.stateSecondsRemaining = BUTTON_THRESHOLD;

    }

    public TrafficControlSystem() {
        this.switchToState(LightColor.RED);
    }

    public void secondElapsed() {
        this.stateSecondsRemaining--;
        System.out.println("Seconds Remaining:: " + this.stateSecondsRemaining);
        if (this.stateSecondsRemaining == 0) {
            switch (this.state) {
                case RED:
                    switchToState(LightColor.YELLOW);
                    break;
                case YELLOW:
                    switchToState(LightColor.GREEN);
                    break;
                case GREEN:
                    switchToState(LightColor.RED);
                    break;
            }
        }

    }

    public void switchToState(LightColor state) {
        System.out.println("Traffic signal turns " + state);
        this.state = state;
        this.stateSecondsRemaining = state.durationInSeconds;
    }
}
