package Java.src.Java8;

public class Test11 implements B, C {


    @Override
    public void m1() {
        System.out.println("Inside Parent Class:: ");
        //B.super.m1();
       // C.super.m1();
    }

    public static void methodA(int a){
        System.out.println("Integer Method called:  ");
    }


    public static void methodA(String a){
        System.out.println("String Method called:  ");
    }

    public static void methodA(Object a){
        System.out.println("Object Method called:  ");
    }

    public static void main(String[] args) {
        Test11 test11 = new Test11();
        test11.m1();
        boolean val = true;
        methodA(val);
    }
}
