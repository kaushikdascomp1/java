package Java8.CompletableFuture;

public class WorkerNew implements Runnable{

    private int id;
    private String name;

    public WorkerNew(int id, String name){
        this.id = id;
        this.name = name;
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
        String name = Thread.currentThread().getName();
        System.out.println("Executing tasks" + name);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Thread execution FInished:: "+name);
    }
}
