package ru.job4j.tracker;

import org.junit.Assert;
import org.junit.Test;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item();
        item.setName("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        Assert.assertEquals(result.getName(), item.getName());
    }
}