package com.interview.java.designpatterns.hitcounter;

import java.util.Vector;

public class HitCounter {

    static int hits[];
    static int times[];

    public static final int MAX_DURATION_TRACK = 300;// tracking 300 secs 5mins

    public HitCounter(int maxDuration){
        this.hits = new int[maxDuration];
        this.times = new int[maxDuration];
    }
    //In case of multithreaded environment
    /*
        Receiving more than one hitscounter at the same time stamp
     */

    public static void countHits(int timestamp){
        int idx = timestamp % MAX_DURATION_TRACK;
        if(times[idx] < timestamp){
            times[idx] = timestamp;
            hits[idx] = 1;
        }else {
            hits[idx]++;
        }
    }

    public static int getHitsCounter(int timestamp){
        int count = 0;
        for (int i=0;i<MAX_DURATION_TRACK;i++){
            if(timestamp - times[i]<MAX_DURATION_TRACK)
                count +=hits[i];
        }
        return count;
    }

    //Simple Solution using Brute force
    Vector<Integer> hitscounter = new Vector<>();

    void hit(int timestamp){
        hitscounter.add(timestamp);
    }

    int getHits(int timestamp){
        int i;
        for(i=0; i< hitscounter.size(); i++){
            if(hitscounter.get(i)>timestamp - 300)
                break;
        }
        return hitscounter.size() - i;
    }



}
