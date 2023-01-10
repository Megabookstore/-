package com.bookstore_member.megabookstore_member.domain.converter;

import javax.persistence.AttributeConverter;

public class BooleanToYNConverter implements AttributeConverter<Boolean, String> {

    /**
     * Boolean 값을 Y 또는 N 으로 convert!
     *
     * @param attribute boolean 값
     * @return String true  인 경우, Y 또는 false 인 경우 N
     */
    @Override
    public String convertToDatabaseColumn(Boolean attribute) {
        return (attribute != null && attribute) ? "Y" : "N";
    }

    @Override
    public Boolean convertToEntityAttribute(String yn) {
        return "Y".equalsIgnoreCase(yn);
    }
}
