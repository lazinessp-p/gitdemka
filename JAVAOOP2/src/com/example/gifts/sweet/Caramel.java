package com.example.gifts.sweet;

public class Caramel extends Sweet {
    private String caramelType;

    public Caramel(String name, int weight, double price, String caramelType) {
        super(name, weight, price);
        this.caramelType = caramelType;
    }

    public String getFlavorCaramel() {
        return caramelType;
    }

    @Override
    public String toString() {
        return "caramel{" + "name=" + getName() + '\'' + getWeight() + "price=" + getPrice() + "flavor=" + caramelType + "\'" + "}";
    }
}
