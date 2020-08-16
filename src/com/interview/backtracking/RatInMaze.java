package src.com.interview.backtracking;

public class RatInMaze {

    public static int N ;

    public static void main(String[] args) {
        int maze[][] = { { 1, 0, 0, 0 },
                { 1, 1, 0, 1 },
                { 0, 1, 0, 0 },
                { 1, 1, 1, 1 } };
        N = maze.length;
        findSolution(maze);
    }

    public static boolean findSolution(int[][] mat){
        int[][] soltion = new int[N][N];
        if(!solveMazeUtil(mat,0,0,soltion)){
            System.out.println("Solution doesn't exist::   ");
            return false;
        }

        printSolutionMatrix(soltion);
        return true;
    }

    public static boolean solveMazeUtil(int[][] mat, int m, int n, int[][] sol){
        // Check if goal is reached
        if(m == N-1 && n == N-1 && mat[m][n] == 1){
            sol[m][n] = 1;
            return true;
        }

        if(isSafe(mat, m, n)){
            //Marking visited node as true
            sol[m][n] = 1;

            //Move right
            if(solveMazeUtil(mat, m+1, n, sol))
                return true;
            //Move Bottom
            if (solveMazeUtil(mat,m,n+1,sol))
                return true;

            sol[m][n] = 0;
            return false;
        }
        return false;

    }

    public static boolean isSafe(int[][] mat, int m, int n){
        if(m >= 0 && m < N && n>=0 && n<N && mat[m][n] == 1)
            return true;
        return false;
    }

    private static void printSolutionMatrix(int[][] solution){
        for (int i=0;i<N;i++){
            for (int j=0;j<N;j++){
                System.out.print(solution[i][j]+" ");
            }
            System.out.println();
        }
    }
}
