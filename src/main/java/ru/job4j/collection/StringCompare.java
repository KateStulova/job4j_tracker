package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int rsl = 0;
        int leftLength = left.length();
        int rightLength = right.length();
        int whatIsShorter = Integer.compare(leftLength, rightLength);
        if (whatIsShorter < 0) {
            for (int i = 0; i < leftLength; i++) {
                int innerRsl = Character.compare(left.charAt(i), right.charAt(i));
                if (innerRsl != 0) {
                    rsl = innerRsl;
                    break;
                }
                if (i == leftLength - 1) {
                    rsl = leftLength - rightLength;
                    break;
                }
            }
        } else if (whatIsShorter > 0) {
            for (int i = 0; i < rightLength; i++) {
                int innerRsl = Character.compare(left.charAt(i), right.charAt(i));
                if (innerRsl != 0) {
                    rsl = innerRsl;
                    break;
                }
                if (i == rightLength - 1) {
                    rsl = leftLength - rightLength;
                    break;
                }
            }
        } else {
            for (int i = 0; i < leftLength; i++) {
                int innerRsl = Character.compare(left.charAt(i), right.charAt(i));
                if (innerRsl != 0) {
                    rsl = innerRsl;
                    break;
                }
            }
        }
        return rsl;
        }
    }
