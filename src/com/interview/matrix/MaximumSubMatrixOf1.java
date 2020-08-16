package src.com.interview.matrix;

public class MaximumSubMatrixOf1 {

    public static void main(String[] args) {
        int M[][] = {{0, 1, 1, 0, 1},
                {1, 1, 0, 1, 0},
                {0, 1, 1, 1, 0},
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0}};

        maxSubMatrix(M);
    }

    public static void maxSubMatrix(int[][] mat){
        int R = mat.length;
        int C = mat[0].length;
        System.out.println("Rows are:: "+R+"  :: Collumns::  "+C);
        int[][] S = new int[R][C];

        for(int i=0;i<R;i++){
            S[i][0] = mat[i][0];
        }

        for(int j=0;j<C;j++){
            S[0][j] = mat[0][j];
        }

        for(int i=1;i<R;i++){
            for(int j=1;j<C;j++){
                if(mat[i][j] == 1){
                    S[i][j] = Math.min(S[i][j-1],Math.min(S[i-1][j],S[i-1][j-1]))+1;
                }else {
                    S[i][j] = 0;
                }
            }
        }

        int max_i= 0;
        int max_j = 0;
        int max_S = S[0][0];

        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(S[i][j]>max_S){
                    max_S = S[i][j];
                    max_i = i;
                    max_j = j;
                }
            }
        }

        for(int i=max_i;i>max_i-max_S;i--){
            for(int j=max_j;j>max_j-max_S;j--){
                System.out.print(S[i][j]+" ");
            }
            System.out.println();
        }

    }


}
