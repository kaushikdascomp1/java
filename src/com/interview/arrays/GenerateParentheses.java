package arrays;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    /*
    Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
    Input: n = 3
    Output: ["((()))","(()())","(())()","()(())","()()()"]
     */
    public static void main(String[] args) {

    }

    public List<String> generateParentheses(int n){
        List<String> res = new ArrayList<>();
        generate(n,n,new StringBuilder(), res);
        return res;
    }

    public static void generate(int open, int close, StringBuilder s, List<String> res){
        if(open == 0 && close == 0){
            res.add(s.toString());
            return;
        }

        if(open > 0){
            generate(open-1, close, s.append("("), res);
            s.deleteCharAt(s.length()-1);
        }

        if(open < close){
            generate(open, close-1, s.append(")"), res);
            s.deleteCharAt(s.length()-1);
        }
    }
}
