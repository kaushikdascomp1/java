package src.com.interview.arrays;

public class MedianOfSortedArrays {

    public static void main(String[] args) {
        int arr1[] = {2,3,4,5};
        int arr2[] = {6,7,8,9} ;

        int[] mergedList = mergeSort(arr1,arr2);
        int len3 = mergedList.length;
        if(len3%2 != 0)
            System.out.println("Median of Odd Numbers: " + mergedList[len3/2]);
        else
            System.out.println("Median of Even Numbers: " + (mergedList[len3/2]+mergedList[len3+1/2])/2);

    }

    public static int[] mergeSort(int[] arr1, int[] arr2){
        int len1 = arr1.length;
        int len2 = arr2.length;
        int[] arr3 = new int[len1+len2+1];
        int i=0,j=0,k=0;
        while(i<len1 && j<len2){
            if(arr1[i]<arr2[j]){
                arr3[k++] = arr1[i++];
            }
            else{
                arr3[k++] = arr2[j++];
            }
        }

        while(i<len1){
            arr3[k++] = arr1[i++];
        }
        while(j<len2){
            arr3[k++] = arr2[j++];
        }
        return arr3;
    }
}
