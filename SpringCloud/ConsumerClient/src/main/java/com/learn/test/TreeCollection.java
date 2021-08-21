package com.learn.test;

import java.util.*;

public class TreeCollection {

    public static void main(String[] args) {
        Map map = new HashMap<Integer, String>();
        for (int i = 0; i < 100000; i++) {
            map.put(i, UUID.randomUUID());
        }
        SortedMap treeMap = new TreeMap();
        treeMap.putAll(map);

        treeMap.get(1);

        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            map.get(i);
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);

        start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            treeMap.get(i);
        }
        end = System.currentTimeMillis();
        System.out.println(end-start);
    }
}
