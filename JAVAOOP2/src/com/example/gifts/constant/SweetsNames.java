package com.example.gifts.constant;

public enum SweetsNames {
    SNICKERS("Snickers"),
    MILKA("Milka"),
    ALPEN_GOLD("Alpen Gold"),
    KITKAT("KitKat"),
    MARS("Mars"),
    BOUNTY("Bounty"),
    TWIX("Twix");

    private final String displayName;

    SweetsNames(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
