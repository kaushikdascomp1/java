package src.com.interview.Searching;

public class CountOccurancesofX {

    //to count the occurances of x in O(log n) using binary search

    public static void main(String[] args) {
        int arr[] = {1, 2, 2, 3, 3, 3, 3};
        CountOccurancesofX count = new CountOccurancesofX();
        int x=3;
        int n = arr.length;
        System.out.println(count.countOccurances(arr,n,x));
    }

    public int first(int arr[], int lo, int hi, int x){
        if(lo<=hi){
            int mid = (lo+hi)/2;

            if((mid == 0 || x > arr[mid-1]) && arr[mid] == x){
                return mid;
            }

            if(x<arr[mid]){
                return first(arr,lo,mid-1,x);
            }
            return first(arr,mid+1,hi,x);
        }
        return  -1;
    }


    public int last(int arr[], int lo, int hi, int x, int n){
        if(lo<=hi){
            int mid = (lo+hi)/2;
            if((mid == n-1) || x < arr[mid+1] && arr[mid] == x){
                return mid;
            }

            if(x<arr[mid]){
               return last(arr, lo, mid-1, x,n);
            }
            return last(arr, mid+1, hi, x,n);
        }
        return -1;
    }

    public int countOccurances(int arr[], int n, int x){
        int first = first(arr,0,n-1,x);

        if(first == -1)
            return 0;

        int last = last(arr,first,n-1,x,n);
        return last-first+1;
    }
}
