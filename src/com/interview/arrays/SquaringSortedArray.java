package src.com.interview.arrays;

public class SquaringSortedArray {

    //Given a sorted array, create a new array containing squares of all the number of the input array in the sorted order.
    //Input: [-2, -1, 0, 2, 3]
    //Output: [0, 1, 4, 4, 9]
    public static void main(String[] args) {
        int[] result = squaringSortedArray(new int[] { -2, -1, 0, 2, 3 });
        for (int num : result)
            System.out.print(num + " ");
        System.out.println();
    }

    private static int[] squaringSortedArray(int[] arr){
        int left = 0;
        int n = arr.length;
        int right = n-1;
        int sorted[] = new int[n];
        int highestSquareIdx = n-1;
        while(left<right){
            int leftSquare = arr[left] * arr[left];
            int rightSquare = arr[right] * arr[right];
            if(leftSquare>rightSquare){
                sorted[highestSquareIdx--] = leftSquare;
                left++;
            }else{
                sorted[highestSquareIdx--] = rightSquare;
                right--;
            }

        }
        return sorted;
    }
}
