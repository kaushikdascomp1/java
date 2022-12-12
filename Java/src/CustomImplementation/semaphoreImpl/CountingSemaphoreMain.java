package CustomImplementation.semaphoreImpl;

public class CountingSemaphoreMain {

    public static void main(String[] args) {
        CountingSemaphore countingSemaphore = new CountingSemaphore(1);

        Thread th1 = new Thread(() -> {
            for (int i=0;i<5;i++){
                try {

                    countingSemaphore.acquire();
                    System.out.println("Ping" +i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread th2 = new Thread(() ->{
            for(int i=0;i<5;i++){
                try {
                    System.out.println("Pong:: "+i);
                    countingSemaphore.release();

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        th1.start();
        th2.start();
    }
}
