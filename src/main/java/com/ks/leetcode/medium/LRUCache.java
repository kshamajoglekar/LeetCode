package com.ks.leetcode.medium;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LRUCache {

    Map<Integer, Integer> cache = new HashMap<>();
    Queue<Integer> ranks = new LinkedList<>();

    int capacity = 0;
    int currentLength = 0;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    void put(Integer key, Integer value) {
        currentLength += 1;
        if (currentLength > capacity) {
            Integer leastRecentlyUsedKey = ranks.poll();
            cache.remove(leastRecentlyUsedKey);

        }
        cache.put(key, value);  
        ranks.add(key);
    }

    Integer get(Integer key) {
        ranks.remove(key);
        // now update access level.
        return cache.get(key);
    }

    public static void main(String[] args) {

        LRUCache lruCache = new LRUCache(3);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.put(3, 3);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
        System.out.println(lruCache.get(5));
    }
}
