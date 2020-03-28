package src.com.interview.Strings;

public class LongestPalindromeSubstring {


    public static void main(String args[]){
        String str= "forgeeksskeegfor";
        findLongest(str);
    }

    public static void findLongest(String str){
        int n=str.length();

        boolean table[][] = new boolean[n+1][n+1];
        // for strings of length 1 each substring at (0,0), (1,1), (2,2)...(n,n) will be 1
        int maxlength = 1;
        for(int i=0;i<n;i++)
            table[i][i] = true;

       int start = 0;
        for(int i=0;i<n-1;i++){
            if(str.charAt(i)==str.charAt(i+1)){
                table[i][i+1]=true;
                start=i;
                maxlength=2;
            }
        }

        // for strings of length>3

        for(int k=3;k<=n;k++){
            for(int i=0;i<n-k+1;i++){
                int j=i+k-1;
                if(table[i+1][j-1] && str.charAt(i)==str.charAt(j)){
                    table[i][j]=true;
                    if(k>maxlength){
                        maxlength=k;
                        start=i;
                    }
                }
            }
        }

        substring(str,start,start+maxlength-1);

    }

    public static void substring(String str, int low, int high){
        System.out.println(str.substring(low,high+1));
    }
}
