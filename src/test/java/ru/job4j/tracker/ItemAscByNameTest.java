package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ItemAscByNameTest {
    @Test
    public void sortAscByNameWithID() {
        List<Item> items = Arrays.asList(
                new Item(1, "Kate"),
                new Item(2, "One more Kate"),
                new Item(3, "And one more Kate")
        );
        List<Item> expected = Arrays.asList(
                new Item(3, "And one more Kate"),
                new Item(1, "Kate"),
                new Item(2, "One more Kate")
        );
        Collections.sort(items, new ItemAscByName());
        assertThat(items, is(expected));
    }

    @Test
    public void sortAscByName() {
        List<Item> items = Arrays.asList(
                new Item("Kate"),
                new Item("One more Kate"),
                new Item("And one more Kate")
        );
        List<Item> expected = Arrays.asList(
                new Item("And one more Kate"),
                new Item("Kate"),
                new Item("One more Kate")
        );
        Collections.sort(items, new ItemAscByName());
        assertThat(items, is(expected));
    }
}