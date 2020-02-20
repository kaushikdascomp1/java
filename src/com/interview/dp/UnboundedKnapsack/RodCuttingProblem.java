package src.com.interview.dp.UnboundedKnapsack;

public class RodCuttingProblem {

    //Given a rod of length n inches and an array of prices that contains prices of all pieces of size smaller than n.
    // Determine the maximum value obtainable by cutting up the rod and selling the pieces.
    // For example, if length of the rod is 8 and the values of different pieces are given as following,
    // then the maximum obtainable value is 22 (by cutting in two pieces of lengths 2 and 6)
    //https://www.geeksforgeeks.org/cutting-a-rod-dp-13/

    public static void main(String[] args) {
        int[] price = {1,   5,   8,   9,  10,  17,  17,  20};
        int[] price1 = {2,6,7,10,13};
        System.out.println(findMin(price1,5));

        System.out.println(solveCutRod(price1,5));
    }

    //Only Price parameter is sufficient because price and length are sequential
    //price    | 1   5   8   9  10  17  17  20  Index 0 has length 1 index 1 has length 2
    private static int findMin(int[] price, int n){
        if(n <= 0)
            return 0;
        int max_val = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            max_val = Math.max(max_val,price[i]+findMin(price,n-i-1));
        }

        return max_val;
    }

    //Top Down Approach Using DP
    private static int cutRod(int[] price, int n, Integer[] val){
        if(n<=0)
            return 0;
        int max_val = Integer.MIN_VALUE;

        if(val[n] != null){
            return val[n];
        }
        for(int i=0;i<n;i++){
            max_val =  Math.max(max_val,price[i]+cutRod(price,n-i-1,val));
        }
        val[n] = max_val;
        return val[n];

    }

    public static int solveCutRod(int[] price, int n){
        Integer[] val = new Integer[n+1];
        return cutRod(price,n,val);
    }




}
