package CustomImplementation.ReadWriteLock;

public class ReadWriteLock {

    int readers = 0;
    boolean writeLocked = false;

    public synchronized void acquireReadLock() throws InterruptedException {
        while(writeLocked){
            this.wait();
        }
        readers++;
    }

    public synchronized void releaseReadLock() {
        readers--;
        notify();
    }

    public synchronized void acquireWriteLock() throws InterruptedException {
        while (writeLocked || readers != 0){
            this.wait();
        }
        writeLocked = true;
    }

    public synchronized void releaseWriteLock(){
        writeLocked = false;
        notify();
    }
}
