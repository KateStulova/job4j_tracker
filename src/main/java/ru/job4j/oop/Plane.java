package ru.job4j.oop;

public class Plane implements Vehicle {
    @Override
    public void move() {
        System.out.println("The plane is in the air");
    }

    @Override
    public void refuel() {
        System.out.println("The plane needs aviation kerosene");
    }
}
