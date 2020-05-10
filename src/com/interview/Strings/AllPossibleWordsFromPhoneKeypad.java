package src.com.interview.Strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class AllPossibleWordsFromPhoneKeypad {

    /*
        Given phone digits, print all possible words that can be formed from them.
        https://www.geeksforgeeks.org/find-possible-words-phone-digits/
        We will use internally the all permutations of a string
        Input number: 234
        Output:
        adg adh adi aeg aeh aei afg afh
        afi bdg bdh bdi beg beh bei bfg
        bfh bfi cdg cdh cdi ceg ceh cei
        cfg cfh cfi
     */

    public static Map<Integer, String> keyPadMap;

    public AllPossibleWordsFromPhoneKeypad(){
        keyPadMap = new HashMap<>();
        keyPadMap.put(2,"abc");
        keyPadMap.put(3,"def");
        keyPadMap.put(4,"ghi");
        keyPadMap.put(5,"jkl");
        keyPadMap.put(6,"mno");
        keyPadMap.put(7,"pqrs");
        keyPadMap.put(8,"tuv");
        keyPadMap.put(9,"wxyz");
    }
    //adg adh adi aeg aeh aei afg afh
    //afi bdg bdh bdi beg beh bei bfg
    //bfh bfi cdg cdh cdi ceg ceh cei
    //cfg cfh cfi

    public static void main(String[] args) {
        AllPossibleWordsFromPhoneKeypad keypad = new AllPossibleWordsFromPhoneKeypad();
        //keypad.search(234);
        int num = 234;
        Stack<Integer> stack = new Stack<>();
        while(num>0){
            stack.push(num%10);
            num = num/10;
        }
        StringBuilder stringBuilder = new StringBuilder();
        keypad.backtrack(stack,stringBuilder);
    }


    private void search(int num){
        Stack<Integer> stack = new Stack<>();
        while(num>0){
             stack.push(num%10);
             num = num/10;
        }
        while (!stack.isEmpty()){
            String word = keyPadMap.get(stack.pop());
            if(!word.isEmpty()){
                permute(word,0,word.length()-1);
            }
        }

    }

    private void backtrack(Stack<Integer> stack, StringBuilder path){
        if (!stack.isEmpty()){
            String word = keyPadMap.get(stack.pop());
            for (int i = 0; i < word.length(); i++) {
                path.append(word.charAt(i));
                backtrack(stack,path);
               //path.deleteCharAt(i);
            }
        }else {
            System.out.println(path);
            return;
        }


    }

    private void permute(String str, int l, int r){
        if(str.isEmpty())
            return;
        if(l == r){
            System.out.println(str);
        }else {
            for(int i=l;i<=r;i++){
                str = swap(str, l, i);
                permute(str, l+1, r);
                str = swap(str, l, i);
            }

        }

    }

    private String swap(String str, int x, int y){
        char temp;
        char charArr[] = str.toCharArray();
        temp = charArr[x];
        charArr[x] = charArr[y];
        charArr[y] = temp;

        return String.valueOf(charArr);
    }




}
