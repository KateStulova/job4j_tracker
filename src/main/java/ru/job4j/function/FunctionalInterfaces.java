package ru.job4j.function;

import java.util.*;
import java.util.function.*;

public class FunctionalInterfaces {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        List<String> strings = List.of("one", "two", "three", "four", "five", "six", "seven");
        BiConsumer<Integer, String> biCon = (i, s) -> map.put(i, s);
        int count = 1;
        for (String s : strings) {
            biCon.accept(count++, s);
        }

        BiPredicate<Integer, String> biPred = (i, s) -> i % 2 == 0 || s.length() == 4;
        for (Integer key : map.keySet()) {
            if (biPred.test(key, map.get(key))) {
                System.out.println("key: " + key + " value: " + map.get(key));
            }
        }

        Supplier<List<String>> sup = () -> new ArrayList<>(map.values());
        List<String> stringsList = sup.get();

        Consumer<String> con = s -> System.out.println(s);
        Function<String, String> func = s -> s.toUpperCase();
        for (String s : stringsList) {
            con.accept(func.apply(s));
        }
    }
}
