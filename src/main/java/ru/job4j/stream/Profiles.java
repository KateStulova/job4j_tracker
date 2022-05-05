package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    public static List<Address> collect(List<Profile> profiles) {
        return profiles.stream()
                .map(Profile::getAddress)
                .collect(Collectors.toList());
    }

    public static List<Address> collectSortWithoutDuplicates(List<Profile> profiles) {
        return profiles.stream()
                .map(Profile::getAddress)
                .sorted(new SortAddressByCity())
                .distinct()
                .collect(Collectors.toList());
    }
}
