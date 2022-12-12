package com.interview.arrays.overlappingsubproblems;

import java.math.BigInteger;
import java.util.Arrays;

public class PlatformsRequired {


    public static void main(String[] args) {
       int arr[] = {900,940,950,1100,1500,1800};
       int dep[] = {910, 1200, 1120, 1130, 1900, 2000};
        System.out.println(countPlatforms(arr,dep));
    }

    public static int countPlatforms(int[] arr, int[] dep){
        Arrays.sort(arr);
        Arrays.sort(dep);

        int i=0; int j = 0;
        int platformsReqd = 1;
        while (i<arr.length && j<dep.length){
            if(arr[i]<dep[j]){
                platformsReqd++;
                i++;
            }else{
                platformsReqd--;
                j++;
            }

        }

        return platformsReqd;
    }
}
