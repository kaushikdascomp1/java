public class C implements A, B {

    public static void main(String[] args) {
        B c = new C();
        c.print();
    }

    @Override
    public void print() {
        System.out.println("print x");
    }

}
