package src.com.interview.arrays;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

    /*
        Given a sorted integer array without duplicates, return the summary of its ranges for
         consecutive numbers.
        For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
     */

    public static void main(String[] args) {

    }

    public static void summaryRanges(int[] arr){
        if(arr.length<=0)
            return;
        List<String > output = new ArrayList<>();
        StringBuilder range = new StringBuilder();
        for (int i=1;i<arr.length;i++){

            if(i>0 && arr[i]==arr[i-1]+1){
                range.append(arr[i-1]);
            }else {
                range = new StringBuilder();
                range.append(arr[i]);
            }
        }
    }
}
