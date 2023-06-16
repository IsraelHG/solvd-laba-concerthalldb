package com.solvd.laba.database.json.annotations.serialize;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * The LocalDateTimeDeserializer class is a custom deserializer used by Jackson library
 * to deserialize a JSON string to a LocalDateTime object.
 * It implements the JsonDeserializer interface.
 */
public class LocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
    /**
     * Deserializes a JSON string to a LocalDateTime object.
     *
     * @param jsonParser the JsonParser used to read the JSON data
     * @param deserializationContext the DeserializationContext used to access deserialization features
     * @return the deserialized LocalDateTime object
     * @throws IOException if an I/O error occurs while reading the JSON data
     */
    @Override
    public LocalDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        String dateString = jsonParser.getValueAsString();
        if (dateString == null || dateString.isEmpty()) {
            return null;
        }
        return LocalDateTime.parse(dateString, formatter);
    }
}
