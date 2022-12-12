package Strings;

public class Reconstruct {

    public static void main(String[] args) {
        String s = "owoztneoer";
        System.out.println(reconstruct(s));
    }

    /*
        Z zero 0
        X six 6
        U four 4
        W two 2
        G eight 8
        F four + five 4 & 5
        O one+two+four+zero 1 & 2 & 4 & 0
        T three + eight+two 3 & 8 & 2
        S seven + six 6 & 7
        I nine + five + six+eight
     */
    public static String reconstruct(String str){
           int[] map = new int[26];
           for(char c: str.toCharArray())
               map[c-'a']++;
           int[] digit = new int[10];
           digit[0] = map['z'-'a'];
           digit[6] = map['x'-'a'];
           digit[4] = map['u'-'a'];
           digit[2] = map['w'-'a'];
           digit[8] = map['g'-'a'];
           digit[5] = map['f'-'a'] - digit[4];
           digit[7] = map['s'-'a'] - digit[6];
           digit[1] = map['o'-'a'] - digit[2] - digit[4] - digit[0];
           digit[3] = map['t'-'a'] - digit[8] - digit[2];
           digit[9] = map['i' - 'a'] - digit[5] -digit[6] -digit[8];

           StringBuilder stringBuilder = new StringBuilder();
           for(int i=0;i<10;i++){
               int freq= digit[i];
               while (freq>0){
                   stringBuilder.append(i);
                   freq--;
               }
           }
           return stringBuilder.toString();
    }
}
