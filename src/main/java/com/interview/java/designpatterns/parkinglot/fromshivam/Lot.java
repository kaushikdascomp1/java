package com.interview.java.designpatterns.parkinglot.fromshivam;

import lombok.Data;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
@Data
public class Lot {

    private static Lot lot = null;

    private static final int NUMBER_OF_SMALL_SLOTS = 10;
    private static final int NUMBER_OF_COMPACT_SLOTS = 10;
    private static final int NUMBER_OF_LARGE_SLOTS = 10;

    public Map<Integer, Slot> occupiedSlots;
    private List<Slot> smallSlots;
    private List<Slot> compactSlots;
    private List<Slot> largeSlots;

    public Lot(){
        smallSlots = new LinkedList<>();
        compactSlots = new LinkedList<>();
        largeSlots = new LinkedList<>();
        occupiedSlots = new HashMap<>();
        for(int i=0;i<NUMBER_OF_SMALL_SLOTS;i++){
            smallSlots.add(new Slot(i,1));
        }

        for(int i=0;i<NUMBER_OF_COMPACT_SLOTS;i++){
            compactSlots.add(new Slot(i,2));
        }

        for(int i=0;i<NUMBER_OF_LARGE_SLOTS;i++){
            largeSlots.add(new Slot(i,3));
        }
    }

    public static Lot getInstance(){
        if(lot == null)
            lot = new Lot();
        return lot;
    }

}
