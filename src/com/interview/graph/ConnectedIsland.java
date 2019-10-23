package src.com.interview.graph;

public class ConnectedIsland {
    /**
     * https://www.geeksforgeeks.org/find-number-of-islands/
     * Given a boolean 2D matrix, find the number of islands.
     * A group of connected 1s forms an island. For example, the below matrix contains 5 islands
     */
    static int ROW_NUM = 5;
    static int COL_NUM = 5;

    public static void main(String[] args) {
        int M[][] = new int[][] { { 1, 1, 0, 0, 0 },
                                  { 0, 1, 0, 0, 1 },
                                  { 1, 0, 0, 1, 1 },
                                  { 0, 0, 0, 0, 0 },
                                  { 1, 0, 1, 0, 1 } };
        ConnectedIsland island = new ConnectedIsland();
        int countIslands = island.countIslands(M);
        System.out.println(countIslands);

    }

    public int countIslands(int M[][]){
        boolean visited[][] = new boolean[ROW_NUM][COL_NUM];

        int count = 0;
        for(int i=0;i<ROW_NUM;i++){
            for(int j=0;j<COL_NUM;j++){
                if(M[i][j] == 1 && !visited[i][j]){
                    dfsUtil(M, i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfsUtil(int[][] M, int row_num, int col_num, boolean[][] visited) {

        int ROW[] = new int[]{0, 1, 1, 1, 0,-1,-1,-1};
        int COL[] = new int[]{1, 1, 0,-1,-1,-1, 0, 1};

        //Mark the current cell as visited
        visited[row_num][col_num] = true;
        //Iterate for 8 different positions for each cell to check if any connected node is present

        for(int k=0;k<8;k++){
            if(isSafe(M, row_num + ROW[k], col_num + COL[k], visited)){
                dfsUtil(M, row_num+ROW[k], col_num+COL[k], visited);
            }
        }
    }

    private boolean isSafe(int[][] M, int row_num, int col_num, boolean[][] visited) {
        //Check the conditions that the max 8 cells corresponding to it should be within the limits
        return (row_num >=0 && row_num < ROW_NUM) && (col_num >= 0 && col_num < COL_NUM) && (M[row_num][col_num] == 1
                && !visited[row_num][col_num]);
    }


}
