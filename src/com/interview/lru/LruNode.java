package com.interview.lru;

public class LruNode {
    int key;
    int value;
    LruNode next;
    LruNode prev;

    public LruNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
