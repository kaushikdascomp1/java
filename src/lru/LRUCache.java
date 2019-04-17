package lru;

import java.util.HashMap;

public class LRUCache {

    int capacity;
    HashMap<Integer, Node> lruMap = new HashMap<Integer, Node>();
    Node head=null;
    Node end=null;
    public LRUCache(int capacity){
        this.capacity=capacity;
    }

    public int get(int key){
        if (lruMap.containsKey(key)){
            Node n = lruMap.get(key);
            delete(n);
            setHead(n);
            return n.value;
        }
        return -1;
    }

    public void delete(Node node){
        if(node.prev!=null){
            node.prev.next=node.next;
        }else{
            head=node.next;
        }
        if(node.next!=null){
            node.next.prev=node.prev;
        }else{
            end=node.prev;
        }
    }

    public void setHead(Node node){
        node.next=head;
        node.prev=null;

        if(head!=null){
            head.prev=node;
        }
       head=node;
        if(end==null)
            end=head;
    }

    public void setKey(int key, int value){
        if(lruMap.containsKey(key)){
            Node node = lruMap.get(key);
            node.value=value;
            delete(node);
            setHead(node);
        }else{
            Node node = new Node(key,value);
            if(lruMap.size()>=capacity){
                lruMap.remove(end.key);
                delete(end);
                setHead(node);
            }else {
                setHead(node);
            }
            lruMap.put(key,node);
        }
    }
}
