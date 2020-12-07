package Java.src.CustomImplementation.multithreading.printzerooddeven;

public class PrintEven implements Runnable {
    Print0 print0;

    public PrintEven(Print0 print0){
        this.print0 = print0;
    }


    @Override
    public void run() {
        synchronized (print0){
            int even = 2;
            while (even < 20){
                System.out.println(even);
                try {
                    print0.wait(1000);
                }catch (InterruptedException ex){
                    ex.printStackTrace();
                }
                even += 2;
            }
        }
    }
}
