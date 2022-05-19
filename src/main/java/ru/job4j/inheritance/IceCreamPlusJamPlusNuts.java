package ru.job4j.inheritance;

public class IceCreamPlusJamPlusNuts extends IceCreamPlusJam {
    private static final int NUTS_PRICE = 25;

    public IceCreamPlusJamPlusNuts(int weight) {
        super(weight);
    }

    @Override
    public int price() {
        return NUTS_PRICE + super.price();
    }

    public static void main(String[] args) {
        IceCreamPlusJam iceCreamPJ = new IceCreamPlusJam(2);
        IceCreamPlusJamPlusNuts iceCreamPJPN = new IceCreamPlusJamPlusNuts(4);
        System.out.println(iceCreamPJ.price());
        System.out.println(iceCreamPJPN.price());
    }
}
