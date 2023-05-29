package com.interview.matrix;

public class SpiralMatrix {

    /**
     *
     * @param args
     */

    public static void main(String[] args) {

        int mat[][] = {
                {1, 2,  3, 4,5},
                {16,17,18,19,6},
                {15,24,25,20,7},
                {14,23,22,21,8},
                {13,12,11,10,9}};
        //printSpiral(mat);
        System.out.println(generateMatrix(3));

    }

    public static void printSpiral(int[][] mat){
        int top = 0; int right = mat.length-1;
        int left = 0; int bottom = mat[0].length-1; //This is an important step


           /*if (left>right)
               break;*/
           //print top row
           for (int i=left;i<=right;i++)
               System.out.println(mat[0][i]);
           top++;

           for(int i=top;i<=bottom;i++)
               System.out.println(mat[i][right]);

           right--;
           for(int i=right;i>=left;i--)
               System.out.println(mat[bottom][i]);
           bottom--;

           for(int i=bottom;i>=top;i--)
               System.out.println(mat[i][left]);

           left++;

           for(int i=left;i<=right;i++)
               System.out.println(mat[top][i]);
           top++;
    }

    /*
    Given a value n generate and print a spiral matrix

     */

    public static int[][] generateMatrix(int n){
        int[][] mat = new int[n][n];
        int top = 0; int right = mat.length-1;

        int left = 0; int bottom = mat[0].length-1;

        int val = 1;
        int count = 0;
        int tot = n*n;
        while(count < tot){
            //print from left to right
            for(int i=left;i<=right;i++){
                mat[top][i] = val++;
                count++;
            }
            top++;

            //print from top to bottom
            for(int i=top;i<=bottom;i++){
                mat[i][right] = val++;
                count++;
            }
            right--;

            //print from right to left
            for(int i=right;i>=left;i--){
                mat[bottom][i] = val++;
                count++;
            }
            bottom--;

            //print from bottom to top
            for(int i=bottom;i>=top;i--){
                mat[i][left] = val++;
                count++;
            }
            left++;

        }
    return mat;

    }
}
