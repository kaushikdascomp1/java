package Java.src.Java8.stream;

import java.util.Arrays;
import java.util.List;

public class StreamExample {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(3,4,6,12,20);
        boolean ans = list.stream().anyMatch(n -> (n*(n+1)/4 == 5));
        System.out.println(ans);
    }


}
