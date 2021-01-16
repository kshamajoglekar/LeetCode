package com.ks.leetcode.medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class Client {

    Cache cache = Cache.create("LRU", 300);

}

public abstract class Cache {
    static Cache cacheInstance = null;
    int limit;
    String algo;

    protected Cache() {
    }

    public static Cache create(String algo, int limit) {

        switch (algo) {
            case "LRU":
                cacheInstance = new LRU();
                break;
            case "LFU":
                cacheInstance = new LFU();
                break;
        }

        cacheInstance.algo = algo;
        cacheInstance.limit = limit;
        return cacheInstance;
    }

    abstract String get(String key);

    abstract void add(String key, String value);


}

class LRU extends Cache {

    protected Map<String, String> cache = new HashMap<>();
    protected LinkedList<String> ranks = new LinkedList<>();


    public String get(String key) {
        String result = cache.get(key);
        ranks.remove(key);
        ranks.addFirst(result);
        return result;
    }

    public void add(String key, String value) {
        if (cache.containsKey(key)) return;

        if (cache.size() == limit) {

            //evictAndAdd
            ranks.removeLast();
            ranks.addFirst(key);
            cache.put(key, value);
            limit++;
        }
    }
}


class LFU extends Cache {


    public String get(String key) {
        return null;
    }

    public void add(String key, String value) {


        //if(cache.containsKey(key)) return;

        //if(cache.size()==limit){
        limit++;
        //}
    }
}
