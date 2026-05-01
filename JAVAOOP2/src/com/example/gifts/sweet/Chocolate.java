package com.example.gifts.sweet;

import com.example.gifts.exception.InvalidSweetAttributeException;

public class Chocolate extends Sweet {
    private final String type;

    public Chocolate(String name, int weight, double price, String type) throws InvalidSweetAttributeException {
        super(name, weight, price);
        this.type = type;
    }

    @Override
    public String toString() {
        return String.format("Шоколад {Название='%s', Вес=%d, Цена=%.2f, Тип='%s'}", getName(), getWeight(), getPrice(), type);
    }
}
