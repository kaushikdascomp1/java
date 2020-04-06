package Java.src.CustomImplementation.Throttling.RejectedTasksAfterExecutorshutdown;

public class Worker implements Runnable {


    /**
     * New tasks submitted to executor service after executor shutdown or when the queue size is full is handled by
     * rejectedexecutionhandler
     *
     */
    int id;
    String name;

    public Worker(int id){
        this.id = id;
        System.out.println("Worker created:  "+ id);
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        String curr = Thread.currentThread().getName();

        try{
            System.out.println("Executing task::  "+curr);
            Thread.sleep(1000);
            System.out.println("Finished Executing task::  "+curr);
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Worker{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
