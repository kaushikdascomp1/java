package CustomImplementation.LRUCache;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class LruCacheHashMap {

    HashMap<Integer, String> map;
    Deque<Integer> deque;
    int capacity;

    public LruCacheHashMap(int capacity){
        this.map = new HashMap<>();
        this.deque = new LinkedList<>();
        this.capacity = capacity;
    }

    public String get(int key){
        if(!map.containsKey(key)){
            //If value is not present in map we return -1
            return "";
        } else {
          deque.remove(key);
          deque.addFirst(key);
          return map.get(key);
        }
    }

    public void put(int key, String value){
        if(deque.size() >= capacity){
            //cache full
            Integer item = deque.removeLast();
            map.remove(item);
        }
        deque.addFirst(key);
        map.put(key,value);
    }

}
