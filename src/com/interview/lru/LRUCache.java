package com.interview.lru;

import java.util.HashMap;

public class LRUCache {

    int capacity;
    HashMap<Integer, LruNode> lruMap = new HashMap<Integer, LruNode>();
    LruNode head = null;
    LruNode end = null;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (lruMap.containsKey(key)) {
            LruNode n = lruMap.get(key);
            delete(n);
            setHead(n);
            return n.value;
        }
        return -1;
    }

    public void delete(LruNode lruNode) {
        if (lruNode.prev != null) {
            lruNode.prev.next = lruNode.next;
        } else {
            head = lruNode.next;
        }
        if (lruNode.next != null) {
            lruNode.next.prev = lruNode.prev;
        } else {
            end = lruNode.prev;
        }
    }

    public void setHead(LruNode lruNode) {
        lruNode.next = head;
        lruNode.prev = null;

        if (head != null) {
            head.prev = lruNode;
        }
        head = lruNode;
        if (end == null)
            end = head;
    }

    public void setKey(int key, int value) {
        if (lruMap.containsKey(key)) {
            LruNode lruNode = lruMap.get(key);
            lruNode.value = value;
            delete(lruNode);
            setHead(lruNode);
        } else {
            LruNode lruNode = new LruNode(key, value);
            if (lruMap.size() >= capacity) {
                lruMap.remove(end.key);
                delete(end);
                setHead(lruNode);
            } else {
                setHead(lruNode);
            }
            lruMap.put(key, lruNode);
        }
    }
}
