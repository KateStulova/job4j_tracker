package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        Item[] itemsWithoutNull = new Item[100];
        int size = 0;
        for (Item item : items) {
            if (item == null) {
                break;
            }
            itemsWithoutNull[size] = item;
            size++;
        }
        return Arrays.copyOf(itemsWithoutNull, size);
    }

    public Item[] findByName(String key) {
        Item[] res = new Item[100];
        int size = 0;
        for (Item item : items) {
            if (item == null) {
                break;
            }
            if (key.equals(item.getName())) {
                res[size] = item;
                size++;
            }
        }
        return Arrays.copyOf(res, size);
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }
}