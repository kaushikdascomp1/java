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

    public static int findMinimumRecur(int[] num, int sum, int currentIndex){
        //base conditions
        if(null == num || num.length == 0){
            return -1;
        }

        if(sum == 0){
            return 1;
        }
        //either you exclude it or include it
        int count1 = 0;
        if(num[currentIndex] <= sum){
            count1 = findMinimumRecur(num, sum-num[currentIndex], currentIndex+1);
        }
        int count2 = findMinimumRecur(num, sum, currentIndex+1);
        return Math.min(count1, count2);

    }
}
