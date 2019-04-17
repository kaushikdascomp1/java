import java.math.BigInteger;

public class HCF {

    public static void main(String args[]){
        int a=24;
        int b=36;
        System.out.println(gcd(a,b));
        BigInteger arr[] =new BigInteger[]{BigInteger.valueOf(2),BigInteger.valueOf(4),BigInteger.valueOf(6), BigInteger.valueOf(8)};
        System.out.println(getLCM(arr));
    }
    static int gcd(int a, int b)
    {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
public static BigInteger getLCM(BigInteger arr[]){
    if(arr.length==1){
        return arr[0];
    }
        BigInteger mul;
        BigInteger result = arr[0];
        BigInteger gcd;
        for(int i=1;i<arr.length;i++){
            mul=result.multiply(arr[i]);
            gcd=gcd(arr[i],result);
            result = (mul.divide(gcd));

        }
    System.out.println(result);
        return result.mod(BigInteger.valueOf(1000000007));
}


    public static BigInteger gcd(BigInteger a, BigInteger b){
        if (b.equals(BigInteger.valueOf(0)))
            return a;
        return gcd(b,a.mod(b));
    }

}
