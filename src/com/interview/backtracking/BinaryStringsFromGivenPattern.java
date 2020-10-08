package src.com.interview.backtracking;

public class BinaryStringsFromGivenPattern {

    /*
    Given a string containing 0,1 and ? wildcard characters, generate all binary strings that can be formed
    by replacing each ? character with either 0 or 1
    Input str = "1??0?101"
        Output:
        10000101
        10001101
        10100101
        10101101
        11000101
        11001101
        11100101
        11101101
     */

    public static void main(String[] args) {
        String input = "1??0?101";
        generateStrings(input.toCharArray(),0);
    }

    public static void generateStrings(char[] str, int index){
        if(index == str.length){
            System.out.println(str);
            return;
        }

        if(str[index] == '?'){
            //Replace str[index] with 0 and recurse
            str[index] = '0';
            generateStrings(str, index+1);

            //Replace str index with '1'
            str[index] = '1';
            generateStrings(str, index+1);

            //After backtracking keep the original unchanged
            str[index] = '?';
        }else {
            generateStrings(str, index+1);
        }
    }

}
