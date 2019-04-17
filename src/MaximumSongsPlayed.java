import java.util.Arrays;

public class MaximumSongsPlayed {

    public static void main(String args[]) {
        int arr[] = new int[]{2, 4, 3, 5, 5, 2, 4};
        System.out.println(findMaxSongsPlayed(arr, 20));
    }

    public static int findMaxSongsPlayed(int arr[], int time) {
        int count = 0;
        int totalCount = 0;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if (count <= time) {
                count += arr[i];
                if (count <= time)
                    totalCount += 1;
            }
        }
        return totalCount;
    }
}
