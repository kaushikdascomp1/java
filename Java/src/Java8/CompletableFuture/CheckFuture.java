package Java.src.Java8.CompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CheckFuture {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<String> completableFuture = new CompletableFuture<>();
        String result = completableFuture.get();
        completableFuture.complete("Compelte");
        // Using Runnable
        CompletableFuture<Void> voidFuture = CompletableFuture.runAsync(new Runnable(){
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        voidFuture.get();

        // Using Lambda Functions
        CompletableFuture<Void> voidFutLam = CompletableFuture.runAsync(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
