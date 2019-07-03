package src.GSCoderPad;

public class SumFractions {

    public static void main(String[] args) {
        int num1=1, den1=500, num2=2, den2=1500;
        System.out.print(num1+"/"+den1+" + "+num2+"/"+den2+" is equal to ");
        addFraction(num1, den1, num2, den2);
    }


    public static int gcd(int a, int b){
        if(a==0)
            return b;
        return gcd(b%a,a);
    }

    public static void lowest(int den3, int num3){
        int commFactor = gcd(num3,den3);
        den3 = den3/commFactor;
        num3 = num3/commFactor;
        System.out.println(num3 + "/" +den3);
    }

    public static void addFraction(int num1, int den1, int num2, int den2){
        int den3 = gcd(den1,den2);
        den3 = (den1*den2)/den3;

        int num3 = (num1)*(den3/den1) + (num2)*(den3/den2);
        lowest(den3,num3);
    }

}
