public class PalindromicSubsequence {

    public static void main(String[] args) {
        String n = "aaaaa";
        String m = "bbb";
        findSubsequence(n,m);
    }

    public static int findSubsequence(String s1, String s2){
        if (s1.length() <= s2.length())
        {
            return -1;
        }

        int count =0;
        String x, y;
        char yArr[]= new char[256];
        char xArr[] = new char[256];
        if(s1.length()%2!=0){
            x=s1.substring(0,s1.length()/2);
            y=s1.substring(s1.length()/2+1);

            StringBuilder input1 = new StringBuilder();
            input1.append(y);
            input1 = input1.reverse();
             xArr= x.toCharArray();
             yArr = y.toCharArray();
        }else if(s1.length()%2==0){
            x=s1.substring(0,s1.length()/2);
            y=s1.substring(s1.length()/2);
            StringBuilder input1 = new StringBuilder();
            input1.append(y);
            input1 = input1.reverse();
             xArr = x.toCharArray();
             yArr = y.toCharArray();
        }

        for(int i=0;i<s1.length();i++)
            if(xArr[i]!=yArr[i])
                count++;

            return count;
    }

}
