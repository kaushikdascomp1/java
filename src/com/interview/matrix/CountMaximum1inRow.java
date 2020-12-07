package src.com.interview.matrix;

public class CountMaximum1inRow {

    /*
    https://www.geeksforgeeks.org/find-the-row-with-maximum-number-1s/
    Given a 2D matrix containing 0's and 1's find the row with maximum 1's
     */

    public static void main(String[] args) {

    }

    public static int findIndex(int[] arr, int lo, int hi){
        //base conditions
        if(null == arr || arr.length<=0)
            return -1;
        if(hi<lo)
            return -1;
        int mid = (lo + (hi-lo))/2;

        if((mid == 0 || arr[mid-1] == 0) && arr[mid] == 1)
            return mid;
        else if(arr[mid] == 0)
            return findIndex(arr,mid+1,hi);
        return findIndex(arr,lo,mid-1);
    }

    public int rowWithMax1(int[][] mat){
        int col = mat[0].length;
        int row = mat.length;

        int max = Integer.MIN_VALUE;
        for(int i=0;i<row;i++){
            int index = findIndex(mat[i],0,col-1);
            if(index != -1 && col-index > max)
                max = col-index;

        }
        return max;
    }
}
