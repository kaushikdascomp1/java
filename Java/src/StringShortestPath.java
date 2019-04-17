import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class StringShortestPath {


    public static void main(String[] args) {
        String s = "geek";
        System.out.println(printDistinctPermutn(s, "", new ArrayList<String>()));
    }


    public static void findShortest(Set<String> listStr, String src, String dest){

        char srcArray[] = src.toCharArray();
        char destArray[] = dest.toCharArray();


        //
        // Get list of all permutations of src string
        for(String permutations : listStr){
          int distance = editDist(src,permutations, src.length(),permutations.length());
          if(distance == 1 && !src.equals(dest)){
          }else if(distance == 1 && src.equals(dest)){
              System.out.println("Shortest Path");
          }
        }


    }

    static int min(int x,int y,int z)
    {
        if (x<=y && x<=z) return x;
        if (y<=x && y<=z) return y;
        else return z;
    }

    static int editDist(String str1 , String str2 , int m ,int n)
    {
        if (m == 0) return n;

        if (n == 0) return m;

        // If last characters of two strings are same, nothing
        // much to do. Ignore last characters and get count for
        // remaining strings.
        if (str1.charAt(m-1) == str2.charAt(n-1))
            return editDist(str1, str2, m-1, n-1);

        // If last characters are not same, consider all three
        // operations on last character of first string, recursively
        // compute minimum cost for all three operations and take
        // minimum of three values.
        return 1 + min ( editDist(str1,  str2, m, n-1),    // Insert
                editDist(str1,  str2, m-1, n),   // Remove
                editDist(str1,  str2, m-1, n-1) // Replace
        );
    }

    public static ArrayList<String> printDistinctPermutn(String str, String ans, ArrayList<String> arrList){

            if(str.length() == 0){
                arrList.add(ans);
                return arrList;
            }

            boolean alpha[] = new boolean[26];


        for(int i=0; i<str.length();i++){
          char ch = str.charAt(i);
          String ros = str.substring(0,i) + str.substring(i+1);
            if (alpha[ch - 'a'] == false)
                printDistinctPermutn(ros, ans + ch,arrList);
            alpha[ch - 'a'] = true;

        }

        return arrList;
    }
}
