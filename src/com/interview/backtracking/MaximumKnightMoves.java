package src.com.interview.backtracking;

public class MaximumKnightMoves {

    public static void main(String[] args) {
        MaximumKnightMoves knightMoves = new MaximumKnightMoves();
        knightMoves.solveKT();
    }

    //A knight can move in 8 different directions, each direction 2 ways
    public static int N = 8;

    boolean isSafe(int mat[][], int x, int y){
        return (x>=0 && x<N && y>=0 && y<N && mat[x][y] == -1);
    }

    boolean solveKT(){
        int mat[][] = new int[8][8];

        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                mat[i][j] = -1;
            }
        }

        int x_move[] = {2,1,-1,-2,-2,-1,1,2};
        int y_move[] = {1,2,2,1,-1,-2,-2,-1};
        mat[0][0] = 0;
        if(!solveKTUtil(0,0,1,mat,x_move,y_move)){
            System.out.println("Solution doesn't exist:: ");
            return false;
        }else {
            printSol(mat);
        }
        return true;

    }

    void printSol(int mat[][]){
        for (int x=0;x<N;x++){
            for (int y=0;y<N;y++){
                System.out.println(mat[x][y]);
            }
        }
    }

    boolean solveKTUtil(int x, int y, int movei, int mat[][], int x_move[], int y_move[]){
        //int k, next_x, next_y;

        if(movei == N*N)
            return true;
        for(int k=0;k<8;k++){
            int next_x = x + x_move[k];
            int next_y = y + y_move[k];
            if (isSafe(mat,next_x,next_y)){
                mat[next_x][next_y] = movei;
                if(solveKTUtil(next_x,next_y,movei+1,mat,x_move,y_move))
                    return true;
                else
                    mat[next_x][next_y] = -1;
            }
        }
        return false;
    }





}
