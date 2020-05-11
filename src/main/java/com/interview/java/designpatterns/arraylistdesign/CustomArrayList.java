package com.interview.java.designpatterns.arraylistdesign;

public class CustomArrayList {

    private static final int SIZE_FACTOR = 10;

    private int index = 0;
    private int size;

    private Object data[];

    public CustomArrayList() {
        this.data = new Object[SIZE_FACTOR];
        this.size = SIZE_FACTOR;
    }

    public void add(Object object) {
        if (index == size - 1) {
            //reinitialize array
            incrementSizeAndReAllocate();
        }
        data[index++] = object;
    }

    private void incrementSizeAndReAllocate() {
        size = size + SIZE_FACTOR;
        Object newData[] = new Object[size];

        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }

        data = newData;
    }

    public Object get(int ind) throws Exception {
        if (ind < 0) {
            throw new Exception("Index cannot be negative::  ");
        } else if (ind > index - 1) {
            throw new Exception("Array index Out of Bound Exception  ");
        }

        return data[ind];
    }

    public void remove(int ind) throws Exception {
        if (ind < 0) {
            throw new Exception("Index cannot be negative::  ");
        } else if (ind > index - 1) {
            throw new Exception("Index Not Found::  ");
        }

        for (int i = ind; i < data.length - 1; i++) {
            data[i] = data[i + 1];
        }
        index--;
    }


    public static void main(String[] args) throws Exception {
        CustomArrayList arrList = new CustomArrayList();
        arrList.add("0");
        arrList.add("1");
        arrList.add("2");
        arrList.add("3");
        arrList.add("4");

        arrList.remove(3);
        System.out.println(arrList.get(3));
    }

}
