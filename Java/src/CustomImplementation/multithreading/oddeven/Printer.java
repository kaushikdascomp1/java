package CustomImplementation.multithreading.oddeven;

public class Printer {

    private volatile boolean isOdd;
    public synchronized void printEven(int num){
        while(!isOdd){
            try{
                wait();
            }catch (InterruptedException ex){
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(Thread.currentThread().getName() + ":" +num);
        isOdd = false;
        notify();
    }

    public synchronized void printOdd(int num){
        while(isOdd){
            try{
                wait();
            }catch (InterruptedException ex){
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(Thread.currentThread().getName() + ":" + num);
        isOdd = true;
        notify();
    }
}
