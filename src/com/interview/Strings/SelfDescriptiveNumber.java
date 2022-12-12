package Strings;

public class SelfDescriptiveNumber {

    /*
   A self-descriptive number is an integer n in given base b is b digits long in which each digit at position p (the most significant digit being at position 0 and the least significant at position b – 1) counts how many times a digit p is in n.

    For example in base 10, 6210001000 is a self descriptive number as there are six 0s, two 1s, one 2 and one 6.
    https://www.geeksforgeeks.org/self-descriptive-number/

     */

    public static void main(String[] args) {
        int num1 = 2020;
        System.out.println(selfDescriptive(num1));

    }

    public static boolean selfDescriptive(int num){
        String str = String.valueOf(num);

        int[] freq = new int[10];
        for(int i=0;i<10;i++){
            freq[i] = 0;
        }
        while(num > 0){
            freq[num % 10]++;
            num /= 10;
        }
        for(int i=0;i<str.length();i++){
            if(freq[i] != str.charAt(i) - '0')
                return false;
        }
        return true;
    }
}
