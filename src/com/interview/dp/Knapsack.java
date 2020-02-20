package src.com.interview.dp;

public class Knapsack {

    public static void main(String[] args) {
       int W[] = {10, 20, 30};
       int val[] = {60, 100, 120};
        System.out.println(knapsack(50,3,W,val));
        System.out.println(knapsackDP(50,3,W,val));

    }
    //Including two cases
    // Either we exclude the n-1 item as elements are in sorted order or we include the n-1 item
    public static int knapsack(int c, int n, int[] W, int[] val){
        if(c==0 || n==0)
            return 0;
        if(W[n-1]>c)
            return knapsack(c,n-1,W,val);
        else
            return Math.max(knapsack(c-W[n-1],n-1,W,val)+val[n-1],knapsack(c,n-1,W,val));
    }

    //The above recursive solution is expensive with optimal sub structure problems solving again and again
    //Time complexity of the above is O(2^n)

    //Using DP the optimal sub structure problem can be reduced to O(nW)

    public static int knapsackDP(int c, int n, int[] W, int[] val){
        int[][] K = new int[n+1][c+1];

        for(int i=0;i<=n;i++){
            for(int w=0;w<=c;w++){
                if(i==0 || w==0)
                    K[i][w] = 0;
                else if(W[i-1]<=c)
                    K[i][w] =  Math.max(val[i-1]+ K[i-1][c-W[i-1]],K[i-1][w]);
                else
                    K[i][w] = K[i-1][w];
            }
        }
        return K[n][c];
    }

}
