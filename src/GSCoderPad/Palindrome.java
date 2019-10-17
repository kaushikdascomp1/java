package src.GSCoderPad;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Palindrome {

    /**
     * Given a string which can contain special characters,
     * the task was to find if string formed using characters (ignoring special ones) is a palindrome
     *
     * @param args
     */
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
        String str = "ABCDEDCBA@@";
        Matcher m = pattern.matcher(str);
        if (!m.matches()) {
            System.out.println("string '"+str + "' contains special character");
        } else {
            System.out.println("string '"+str + "' doesn't contains special character");
        }

        String newString = str.replaceAll("[^A-Za-z0-9]","");
        System.out.println(newString);
        String palindrStr = Stream.of(newString).map(word->new StringBuilder(word).reverse()).collect(Collectors.joining());
        //String palindrStr = new StringBuilder(newString).reverse().toString();
        if(newString.equals(palindrStr)){
            System.out.println("Plindrome");
        }

    }

    public void isPalindrome(String str){

    }

}
