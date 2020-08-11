package src.com.interview.graph;

public class WordSearchAmazon {

    /**
     * https://www.gohired.in/2019/10/16/leetcode-word-search/
     *
     * Given a 2D board and a word, search if the word exists in the grid
     * Example:
     * board =
     * [
     * [‘Q', ‘U', ‘I', ‘J'],
     * [‘O', ‘F', ‘C', ‘E'],
     * [‘X', ‘U', ‘K', ‘M'] ]
     *
     * Given word = “QUICK”, return true.
     * Given word = “ICE”, return true.
     * Given word = “QUFM”, return false.
     * @param args
     *
     * Usinf DFS it can be solved
     */

    public static void main(String[] args) {
            char[][] board = {
                    {'Q', 'U', 'I', 'J'},
                    {'O','F','C','E'},
                    {'X','U','K','M'}
            };
        System.out.println(findWord(board,"QUICK"));
        System.out.println(findWord(board,"QUFM"));
    }

    public static boolean findWord(char[][] board, String word){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j] == word.charAt(0) && dfs(board, i, j,0, word))
                    return true;
            }
        }
        return false;
    }

    public static boolean dfs(char[][] board, int i, int j, int count, String word){
        //check boundary conditions
        if(count == word.length())
            return true;
        if(i<0 || i>= board.length || j<0 || j>=board[i].length || board[i][j] != word.charAt(count))
            return false;
        //Instead of using the visited flag we use this so that we don't recur into a loop
        char temp = board[i][j];
        board[i][j] = ' ';
        boolean found = dfs(board, i+1, j, count+1, word) ||
                dfs(board,i-1,j,count+1,word) ||
                dfs(board, i, j+1, count+1, word) ||
                dfs(board, i, j-1, count+1, word);
        board[i][j] = temp;

        return found;
    }

}
