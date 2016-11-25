package com.icafruta.sispack.utils.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Created by alxnderq on 11/25/2016.
 */
@Converter(autoApply = true)
public class BooleanNumericConverter implements AttributeConverter<Boolean, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Boolean value) {
        Integer number = 0;
        if (Boolean.TRUE.equals(value)){
            number = 1;
        }
        return number;
    }

    @Override
    public Boolean convertToEntityAttribute(Integer value) {
        Integer number = 1;
        return number.equals(value);
    }
}
