package src.com.interview.arrays;

public class MooreVotingAlgo {

    /*
    Approach: This is a two-step process.
    The first step gives the element that maybe the majority element in the array.
    If there is a majority element in an array, then this step will definitely return majority element, otherwise, it will return candidate for majority element.
    Check if the element obtained from the above step is majority element.
    This step is necessary as there might be no majority element.

    To find the majority element
    This problem can also be solved using hashmap and binary search tree
    Hashmap uses extra space and binary search in O(n2)
    so Moore Voting is the best as it doesnt require any extra space
     */

    public static void main(String[] args) {
        MooreVotingAlgo votingAlgo = new MooreVotingAlgo();
        int a[] = new int[]{1, 3, 3, 1, 2};
        int majorityElement = votingAlgo.calculateMajority(a);
        //Will return no majority element found
        System.out.println("Majority Eelement is: "+majorityElement);

        int a1[] = new int[]{2,2,2,2,5,5,2,3,3};
        int majorityElem1 = votingAlgo.calculateMajority(a1);
        System.out.println(majorityElem1);
    }

    public int calculateMajority(int arr[]){
        int cand = findCandidate(arr,arr.length);

        if(isMajority(arr,cand))
            return cand;
        else
            return -1;
    }

    private int findCandidate(int arr[], int n){
        int count = 1;
        int maj_index = 0;
        int i;

        for ( i =1;i<arr.length;i++){
            if(arr[maj_index] == arr[i])
                count++;
            else
                count--;

            if(count == 0){
                maj_index = i;
                count = 1;
            }
        }

        return arr[maj_index];
    }

    public boolean isMajority(int arr[], int cand){
        int count  = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == cand){
                count++;
            }
        }
        if(count >= arr.length/2)
            return true;
        else
            return false;
    }
}
