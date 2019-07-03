package src.GSCoderPad;

public class PanagramDetector {

    static boolean mark[] = new boolean[26];

    public static void main(String[] args) {
        String str = "The quick brown fox jumps over the lazy dog";
        System.out.println(panagramCheck(str));

    }

    public static boolean panagramCheck(String str){
        int index=-1;
        for(int i=0;i<str.length();i++){
            if('A'<= str.charAt(i) && str.charAt(i) <= 'Z'){
                index=str.charAt(i)-'A';
            }else if('a'<=str.charAt(i) && str.charAt(i) <= 'z'){
                index=str.charAt(i)-'a';
            }
            mark[index]=true;
        }

        for(int i=0;i<=25;i++){
            if(mark[i]==false){
                System.out.println("Not a Pangram");
                return false;
            }
        }

        return true;
    }
}
