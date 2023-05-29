package src.com.interview.matrix;

import java.util.Arrays;

public class RotateMatrix90 {
    //Rotate a matrix by 90 degree

    /**
     * Rotation of matrix is done by transpose matrix and then changing rows and collumns
     * @param args
     */
    public static void main(String args[]){
        int arr[][] = new int[][]{{1,2,3},
                                  {4,5,6},
                                  {7,8,9}};
        int m =3;
        int n =3;

        System.out.println("Original Matrix::  ");
        for(int[] row1:arr)
            System.out.println(Arrays.toString(row1));

        int[][] transposeMatrix = transposeMatrix(arr);



        System.out.println("Transpose Matrix::  ");
        for (int[] row : transposeMatrix)
            System.out.println(Arrays.toString(row));

        int[][] matrixRotated = changeCollumns(transposeMatrix);

        System.out.println("90 Matrix::  ");
        for (int[] row : matrixRotated)
            System.out.println(Arrays.toString(row));


    }

    public static int[][] transposeMatrix(int[][] mat){
        int n = mat.length;
        for(int i=0;i<n;i++){
            for (int j=0;j<i;j++){
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
        return mat;
    }

    public static int[][] changeCollumns(int[][] mat){
        int n = mat.length;
        for (int i=0;i<n;i++){
            for(int j=0;j<n/2;j++){
                int temp = mat[i][j];
                mat[i][j] = mat[i][n-j-1];
                mat[i][n-j-1] = temp;
            }
        }
        return mat;
    }

}
