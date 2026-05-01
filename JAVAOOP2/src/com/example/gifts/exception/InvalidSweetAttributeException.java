package com.example.gifts.exception;

public final class InvalidSweetAttributeException extends GiftExceptions {
    private final String attributeName;

    public InvalidSweetAttributeException(String message, String attributeName) {
        super(message);
        this.attributeName = attributeName;
    }

    public String getAttributeName() {
        return attributeName;
    }
}
