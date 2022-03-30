package ru.job4j.collection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int result = 0;
        List<String> splitString1 = new ArrayList<>(List.of(o1.split("/", 2)));
        splitString1.add("");
        List<String> splitString2 = new ArrayList<>(List.of(o2.split("/", 2)));
        splitString2.add("");
        if (splitString2.get(0).compareTo(splitString1.get(0)) == 0) {
            result = splitString1.get(1).compareTo(splitString2.get(1));
        } else {
            result = splitString2.get(0).compareTo(splitString1.get(0));
        }
        return result;
    }
}
