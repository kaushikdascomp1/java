package src.com.interview.Recursion;

public class MinCoinsRequired {

    /**
     * Minimum number of coins required to make a given value
     * https://www.geeksforgeeks.org/find-minimum-number-of-coins-that-make-a-change/
     * Input: coins[] = {25, 10, 5}, V = 30
     * Output: Minimum 2 coins required
     *
     */

    public static void main(String[] args) {
        int[] coins = {25,10,5};
        System.out.println(findMinimum(coins,3,30));
    }

    public static int findMinimum(int[] coins, int n, int v){
            if(v == 0)
                return 0;
            int min = Integer.MAX_VALUE;
            for(int i=0;i<n;i++){
                if(coins[i]<=v){
                    int min_res = findMinimum(coins,n,v-coins[i]);
                    if(min_res != Integer.MAX_VALUE && min_res+1<min)
                        min = min_res+1;
                }
            }

            return min;

    }
}
