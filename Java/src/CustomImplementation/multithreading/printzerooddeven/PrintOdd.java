package CustomImplementation.multithreading.printzerooddeven;

public class PrintOdd implements Runnable{

    Print0 print0;

    public PrintOdd(Print0 print0){
        this.print0 = print0;
    }

    @Override
    public void run() {
        synchronized (print0){
            int odd = 1;
            while (odd < 20){
                System.out.println(odd);
                try{
                    print0.wait(1000);
                }catch (InterruptedException ex){
                    ex.printStackTrace();
                }
                odd += 2;
            }
        }
    }
}
