package lru.lru1;

import lru.Node;

import java.util.HashMap;

public class LRU {

    HashMap<Integer, Node1> lrumap =new HashMap<Integer, Node1>();
    int capacity;
    Node1 head=null;
    Node1 end = null;
    public LRU(int capacity){
        this.capacity=capacity;
    }

    public int get(int key){
        if(lrumap.containsKey(key)){
            Node1 n = lrumap.get(key);
            delete(n);
            setHead(n);
            return n.value;
        }
        return -1;
    }

    public void put(int key, int value){
        if (lrumap.containsKey(key)) {
            Node1 n = lrumap.get(key);
            n.value=value;
            delete(n);
            setHead(n);

        }else{
            Node1 n = new Node1(key,value);
            if(lrumap.size()>=capacity){
                delete(end);
                setHead(n);
            }else{
                setHead(n);
            }
            lrumap.put(key,n);
        }
    }


    public void delete(Node1 node1){
        if(node1.prev!=null){
            node1.prev.next=node1.next;
        }else{
            head = node1.next;
        }

        if(node1.next!=null){
            node1.next.prev=node1.prev;
        }else{
            end=node1.prev;
        }
    }


    public void setHead(Node1 node1){
        node1.next=head;
        node1.prev=null;
        if(head!=null){
            head.prev=node1;
        }
        head=node1;
        if(end==null)
            end=head;
    }
}
