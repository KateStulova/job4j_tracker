package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] leftTemp = left.split("\\.\\s\\D*\\.");
        String[] rightTemp = right.split("\\.\\s\\D*\\.");
        int leftNumber = Integer.parseInt(leftTemp[0]);
        int rightNumber = Integer.parseInt(rightTemp[0]);
        return Integer.compare(leftNumber, rightNumber);
    }
}
