package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
        Item item1 = new Item();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String currentDateTimeFormat = item1.getDateTime().format(formatter);
        System.out.println("Текущие дата и время после форматирования: " + currentDateTimeFormat);
        Item item2 = new Item();
        System.out.println(item2);
    }
}
