package com.example.gifts.sweet;

import com.example.gifts.exception.InvalidSweetAttributeException;

public class Caramel extends Sweet {
    private final String flavor;

    public Caramel(String name, int weight, double price, String flavor) throws InvalidSweetAttributeException {
        super(name, weight, price);
        this.flavor = flavor;
    }

    @Override
    public String toString() {
        return String.format("Карамель {Название='%s', Вес=%d, Цена=%.2f, Вкус='%s'}", getName(), getWeight(), getPrice(), flavor);
    }
}