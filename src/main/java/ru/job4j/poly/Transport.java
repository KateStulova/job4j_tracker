package ru.job4j.poly;

public interface Transport {
    void drive();

    void passengers(int passNumber);

    double refuel(double fuelValue);
}
