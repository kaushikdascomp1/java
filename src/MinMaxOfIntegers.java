import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;

public class MinMaxOfIntegers {
        //Given a set of 5 numbers find the minimum and maximum of 4 out of 5 integers

    public static void main(String args[]){
        int arr[] = {256741038, 623958417, 467905213, 714532089, 938071625};
        findMinMax(arr);
    }

    public static void findMinMax(int arr[]){
        ArrayList<BigInteger> arrList = new ArrayList<BigInteger>();

        for(int i=0;i<arr.length;i++)
            arrList.add(BigInteger.valueOf(arr[i]));
        Collections.sort(arrList);
        int n = arrList.size();
        BigInteger minSum= BigInteger.valueOf(0);
        BigInteger maxSum= BigInteger.valueOf(0);
        for(int i=0;i<n-1;i++)
            minSum =   minSum.add(arrList.get(i));
        for(int i=1;i<n;i++)
            maxSum =maxSum.add(arrList.get(i));
        System.out.println("Min Sum is: " + minSum + "MaxSum is : "+ maxSum);


    }


    public static BigInteger factorial(int n){
        if(n==0)
            return BigInteger.valueOf(1);
        if(n==1)
            return BigInteger.valueOf(n);
        return BigInteger.valueOf(n).multiply(factorial(n-1));

    }
}
