package src.com.interview.arrays;

public class DutchNationalProblem {

    public static void main(String args[]) {
        int arr[] = new int[]{0, 1, 2, 0, 1, 2};
        sortArray(arr);
    }

    public static void sortArray(int arr[]) {
        int high = arr.length - 1;
        int low = 0;
        int mid = 0;
        while (low <= high) {
            switch (arr[mid]) {
                case 0:
                    int temp = arr[mid];
                    arr[mid] = arr[low];
                    arr[low] = temp;
                    mid++;
                    low++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    int temp1 = arr[mid];
                    arr[mid] = arr[high];
                    arr[high] = temp1;
                    high--;
                    break;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }

    public static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }
}
