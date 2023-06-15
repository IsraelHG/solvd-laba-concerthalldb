package com.solvd.laba.database.xml.annotations.adapters;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDateTime;

/**
 * Adapter class for marshalling and unmarshalling LocalDateTime objects.
 * Converts LocalDateTime objects to and from their XML representation as strings.
 */
public class LocalDateTimeAdapter extends XmlAdapter<String, LocalDateTime> {
    /**
     * Converts the XML representation (string) of a LocalDateTime object to a LocalDateTime instance.
     *
     * @param value The XML representation of the LocalDateTime object.
     * @return The unmarshalled LocalDateTime object.
     */
    @Override
    public LocalDateTime unmarshal(String value) {
        return LocalDateTime.parse(value);
    }
    /**
     * Converts a LocalDateTime object to its XML representation (string).
     *
     * @param value The LocalDateTime object to be marshalled.
     * @return The XML representation of the LocalDateTime object.
     */
    @Override
    public String marshal(LocalDateTime value) {
        return value.toString();
    }
}
