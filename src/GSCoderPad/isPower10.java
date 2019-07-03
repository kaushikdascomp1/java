package src.GSCoderPad;

public class isPower10 {

    public static void main(String[] args) {
        System.out.println(isPower10(10));
        System.out.println(isPower10(100));
        System.out.println(isPower10(3));
    }

    public static boolean isPower10(int x){
        while(x%10==0){
            x/=10;
            if(x==1)
                return true;
        }
        return false;
    }
}
