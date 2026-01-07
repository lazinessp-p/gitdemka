package com.example.gifts.constant;

public enum ChocolateTypes {
    MILK("Молочный"),
    DARK("Темный"),
    WHITE("Белый"),
    AIR("Воздушный");

    public final String displayName;

    ChocolateTypes(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}