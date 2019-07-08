package src.com.interview.Recursion;

public class EggDropPuzzle {

    /**
     * FInd the minimum number of trials required to find the maximum floor from which the egg dropped will not break
     * Two conditions: K=total number of floors for operation
     * 1. If an egg breaks at X floor where x<K -- Iterate the operation for X-1 floors with n-1 eggs
     * 2. If an egg does't break at X floor x<K -- Iterate the operation for K-X floors with n eggs
     * where x in {1,2,3,4......}
     * @param args
     */
    public static void main(String args[]){
        System.out.println(eggDrop(2,16));
    }

    public static int eggDrop(int n, int k){
        if(k==1 || k==0)
            return 1;
        if(n==1)
            return k;
        int min= Integer.MAX_VALUE;
        int res;
        for(int x=1;x<=k; x++){
            res = Math.max(eggDrop(n-1,x-1), eggDrop(n,k-x));
            if(res < min)
                min=res;
        }
        return min+1;
    }
}
