package src.com.interview.arrays;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllSubsetsOfArray {

    /*
        Given a set of distinct integers, arr, return all possible subsets (the power set).
        Input: nums = [1,2,3]
        Output:
        [
        [3],
        [1], // 001
        [2], //
        [1,2,3],
        [1,3],
        [2,3],
        [1,2],
        [] // 000
        ]

     */

    public static void main(String[] args) {
        int num[] = {1,2,3};
        //subSets(3,num);
        List<Integer> listOfInteger = Arrays.asList(1, 2, 3);
        subSets(listOfInteger);

        List<Character> charList = Arrays.asList('a', 'b', 'c');
        subSets(charList);
    }

    public static <T> void subSets(List<T> nums){
        long powerSetSize = (long) Math.pow(2, nums.size());
        List<List<T>> resultList = new ArrayList<>();
        for (long counter=0;counter<powerSetSize;counter++){
            List<T> subsetResult = new ArrayList<>();
            for (int j = 0; j < nums.size(); j++) {
                if((counter & (1<<j))>0){
                    subsetResult.add(nums.get(j));
                }
            }
            resultList.add(subsetResult);
        }
        resultList.stream().forEach(System.out::println);
    }

    @Override
    public String toString() {
        return "AllSubsetsOfArray{}";
    }
}
