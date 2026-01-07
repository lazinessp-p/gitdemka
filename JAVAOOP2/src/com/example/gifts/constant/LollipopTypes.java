package com.example.gifts.constant;

public enum LollipopTypes {
    FRUIT("Фруктовый"), COLA("Кола"), CUD("Жевачка");
    private final String displayName;

    LollipopTypes(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}