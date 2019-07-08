package src.com.interview.Stack;

import java.util.Stack;

public class BalancedParenthesis {

    public static void main(String args[]){
        Stack<Character> s1 = new Stack<Character>();
        String str = "[(])";
        char[] strArr = str.toCharArray();
        System.out.println(areBalanced(strArr,s1));
    }

    public static boolean areBalanced(char[] strArr, Stack<Character> s1){
        for(int i=0;i<strArr.length;i++){
            if(strArr[i] == '(' || strArr[i] == '{' || strArr[i] == '['){
                s1.push(strArr[i]);
            }
            if(strArr[i] == ')' || strArr[i] == '}' || strArr[i] == ']'){
                if(s1.isEmpty()){
                    return false;
                }else if(!isMatching(s1.pop(),strArr[i])) {
                    return false;
                }
            }
        }
        if(s1.isEmpty()){
            return true;
        }else {
            return false;
        }

    }

    public static boolean isMatching(Character char1, Character char2){
       if(char1=='(' && char2 == ')'){
           return true;
       }else if(char1 == '{' && char2 == '}'){
           return true;
       }else if(char1 == '[' && char2 == ']'){
           return true;
       }
       return false;
    }

}
