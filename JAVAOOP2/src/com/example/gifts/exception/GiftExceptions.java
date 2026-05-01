package com.example.gifts.exception;

import java.time.LocalDateTime;

public class GiftExceptions extends Exception {
    private final LocalDateTime timestamp;

    public GiftExceptions(String message) {
        super(message);
        this.timestamp = LocalDateTime.now();
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}

