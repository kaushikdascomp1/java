package com.interview.java.designpatterns.insertdelsearchrandds;

import java.util.*;

public class DatastructureDesign {

    /*
    Design a datastructure that can isert delete search getRandom in O(1) operation

     */
    Map<Integer, Integer> map;
    List<Integer> arr;

    public static void main(String[] args) {

    }

    public DatastructureDesign(){
        map = new HashMap<>();
        arr = new ArrayList<>();
    }


    public  void addNum(int num){
        if(map.get(num) != null)
            return;

        arr.add(num);
        map.put(num,arr.size());

    }

    public void remove(int num){
        if(map.get(num) != null)
            return;

        int index = map.get(num);
        int size = arr.size();
        Collections.swap(arr,index,size-1);

        Integer num1 = arr.get(size-1);
        arr.remove(size-1);
        map.put(num1,index);
    }

    public int search(int x){

        if(map.get(x)!=null)
            return arr.get(map.get(x));

        return Integer.parseInt(null);
    }

    public int getRandom(){
        Random rand = new Random();
        int index = rand.nextInt(arr.size());

        return arr.get(index);
    }

}
