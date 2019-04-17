public class Node {

    public int key;
    public int value;
    Node prev;
    Node next;

    public Node(int key, int value){
        this.key=key;
        this.value=value;
        this.prev=null;
        this.next=null;
    }

}
