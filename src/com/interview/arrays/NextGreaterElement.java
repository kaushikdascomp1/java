package arrays;

import java.util.Arrays;
import java.util.Stack;

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
    Stack<Integer> s1 = new Stack<>();
    //[4,5,2,25]
    public void ngeStack(int[] nums){
        int[] diff = new int[nums.length];
        if(nums.length == 0){
            return;
        }

        int element,next;

        s1.push(nums[0]);
        for(int i=1;i<nums.length;i++){
            next = nums[i];
            if(!s1.isEmpty()){
                element = s1.pop();
                while (element<next){
                    diff[i] =  next - element;
                    if(s1.isEmpty()){
                        break;
                    }
                    element = s1.pop();
                }
                if(element > next){
                    s1.push(element);
                }
            }
        }
    }

    static void swap(char[] inp, int x, int y) {
        char temp = inp[x];
        inp[x] = inp[y];
        inp[y] = temp;
    }
}
