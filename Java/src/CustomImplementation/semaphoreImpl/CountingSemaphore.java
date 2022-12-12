package CustomImplementation.semaphoreImpl;

public class CountingSemaphore {

    int usedPermits = 0;
    int max_permits;

    public CountingSemaphore(int max_permits){
        this.max_permits = max_permits;
    }

    public synchronized void acquire() throws InterruptedException {
        if(usedPermits == max_permits){
            this.wait();
        }
        System.out.println("Acquiring Permit");
        usedPermits++;
        this.notify();
    }

    public synchronized void release() throws InterruptedException {
        if(usedPermits <= 0){
            this.wait();
        }
        System.out.println("Released Permit:: ");
        usedPermits--;
        this.notify();
    }
}
