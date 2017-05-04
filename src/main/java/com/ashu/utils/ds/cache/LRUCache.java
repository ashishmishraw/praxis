package com.ashu.utils.ds.cache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by mishra.ashish@icloud.com
 */
public class LRUCache<K,V> extends LinkedHashMap<K,V> {

    private int length = 0;

    LRUCache(int initialCapacity) {
        super(initialCapacity, 0.75f, true);
        this.length = initialCapacity;
    }

    public static <K,V> LRUCache<K,V> newInstance(int size) {

        return new LRUCache<K, V>(size);
    }


    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > length;
    }


    public static void main(String[] args) {
        LRUCache<String, Integer> cache = LRUCache.newInstance(5);
        cache.put("Apple", 22);
        cache.put("Mango", 5);
        cache.put("Banana", 19);
        cache.put("Grapes", 29);
        cache.put("Papaya", 56);

        System.out.println("Intial size of cache " + cache.size());
        System.out.println(cache.toString());

        cache.put("Guava", 17);

        System.out.println("Size of cache after over-inserting elements " + cache.size());
        System.out.printf(cache.toString());

    }

}
