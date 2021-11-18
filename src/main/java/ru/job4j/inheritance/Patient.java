package ru.job4j.inheritance;

import java.util.ArrayList;
import java.util.Collections;

public class Patient {
    private ArrayList<Suture> sutureCollection;
    private ArrayList<Boolean> curedOrNot;

    public Patient() {
        this.sutureCollection = new ArrayList<Suture>();
        this.curedOrNot = new ArrayList<Boolean>();
    }

    public int addSuture(Suture sut) {
        this.sutureCollection.add(sut);
        return this.sutureCollection.size();
    }

    public void addAndShuffleValues() {
        this.curedOrNot.add(false);
        this.curedOrNot.add(true);
        Collections.shuffle(this.curedOrNot);
    }

    public boolean tryTocure() {
        addAndShuffleValues();
        return this.curedOrNot.get(0);
    }
}
