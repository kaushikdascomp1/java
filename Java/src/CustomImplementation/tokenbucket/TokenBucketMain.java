package CustomImplementation.tokenbucket;

import java.util.HashSet;
import java.util.Set;

public class TokenBucketMain {

    public static void main(String[] args) throws InterruptedException{
        Set<Thread> allThreads = new HashSet<Thread>();
        TokenBucketFilter tokenBucketFilter = new TokenBucketFilter(5);
        tokenBucketFilter.initialize();
        for (int i=0;i<10;i++){
            Thread thread = new Thread(()->{
                try {
                    tokenBucketFilter.getToken();
                }catch (InterruptedException ex){
                    ex.printStackTrace();
                }

            });
            thread.setName("Thread_"+i);
            allThreads.add(thread);
        }

        for (Thread thread:allThreads)
            thread.start();

       /* for (Thread thread:allThreads)
            thread.join();*/
    }

}
