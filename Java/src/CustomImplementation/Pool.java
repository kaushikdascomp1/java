package Java.src.CustomImplementation;

import java.util.concurrent.Semaphore;

public class Pool {

    private static final int MAX_AVAILABLE = 3;
     private final Semaphore available = new Semaphore(MAX_AVAILABLE, true);

    public Object getItem() throws InterruptedException {
     available.acquire();
      return getNextAvailableItem();
    }

    public void putItem(Object x) {
      if (markAsUnused(x))
        available.release();
    }

    protected Object[] items = new Object[10];
   protected boolean[] used = new boolean[MAX_AVAILABLE];

    protected synchronized Object getNextAvailableItem() {
      for (int i = 0; i < MAX_AVAILABLE; ++i) {
        if (!used[i]) {
         used[i] = true;
          return items[i];
        }
      }
      return null; // not reached
    }

    protected synchronized boolean markAsUnused(Object item) {
      for (int i = 0; i < MAX_AVAILABLE; ++i) {
        if (item == items[i]) {
          if (used[i]) {
            used[i] = false;
            return true;
          } else
           return false;
        }
      }
      return false;
    }

    public static void main(String[] args) throws InterruptedException{
        Pool pool = new Pool();
        Thread th1 = new Thread(()->{

            try{
                pool.getItem();
                System.out.println("Lock Acquired:  for Thread 1");
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }finally {
                pool.putItem(new Object());
                System.out.println("Lock Released:  for Thread 1");
            }

        });

        //th1.start();
        Thread th2 = new Thread(()->{

            try{
                pool.getItem();
                System.out.println("Lock Acquired:  for Thread 2");
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }finally {
                pool.putItem(new Object());
                System.out.println("Lock Released:  for Thread 2");
            }

        });

        Thread th3 = new Thread(()->{

            try{
                pool.getItem();
                System.out.println("Lock Acquired:  for Thread 3");
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }finally {
                pool.putItem(new Object());
                System.out.println("Lock Released:  for Thread 3");
            }

        });

        th1.start();
        th2.start();
        th3.start();

    }


}
