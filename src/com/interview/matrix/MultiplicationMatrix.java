package src.com.interview.matrix;

public class MultiplicationMatrix {

    //https://www.programiz.com/java-programming/examples/multiply-matrix

    public static void main(String[] args) {
        int[][] firstMatrix = { {3, -2, 5}, {3, 0, 4} };
        int[][] secondMatrix = { {2, 3}, {-9, 0}, {0, 4} };
        multiply(firstMatrix,secondMatrix);
    }

    public static void multiply(int[][] A, int[][] B){
        // FOr multiplication to take place
        // c1 should be equal to r2
        //And the final o/p matrix is of size [r1*c2]
        int r1 = A.length;
        int c1 = A[0].length;

        int r2 = B.length;
        int c2 = B[0].length;

        int C[][] = new int[r1][c2];

        for(int i=0;i<r1;i++){
            for(int j=0;j<c2;j++){
                for (int k=0;k<c1;k++){
                    C[i][j]+=A[i][k]*B[k][j];
                }
            }
        }

        //Printing the matrix
        for(int[] row: C){
            for (int column:row){
                System.out.print(column+ " ");
            }
            System.out.println();
        }
    }
}
