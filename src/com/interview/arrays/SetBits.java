package arrays;

public class SetBits {

    public static void main(String[] args) {
        setBitsCount(10, 20);
    }

    public static int countBits(int n){
        int count = 0;
        while(n != 0){
            count++;
            n &=(n-1);
        }
        System.out.println("Count is:: "+count);
        return count;
    }

    public static int setBitsCount(int a, int b){
        return countBits(a ^ b);
    }
}
