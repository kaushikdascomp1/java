package src.com.interview.arrays;

public class MaximumSumRectangle {

    public static void main(String[] args) {
        int arr[][] = new int[][] {{1, 2, -1, -4, -20},
                {-8, -3, 4, 2, 1},
                {3, 8, 10, 1, 3},
                {-4, -1, 1, 7, -6}};
        System.out.println(maxRectangle(arr));
    }

    public static int maxRectangle(int[][] mat){
        int m = mat.length;
        int n = mat[0].length;

        //creating a temporary array first
        int[][] preSum = new int[m][n];
        int max = 0;
         for(int is=0;is<m;is++){
             for(int j=0;j<n;j++){
                 preSum[is][j] = mat[is][j];
             }
         }


         for(int i=0;i<m;i++){
             int sum = kadene(i,preSum);
             max = Math.max(max,sum);

             if(i+1<m){
                 for(int j=0;j<n;j++){
                     preSum[i+1][j] = preSum[i][j] + mat[i+1][j];
                 }
             }
         }

         return max;
    }

    public static int kadene(int r, int[][] preSum){
        int[] arr = preSum[r];

        int max = 0;
        int sum = 0;

        for(int i=0;i<arr.length;i++){
            sum = Math.max(sum, sum+arr[i]>0 ? sum+arr[i]:0);
            max = Math.max(sum,max);
        }

        return max;
    }
}
