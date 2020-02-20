package src.com.interview.arrays;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingCharacter {


    public static void main(String[] args) {
        String str = "geeksforgeeks";
        getCharCountArr(str);
    }

    public static char[] getCharCount(String string) {
        char arr[] = new char[256];
        for (int i = 0; i < string.length(); i++) {
            arr[string.charAt(i)]++;
        }
        return arr;
    }

    public static void getCharCountArr(String string) {
        char arrCount[] = getCharCount(string);
        for (int i = 0; i < string.length(); i++) {
            if (arrCount[string.charAt(i)] == 1) {
                System.out.println("First Non_repeating is: " + string.charAt(i));
                break;
            }
        }
    }

    // 2nd Approach using a Map
    public static char firstNonRepeatingCharacter(String inStr) {
        char result = inStr.charAt(0);
        Map<Character, Integer> map = new HashMap<Character, Integer>();

        for (int i = 0; i < inStr.length(); i++) {
            if (map.containsKey(inStr.charAt(i))) {
                map.put(inStr.charAt(i), map.get(inStr.charAt(i)) + 1);
            } else {
                map.put(inStr.charAt(i), 1);
            }
        }

        for (int i = 0; i < inStr.length(); i++) {
            if (map.get(inStr.charAt(i)) == 1) {
                result = inStr.charAt(i);
                break;
            }
        }
        return result;
    }
}
