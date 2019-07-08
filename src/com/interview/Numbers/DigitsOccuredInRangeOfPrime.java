package src.com.interview.Numbers;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class DigitsOccuredInRangeOfPrime {


    public static void main(String args[]){
        Map<Integer, Integer> primeNum = new TreeMap<>();
        int arr[] = new int[]{21,40};
        for(int i=arr[0];i<arr[1];i++){
            if(isPrime(i)){
                int rem = i%10;
                int quo= i/10;
               if(primeNum.containsKey(rem)){
                   primeNum.put(rem,primeNum.get(rem)+1);
               }else{
                   primeNum.put(rem,1);
               }
               if(primeNum.containsKey(quo)){
                   primeNum.put(quo,primeNum.get(quo)+1);
               }else{
                   primeNum.put(quo,1);

               }
            }

        }
        int max=0;
        int maxKey=0;
        for(Map.Entry<Integer,Integer> entry: primeNum.entrySet()){
            if(entry.getValue()>max){
                max=entry.getValue();
                maxKey=entry.getKey();
            }
            System.out.println("Key:"+entry.getKey()+ " Value:"+entry.getValue());

        }
        System.out.println("Maximum Key:"+maxKey);

    }

    public static boolean isPrime(int n){
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i == 0){
               return false;
            }
        }
        return true;
    }
}
