package com.solvd.laba.database.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.solvd.laba.database.model.Event;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;

/**
 * The JsonParser class is responsible for parsing Event objects to JSON and vice versa using Jackson library.
 * It provides methods to read an Event object from a JSON file and write an Event object to a JSON file.
 */
public class JsonParser {
    public static final Logger LOGGER = LogManager.getLogger(JsonParser.class.getName());
    public static final String JSON_FILE_PATH = "src/main/resources/json/event.json";
    public static final String JSON_FILE_PATH_OUTPUT = "src/main/resources/json/event_parsed.json";

    /**
     * Reads an Event object from a JSON file and prints the parsed Event object.
     */
    public static void main(String[] args) {
        // Create an instance of ObjectMapper, which is the main class for reading and writing JSON.
        ObjectMapper mapper = new ObjectMapper();

        // Enable pretty-printing of the JSON output.
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        try {
            // Parsing Event object from JSON
            // Read the Event object from the JSON file and map it to the Event class.
            Event event = mapper.readValue(new File(JSON_FILE_PATH), Event.class);
            LOGGER.info("Parsed Event object from JSON:\n" + event);

            // Creating JSON from Event object
            // Write the Event object to a JSON file.
            mapper.writeValue(new File(JSON_FILE_PATH_OUTPUT), event);
            LOGGER.info("Event object converted to JSON and saved to file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}