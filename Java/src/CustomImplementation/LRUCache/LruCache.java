package Java.src.CustomImplementation.LRUCache;

import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class LruCache {

    Deque<Integer> deque;
    HashSet<Integer> hashSet;

    public int CACHESIZE = 5;

    public LruCache(int capacity){
        this.deque = new LinkedList<>();
        this.hashSet = new HashSet<>();
        this.CACHESIZE = capacity;
    }

    public void refer(int page){
        if(!hashSet.contains(page)){
            if(deque.size() == CACHESIZE){
                Integer last = deque.removeLast();
                hashSet.remove(last);
            }
        }else {
            deque.remove(page);
        }

        deque.add(page);
        hashSet.add(page);
    }

    public void display(){
        var value = deque.peek();
        //returning  all values
        Iterator<Integer> itr = deque.iterator();
        while (itr.hasNext()){
            System.out.println(itr.next());
        }
    }

    /*
    Another implementation using LinkedHashSet

     */

}
