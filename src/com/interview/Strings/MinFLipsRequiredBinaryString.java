package src.com.interview.Strings;

public class MinFLipsRequiredBinaryString {

    /*
    Given a binary string, find the minimum number of flips required to make the binary string as
    alternate of 0's and 1's
    https://www.geeksforgeeks.org/number-flips-make-binary-string-alternate/
    Given a binary string, that is it contains only 0s and 1s. We need to make this string a sequence of alternate characters by flipping some of the bits,
    our goal is to minimize the number of bits to be flipped.
     */

    public static void main(String[] args) {
        String str = "001";
        // 010
        // 101

        //Str = 100
        // 101, || 010
        System.out.println(fidMinFlipsRequired(str));

        String str1 = "0001010111";
        // 1010101010
        // 0101010101
        System.out.println(fidMinFlipsRequired(str1));
    }

    public static int fidMinFlipsRequired(String str){
        //base condition
        if(null == str || str.length()<=0)
            return -1;

        //As there could be two ways a binary string can start with either with 0 or with 1
        return Math.min(findMin(str,'0'), findMin(str,'1'));
    }

    public static int findMin(String str, Character expected){

        int flipCount = 0;
        char[] charArr = str.toCharArray();
        for(int i=0;i<charArr.length;i++){
            if(charArr[i] != expected)
                flipCount++;
            expected = flip(expected);
        }

        return flipCount;
    }


    public static Character flip(Character character){
        return character == '0' ? '1' : '0';
    }

}
