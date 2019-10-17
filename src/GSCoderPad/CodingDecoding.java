package src.GSCoderPad;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CodingDecoding {

    public static void main(String[] args) {
        String str = "aaabbbbbccccdda";
        decodeString(str);
    }

    public static void decodeString(String str){
        StringBuilder stringBuilder = new StringBuilder();
        char chr = str.charAt(0);
        int count = 1;
        for(int i=0;i<str.length()-1;i++){
            if(str.charAt(i) == str.charAt(i+1)){
                count++;
                chr = str.charAt(i+1);
            }else{
                stringBuilder.append(str.charAt(i)).append(count);
                count = 1;
                chr = str.charAt(i+1);
            }
        }
        stringBuilder.append(chr).append(count);
        System.out.println(stringBuilder.toString());

    }
}
