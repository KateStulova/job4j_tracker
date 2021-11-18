package ru.job4j.inheritance;

import java.util.ArrayList;

public class Building {
    private ArrayList<Brick> shop;

    public Building() {
        this.shop = new ArrayList<Brick>();
    }

    public void addBrick(Brick newBrick) {
        this.shop.add(newBrick);
    }
}

