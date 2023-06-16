package com.solvd.laba.database.json.annotations.serialize;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * The LocalDateTimeSerializer class is a custom serializer used by Jackson library
 * to serialize LocalDateTime objects to a specific format.
 * It implements the JsonSerializer interface.
 */
public class LocalDateTimeSerializer extends JsonSerializer<LocalDateTime> {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

    /**
     * Serializes the LocalDateTime object to a specific format.
     *
     * @param dateTime  the LocalDateTime object to be serialized
     * @param jsonGenerator the JsonGenerator used to write the JSON data
     * @param serializerProvider the SerializerProvider used to access serializers
     * @throws IOException if an I/O error occurs while writing the JSON data
     */
    @Override
    public void serialize(LocalDateTime dateTime, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (dateTime == null) {
            jsonGenerator.writeNull();
        } else {
            // Format the LocalDateTime object to a specific format
            String formattedDateTime = dateTime.format(formatter);

            // Write the formatted LocalDateTime to the JSON generator
            jsonGenerator.writeString(formattedDateTime);
        }
    }
}
