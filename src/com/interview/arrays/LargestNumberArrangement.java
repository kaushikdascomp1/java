package src.com.interview.arrays;

import java.util.*;

public class LargestNumberArrangement {

    /**
     * Arrange Given set of numbers to form the largest number
     * Given an array of numbers, arrange them in a way that yields the largest value.
     * For example, if the given numbers are {54, 546, 548, 60}, the arrangement 6054854654 gives the largest value.
     * And if the given numbers are {1, 34, 3, 98, 9, 76, 45, 4}, then the arrangement 998764543431 gives the largest value.
     *
     * https://www.geeksforgeeks.org/given-an-array-of-numbers-arrange-the-numbers-to-form-the-biggest-number/
     * @param args
     */
    public static void main(String[] args) {
            List<String> arr = new ArrayList<>();
            arr.add("54");
            arr.add("546");
            arr.add("548");
            arr.add("60");
            printLargest(arr);
    }

    public static void printLargest(List<String> arr){
        Collections.sort(arr,new Comparator<String>(){

            @Override
            public int compare(String X, String Y) {
                String XY = X+Y;
                String YX = Y+X;

                return XY.compareTo(YX) > 0 ? -1:1;
            }
        });

       arr.forEach(System.out::println);
        Iterator it = arr.iterator();

        while(it.hasNext())
            System.out.print(it.next());

    }
}

