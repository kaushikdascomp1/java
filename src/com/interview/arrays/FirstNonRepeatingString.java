package src.com.interview.arrays;

public class FirstNonRepeatingString {


    public static void main(String[] args) {
        String str = "geeksforgeeks";
        getCharCountArr(str);
    }

    public static char[] getCharCount(String string){
        char arr[] = new char[256];
        for(int i=0;i<string.length();i++){
            arr[string.charAt(i)]++;
        }
        return arr;
    }

    public static void getCharCountArr(String string){
        char arrCount [] = getCharCount(string);
        for(int i=0;i<string.length();i++){
            if(arrCount[string.charAt(i)] == 1){
                System.out.println("First Non_repeating is: " +string.charAt(i));
                break;
            }
        }
    }
}
