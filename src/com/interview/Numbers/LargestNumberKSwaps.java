package com.interview.Numbers;



import java.util.*;

public class LargestNumberKSwaps {

    /**
     * Find Maximum number possible by doing at-most K swaps
     * Input: M = 254, K = 1
     * Output: 524
     *
     * Input: M = 254, K = 2
     * Output: 542
     *
     * @param args
     */

    public static void main(String[] args) {
        largestNumberkswaps(254,2);
    }

    public static void largestNumberkswaps(int num, int k){

        List<Integer> numList = new ArrayList<>();
        while (num!=0){
            numList.add(num%10);
            num = num/10;
        }
        List<String> strList = new ArrayList<>();
        numList.stream().forEach(e->strList.add(String.valueOf(e)));

        //To get the largest number
        Collections.sort(strList, new Comparator<String>() {


            @Override
            public int compare(String X, String Y) {
                String XY = X+Y;
                String YX = Y+X;

                return XY.compareTo(YX) > 0 ? -1 : 1;
            }
        });

        numList.stream().forEach(System.out::println);
        System.out.println("Largest Number is:  ");
        strList.stream().forEach(System.out::println);
    }

}
