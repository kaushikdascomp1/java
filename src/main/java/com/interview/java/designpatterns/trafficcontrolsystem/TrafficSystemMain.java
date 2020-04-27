package com.interview.java.designpatterns.trafficcontrolsystem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class TrafficSystemMain {
    public static Logger log = LoggerFactory.getLogger(TrafficControlSystem.class);

    public static void main(String[] args) {
        Random random = new Random(10);
        TrafficControlSystem controlSystem = new TrafficControlSystem();
        Thread th = new Thread(()->{
           while (true){
               try {
                   Thread.sleep(1000);
                   controlSystem.secondElapsed();
               }catch (InterruptedException ex){
                   ex.printStackTrace();
               }
           }


        });

        Thread th2 = new Thread(controlSystem);

        th2.start();
        try {
            Thread.sleep(15000);

        }catch (InterruptedException ex){
            ex.printStackTrace();
        }


    }
}
