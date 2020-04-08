package Java.src.BlockingQueue;

import java.util.LinkedList;

public class BlockingQueue {

    public LinkedList<Integer> list;
    int cap;

    public BlockingQueue(int cap){
        this.cap=cap;
        this.list = new LinkedList<Integer>();
    }

    public synchronized void put(int value) throws InterruptedException{
        if(list.size()==cap){
            try{
                this.wait();
                System.out.println("Waiting");
            }catch (InterruptedException ex){
                throw new InterruptedException();
            }
        }

        list.add(value);
        System.out.println("Added" +value);
        this.notify();
    }

    public synchronized int get() throws InterruptedException{
        if(list.size()<=0){
            try{
                this.wait();
            }catch (InterruptedException ex){
                throw new InterruptedException();
            }
        }
        int val=list.get(0);
        list.remove(0);
        this.notify();
        return val;
    }


}
