package com.interview.arrays;

import java.util.ArrayList;
import java.util.List;

public class MultiplesofThreeFive {
    /*
    Given an integer n return a string array where
     if answer[i] is divisible by 3 & 5 then "FizzBuzz"
     if answer[i] is divisible by 3 then "Fizz"
     if answer[i] is divisible by 5 then "Buzz"
     */
    public static void main(String[] args) {
        int n = 15;
        System.out.println(fizzBuzz(n));
    }

    public static List<String> fizzBuzz(int n){
        List<String> output = new ArrayList<>();
        for(int i=1;i<=n;i++){
            if(i % 3 == 0 && i % 5 == 0){
                output.add("FizzBuzz");
            } else if (i % 3 == 0) {
                output.add("Fizz");
            } else if (i % 5 == 0) {
                output.add("Buzz");
            }else {
                output.add(String.valueOf(i));
            }
        }
        return output;
    }
}
