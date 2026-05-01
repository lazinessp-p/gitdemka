package com.example.gifts.sweet;

import com.example.gifts.exception.InvalidSweetAttributeException;

public abstract class Sweet {
    private final String name;
    private final int weight;
    private final double price;

    public Sweet(String name, int weight, double price) throws InvalidSweetAttributeException {
        if (name == null || name.trim().isEmpty()) {
            throw new InvalidSweetAttributeException("Имя не может быть пустым", "name");
        }
        if (weight <= 0) {
            throw new InvalidSweetAttributeException("Вес должен быть положительным", "weight");
        }
        if (price < 0) {
            throw new InvalidSweetAttributeException("Цена не может быть отрицательной", "price");
        }
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public double getPrice() {
        return price;
    }
}
