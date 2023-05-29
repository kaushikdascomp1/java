package com.interview.dp;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {


    /*
    Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
    Input: n = 3
    Output: ["((()))","(()())","(())()","()(())","()()()"]
     */
    public static void main(String[] args) {
        List<String> result = new ArrayList<>();
        generate("", result, 0, 0, 3);
        result.stream().forEach(e->{
            System.out.println(e);
        });
    }
    // n=2,
    // (  --> op=1, cl=0    (( --> op = 2 cl=0, res=((
    // op>cl --> (( ) cl=1   res-(( )) cl=2
    //Removing from method stack when op=1   cl=0, res=() cl=1
    //op=2 --> () ( cl=2 --> ()()
    public static void generate(String current, List<String> result, int op, int cl, int n){
        if(current.length() == 2*n){
            result.add(current);
            return;
        }
        if(op < n){
            generate(current+"(", result, op+1, cl, n);
        }

        if(op > cl){
            generate(current+")", result, op, cl+1, n);
        }
    }
}
