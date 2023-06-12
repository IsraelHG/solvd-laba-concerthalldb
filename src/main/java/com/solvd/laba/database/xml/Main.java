package com.solvd.laba.database.xml;

import com.solvd.laba.database.model.Event;
import com.solvd.laba.database.xml.sax.MySAXHandler;
import com.solvd.laba.database.xml.sax.XMLValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.*;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import java.io.*;

import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;

public class Main {
    public static final Logger LOGGER = LogManager.getLogger(Main.class.getName());
    private static final String XML_FILE_PATH = "src/main/resources/event.xml";
    private static final String XSD_FILE_PATH = "event.xsd";
    public static void main(String[] args) {
        try {
            // Validating XML
            XMLValidator xmlValidator = new XMLValidator();
            xmlValidator.validateXML(XML_FILE_PATH, XSD_FILE_PATH);

            // Parsing XML using SAX
            SAXParser p = SAXParserFactory.newInstance().newSAXParser();
            p.parse(new FileInputStream(XML_FILE_PATH), new MySAXHandler());

            // XML to Java using JAX (Unmarshalling)
            JAXBContext jaxbContext = JAXBContext.newInstance(Event.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            File file = new File(XML_FILE_PATH);
            Event event = (Event) unmarshaller.unmarshal(file);
            LOGGER.info(event);

        } catch (SAXException e) {
            e.printStackTrace();
            LOGGER.error("XML validation error: " + e.getMessage());
        } catch (ParserConfigurationException | IOException | JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}
