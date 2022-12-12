package CustomImplementation.ReadWriteLock;

public class ReadWriteLockMain {

    public static void main(String[] args) throws InterruptedException {
        ReadWriteLock readWriteLock = new ReadWriteLock();

        Thread writer1 = new Thread(() -> {
            try {
                System.out.println("Attempting to aquire write lock in Thread1");
                readWriteLock.acquireWriteLock();
                System.out.println("Write lock aquired for Thread 1");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread writer2 = new Thread(() -> {
            try {
                System.out.println("Attempting to acquire write lock in thread 2");
                readWriteLock.acquireWriteLock();
                System.out.println("Write lock acquired for thread 2");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread reader1 = new Thread(() -> {
            try {
                System.out.println("Attempting to acquire read lock in thread readr 1");
                readWriteLock.acquireReadLock();
                System.out.println("Read lock aquired for thread 1");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread reader2 = new Thread(() -> {

                System.out.println("Attempting to released read lock in thread readr 2");
                readWriteLock.releaseReadLock();
                System.out.println("Read lock released");

        });

        reader1.start();
        writer1.start();
        Thread.sleep(3000);
        reader2.start();
        Thread.sleep(1000);
        writer2.start();

        reader1.join();
        reader2.join();
        writer2.join();

    }
}
