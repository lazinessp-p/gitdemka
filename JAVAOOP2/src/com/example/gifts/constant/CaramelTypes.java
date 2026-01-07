package com.example.gifts.constant;

public enum CaramelTypes {
    STRAWBERRY("Клубничный"), VANILLA("Ванильный");
    private final String displayName;

    CaramelTypes(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
