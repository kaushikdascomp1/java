package src.com.interview.arrays;

import java.util.Arrays;

public class NextGreaterElement {

    public static void main(String[] args) {
        char digits[] = {'5', '3', '4', '9', '7', '6'};
        int n = digits.length;
        nge(digits, n);
    }

    public static void nge(char[] input, int n) {
        int i;
        for (i = n - 1; i > 0; i--) {
            if (input[i] > input[i - 1])
                break;
        }

        if (i == 0) {
            System.out.println("No Solutions found:: ");
            return;
        }

        int min = i;
        int x = input[i - 1];
        for (int j = i + 1; j < n; j++) {
            if (input[j] > x && input[j] < input[min])
                min = j;
        }

        //swap min and i
        swap(input, i - 1, min);
        Arrays.sort(input,i,n);
        for (int j = 0; j < n; j++) {
            System.out.println(input[j]);
        }
    }

    static void swap(char[] inp, int x, int y) {
        char temp = inp[x];
        inp[x] = inp[y];
        inp[y] = temp;
    }
}
