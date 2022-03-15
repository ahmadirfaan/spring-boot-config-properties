package com.ahmadirfaanhibatullah.spring.config.converter;

import lombok.SneakyThrows;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Ahmad Irfaan Hibatullah
 * @version $Id: StringToDateConverter.java, v 0.1 2022‐03‐15 21.21 Ahmad Irfaan Hibatullah Exp $$
 */
@Component
public class StringToDateConverter implements Converter<String, Date> {

    private SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * Convert the source object of type {@code S} to target type {@code T}.
     *
     * @param source the source object to convert, which must be an instance of {@code S} (never {@code null})
     * @return the converted object, which must be an instance of {@code T} (potentially {@code null})
     * @throws IllegalArgumentException if the source cannot be converted to the desired target type
     */
    @Override
    @SneakyThrows
    public Date convert(String source) {
        return DATE_FORMAT.parse(source);
    }
}