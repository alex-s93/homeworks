package com.alevel.homework17;

import java.util.*;

public class MapTest {
    public static void main(String[] args) {
        TreeMap<String, String> map = new TreeMap<>();
        map.put("one", "один");
        map.put("two", "два");
        map.put("three", "три");
        map.put("four", "четыре");
        map.put("five", "пять");

        replaceKeyValue(map);
    }

    public static void replaceKeyValue(TreeMap<String, String> map) {
// WARNING!!! There is no guarantee that only unprocessed objects will be on the first entry
//        for (int i = 0; i < map.size(); i++) {
//            map.put(map.firstEntry().getValue(), map.pollFirstEntry().getKey());
//        }

        List<String[]> tempArray = new ArrayList<>();
        for (Map.Entry<String, String> entry: map.entrySet()) {
            tempArray.add(new String[]{ entry.getValue(), entry.getKey() });
        }

        map.clear();

        for (String[] row: tempArray) {
            map.put(row[0], row[1]);
        }
    };
}
