package CustomImplementation.multithreading.printzerooddeven;

public class PrintZeroOddEven {

    /*
        Given a series 0102030405
        Print 0 odd and even using three threads
     */

    public static void main(String[] args) throws InterruptedException{

        Print0 print0 = new Print0();
        PrintOdd printOdd = new PrintOdd(print0);
        PrintEven printEven = new PrintEven(print0);

        Thread t1 = new Thread(print0);
        Thread t2 = new Thread(printOdd);
        Thread t3 = new Thread(printEven);

        t1.start();
        Thread.sleep(200);
        t2.start();
        Thread.sleep(200);
        t3.start();

    }
}
