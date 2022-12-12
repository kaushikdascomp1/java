package com.interview.java.designpatterns.parkinglot.fromshivam;

public class Vehicle {

    private int size;
    private int licence;
    private boolean status;
    private Lot lot;


    public Vehicle(int size){
        this.size = size;
        licence = this.hashCode();
        lot = Lot.getInstance();
    }

    public boolean getStatus(){
        return this.status;
    }

    private Slot findSlot(){
        Slot slot;
        switch (this.size){
            case 1:
                slot = lot.getSmallSlots().remove(0);
                break;
            case 2:
                slot = lot.getCompactSlots().remove(0);
                break;
            case 3:
                slot = lot.getLargeSlots().remove(0);
                break;
            default:
                slot = null;
        }
        return slot;
    }

    public void park(){
        Slot slot = findSlot();
        if(slot != null){
            lot.occupiedSlots.put(this.licence, slot);
            slot.occupy(this);
        }
    }

    public void leave(){
        Slot slot = lot.occupiedSlots.remove(this.licence);
        slot.release();
        switch (this.size){
            case 1:
                lot.getSmallSlots().add(slot);
                break;
            case 2:
                lot.getCompactSlots().add(slot);
                break;
            case 3:
                lot.getLargeSlots().add(slot);
                break;

        }
    }
}
