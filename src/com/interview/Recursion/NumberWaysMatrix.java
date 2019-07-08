package src.com.interview.Recursion;

public class NumberWaysMatrix {

    /**
     * Find the number of ways in which you can move from one cell to another in a chess box
     *
     * @param args
     */

    public static void main(String args[]) {
        System.out.println(countWays(3, 3));
        System.out.println(countWaysImproved(3, 3));
    }

    public static int countWays(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }
        return countWays(m - 1, n) + countWays(m, n - 1);
        //+countWays(m-1,n-1)  -- If diagonal movements are allowed
        //Time complexity is exponential for this as there are many overlapping sub-problems which we are computing againand again
    }

    public static int countWaysImproved(int m, int n) {
        int arr[][] = new int[m][n];
        for (int i = 0; i < m; i++)
            arr[i][0] = 1;

        for (int j = 0; j < n; j++)
            arr[0][j] = 1;

        for (int k = 1; k < m; k++) {
            for (int l = 1; l < n; l++) {
                arr[k][l] = arr[k - 1][l] + arr[k][l - 1];
                //If diagonal is allowed +arr[k-1][l-1]
            }
        }
        return arr[m - 1][n - 1];
    }

    //Time complexity of the above solution is O(mn)

}
