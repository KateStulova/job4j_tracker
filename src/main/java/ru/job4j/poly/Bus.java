package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void drive() {
        System.out.println("Driving...");
    }

    @Override
    public void passengers(int passNumber) {
        System.out.println("Here are " + passNumber + " passengers");
    }

    @Override
    public double refuel(double fuelValue) {
        double rate = 2.3;
        return fuelValue * rate;
    }
}
