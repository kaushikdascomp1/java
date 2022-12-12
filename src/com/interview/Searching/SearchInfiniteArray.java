package Searching;

public class SearchInfiniteArray {

    public static void main(String[] args) {

    }
    class ArrayReader{
        int[] arr;

        public ArrayReader(int[] arr){
            this.arr = arr;
        }

        public int getIndex(int ind){
            if(ind >= arr.length){
                return Integer.MAX_VALUE;
            }
            return arr[ind];
        }
    }

    public int searchArray(ArrayReader reader, int key) {
        int start = 0;
        int end = 1;
        while(reader.getIndex(end) < key){
            int newStart = end + 1;
            end += (end - start +1) *2;
            start = newStart;
        }

        //Then use the start and end to find elemnts in binary search
        return 3;
    }
}
