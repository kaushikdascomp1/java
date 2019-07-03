package src.GSCoderPad;

public class SecondSmallestInArray {

    public static void main(String[] args) {
        int arr[] = {2,4,5,9};
        System.out.println(findSecondSmallest(arr));
    }

    public static int findSecondSmallest(int arr[]){
        int small1 = Integer.MAX_VALUE;
        int small2 = Integer.MAX_VALUE;

        for(int i=0;i<arr.length;i++){
            if(arr[i]<small1){
                small2=small1;
                small1=arr[i];

            }else if(arr[i]<small2 && arr[i]!=small1){
                small2=arr[i];
            }
        }
        return small2;
    }
}
