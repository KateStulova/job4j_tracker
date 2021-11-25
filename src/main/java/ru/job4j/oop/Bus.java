package ru.job4j.oop;

public class Bus implements Vehicle {
    @Override
    public void move() {
        System.out.println("The bus is on the road");
    }

    @Override
    public void refuel() {
        System.out.println("The bus needs gasoline");
    }
}
