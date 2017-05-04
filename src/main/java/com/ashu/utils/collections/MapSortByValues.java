package com.ashu.utils.collections;

import java.util.*;

/**
 * Created by mishra.ashish@icloud.com
 */
public class MapSortByValues {

    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>(5);

        map.put("Jim",500 ); map.put("Vin", 333); map.put("John", 220); map.put("Ana", 900);map.put("Bill", 440);

        System.out.println(map);

        map = sortByValue(map);

        System.out.println(map);

    }

    private static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {

        List<Map.Entry<K, V>> list = new LinkedList<>( map.entrySet());

        /*
        Collections.sort(list, new Comparator<Map.Entry<K,V>>() {
            @Override
            public int compare(Map.Entry<K,V> o1, Map.Entry<K,V> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        */

        //OR use lambda
        Collections.sort(list, (o1, o2) -> { return o1.getValue().compareTo(o2.getValue()); } );


        Map<K,V> map1 = new LinkedHashMap<K, V>();
        list.forEach(entry -> map1.put(entry.getKey(), entry.getValue()));

        return map1;
    }
}
