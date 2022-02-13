package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ItemDescByNameTest {
    @Test
    public void sortDescByName() {
        List<Item> items = Arrays.asList(
                new Item(1, "Kate"),
                new Item(2, "One more Kate"),
                new Item(3, "And one more Kate")
        );
        List<Item> expected = Arrays.asList(
                new Item(2, "One more Kate"),
                new Item(1, "Kate"),
                new Item(3, "And one more Kate")
        );
        Collections.sort(items, new ItemDescByName());
        assertThat(items, is(expected));
    }
}