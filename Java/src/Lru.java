import java.util.HashMap;
import java.util.Map;

public class Lru {

    int capacity;
    Node head = null;
    Node end =  null;
    Map<Integer, Node> lruMap = new HashMap<Integer, Node>();

    public Lru(int capacity){
        this.capacity =capacity;
    }

    public void setHead(Node node){
      node.next = head;
      node.prev = null;
      if(head!=null){
          head.prev =node;
      }
      head = node;
      if(end==null)
          end=head;
    }

    public void delete(Node node){
        if(node.prev!=null){
            node.prev.next = node.next.prev;
        }else{
            head=node.next;
        }

        if(node.next!=null){
            node.next.prev = node.prev;
        }else{
            end = node.prev;
        }
    }

    public int get(int key){
        if(lruMap.containsKey(key)){
            Node tmp = lruMap.get(key);
            delete(tmp);
            setHead(tmp);
            return  tmp.value;
        }
        return -1;
    }
    public void setKey(int key, int value){
        if (lruMap.containsKey(key)) {
            Node tmp = lruMap.get(key);
            tmp.value=value;
            delete(tmp);
            setHead(tmp);
        }else{
            Node tmp = new Node(key, value);
            if(lruMap.size()>=capacity){
                delete(end);
                setHead(tmp);
            }else {
                setHead(tmp);
            }

            lruMap.put(key,tmp);
        }
    }

}
