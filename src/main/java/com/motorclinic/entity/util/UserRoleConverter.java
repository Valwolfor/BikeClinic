package com.motorclinic.entity.util;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class UserRoleConverter implements AttributeConverter<UserRole, Byte> {

    @Override
    public Byte convertToDatabaseColumn(UserRole userRole) {
        return userRole == null ? null : userRole.getValue();
    }

    @Override
    public UserRole convertToEntityAttribute(Byte value) {
        if (value == null) {
            return null;
        }

        for (UserRole role : UserRole.values()) {
            if (value.equals(role.getValue())) {
                return role;
            }
        }

        throw new IllegalArgumentException("Unknown database value: " + value);
    }
}
