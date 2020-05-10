package src.com.interview.Stack;

import java.util.Stack;

public class ParenthesisChecker {

    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();
    }

    public static boolean checkParenthesis(String string) {
        Stack<Character> stack = new Stack<>();
        char chrArr[] = string.toCharArray();
        for (int i = 0; i < chrArr.length; i++) {
            if (chrArr[i] == '(' || chrArr[i] == '{' || chrArr[i] == '[')
                stack.push(chrArr[i]);
            else if (chrArr[i] == ')' || chrArr[i] == '}' || chrArr[i] == ']') {
                if(stack.isEmpty())
                    return false;
                if(!isMatching(stack.pop(), chrArr[i])) {
                    return false;
                }
            }

        }
        if(!stack.isEmpty())
            return false;

        return true;

    }

    public static boolean isMatching(char a, char b) {

        if (a == '(' && b == ')') {
            return true;
        } else if (a == '{' && b == '}') {
            return true;
        } else if (a == '[' && b == ']') {
            return true;
        }
        return false;
    }
}
