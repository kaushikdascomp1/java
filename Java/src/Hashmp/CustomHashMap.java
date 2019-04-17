package Hashmp;

public class CustomHashMap<K,V> {
    public static final int initialCap = 16;

    private Entry<K,V>[] buckets;

    public CustomHashMap(int cap){
        this.buckets = new Entry[cap];
    }

    public int getHashCode(int key){
        return Integer.hashCode(key) % initialCap;
    }

    public Object get(int key){
        int hashBucket = getHashCode(key);
        Entry bucketIndex = buckets[hashBucket];
        if(null!=bucketIndex && bucketIndex.key.equals(key)){
            bucketIndex=bucketIndex.next;
        }
        return (bucketIndex!=null ? bucketIndex.value: null);
    }

    public void put(int key, int value){
        int hashBucket = getHashCode(key);
        Entry bucketIndex = buckets[hashBucket];
        if(null != bucketIndex){
            boolean done = false;
            while(!done){
                if(bucketIndex.key.equals(key)){
                    bucketIndex.value=value;
                    done=true;
                    bucketIndex.next=null;
                }else{
                    bucketIndex.next = new Entry(key,value,null);
                    done=true;
                }
                bucketIndex=bucketIndex.next;
            }
        }else{
            buckets[hashBucket] = new Entry(key,value,null);
        }
    }

}
