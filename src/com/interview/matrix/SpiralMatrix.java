package src.com.interview.matrix;

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
        printSpiral(mat);
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
}
