package src.GSCoderPad;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PositionanELementNumber {

    /**
     *
     * Find number of Positional Elements
     * Given a matrix of integers, task is to find out number of positional elements.
     * A positional element is one which is either minimum or maximum in a row or in a column.
     * Input : a = {{1, 3, 4}, {5, 2, 9}, {8, 7, 6}}
     * Output : 7
     * There are total 7 elements min elements are 1, 2, 6 and 4. And max elements are 9, 8 and 7.
     */

    public static void main(String[] args) {
        int arr[][] = {
                {1,3,4,10},
                {5,2,9,11},
                {8,7,6,12}
        };
        findPositional(arr,3,4);
    }

    public static void findPositional(int arr[][], int m, int n){
        Set<Integer> setVal = new HashSet<Integer>();
        for(int i=0;i<m;i++){
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for(int j=0;j<n;j++){
                if(arr[i][j]<min)
                    min = arr[i][j];
                if(arr[i][j]>max)
                    max = arr[i][j];
            }
            setVal.add(min);
            setVal.add(max);
        }

        //Iterate over collumns now:
        for(int i=0;i<n;i++){
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for(int j=0;j<m;j++){
                if(arr[j][i]<min)
                    min = arr[j][i];

                if(arr[j][i]>max)
                    max = arr[j][i];
            }
            setVal.add(min);
            setVal.add(max);
        }
        setVal.stream().forEach(item-> System.out.println(item));
        System.out.println("Number of Positional Elements are : "+setVal.size());
    }
}
