package CustomImplementation.multithreading.printzerooddeven;

public class Print0 implements Runnable{


    @Override
    public void run() {
        synchronized (this){
            int even = 2;
            while (even < 20){
                System.out.println(0);
                try {
                    wait(1000);
                }catch (InterruptedException ex){
                    ex.printStackTrace();
                }
              even += 2;
            }
        }
    }
}
