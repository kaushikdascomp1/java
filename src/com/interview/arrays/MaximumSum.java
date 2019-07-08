package src.com.interview.arrays;

import java.util.ArrayList;

public class MaximumSum {
    /**
     * Maximum Value such that no two elements are adjacent
     * <p>
     * We take two variables
     * incl and excl
     * incl=excl+arr[i] -- Current element +excl
     * max(incl, excl)
     *
     * @param args
     */
    public static void main(String args[]) {
        int arr[] = new int[]{5, 5, 10, 100, 10, 5};
        System.out.println(maxElement(arr));
    }

    public static int maxElement(int arr[]) {

        int incl = arr[0];
        int excl = 0;
        int excl_new = 0;
        for (int i = 1; i < arr.length; i++) {
            excl_new = incl > excl ? incl : excl;
            incl = excl + arr[i];
            excl = excl_new;
        }

        return incl > excl ? incl : excl;
    }
}
