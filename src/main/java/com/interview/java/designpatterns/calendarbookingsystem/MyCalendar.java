package com.interview.java.designpatterns.calendarbookingsystem;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class MyCalendar {

    TreeMap<Integer, Integer> calendar;

    public MyCalendar(){
        calendar = new TreeMap<>();
    }

    public static void main(String[] args) {
    }
    //
    public boolean book(int start, int end){
        Map.Entry<Integer, Integer> beforeEnd = calendar.lowerEntry(end);
        if(beforeEnd != null && beforeEnd.getValue() > start){
            return false;
        }

        calendar.put(start,end);
        return true;
    }
}
