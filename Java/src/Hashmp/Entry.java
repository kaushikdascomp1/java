package Hashmp;


public class Entry<K,V> {

    public K key;
    public V value;
    public Entry next;

    public Entry(K key, V value, Entry next){
        this.key=key;
        this.value=value;
        this.next=null;
    }
}
