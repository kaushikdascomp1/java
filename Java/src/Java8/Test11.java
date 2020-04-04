package Java.src.Java8;

public class Test11 implements B, C {


    @Override
    public void m1() {
        System.out.println("Inside Parent Class:: ");
       // B.super.m1();
       // C.super.m1();
    }

    public static void main(String[] args) {
        Test11 test11 = new Test11();
        test11.m1();
    }
}
