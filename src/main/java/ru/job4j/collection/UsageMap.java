package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("stulova.ek@gmail.com", "Stulova");
        map.put("stulova.ek@gmail.com", "Stulova");
        map.put("stulova.ek@gmail.com", "Stulova");
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(value);
        }
    }
}
