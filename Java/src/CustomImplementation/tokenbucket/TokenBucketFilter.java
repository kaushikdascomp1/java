package Java.src.CustomImplementation.tokenbucket;

public class TokenBucketFilter {

    public int MAX_TOKENS = 0;
    public int possibleTokens = 0;

    public TokenBucketFilter(int maxTokens){
        this.MAX_TOKENS = maxTokens;
       // initialize();
    }

    public void initialize(){
        Thread dt = new Thread(()->{
            deamonThread();
        });
        dt.setDaemon(true);
        dt.start();
    }

    public void deamonThread(){
        while (true){
            synchronized (this){
                if(possibleTokens<MAX_TOKENS){
                    possibleTokens++;
                    System.out.println("Tokens added by Deamon Thread::");
                }

                this.notify();
            }
            try{
                Thread.sleep(1000);
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }
        }
    }

    public void getToken() throws InterruptedException{
        synchronized (this){
            while (possibleTokens == 0){
                System.out.println("Waiting for token::");
                this.wait();
            }
            possibleTokens--;
        }

        System.out.println("Granting Token to thread::  "+Thread.currentThread().getName()+"  at time:: "+System.currentTimeMillis()/1000);
    }



}
