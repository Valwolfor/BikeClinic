package com.motorclinic.entity.util;

public enum UserRole {
    MECHANIC((byte) 1),
    ASSISTANT((byte) 2),
    ADMIN((byte) 3);

    private final byte value;

    UserRole(byte value) {
        this.value = value;
    }

    public byte getValue() {
        return value;
    }
}

