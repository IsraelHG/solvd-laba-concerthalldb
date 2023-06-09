package com.solvd.laba.database.xml;

import com.solvd.laba.database.xml.sax.MySAXHandler;
import com.solvd.laba.database.xml.sax.XMLValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import java.io.FileInputStream;
import java.io.IOException;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;

public class Main {
    public static final Logger LOGGER = LogManager.getLogger(Main.class.getName());
    private static final String XML_FILE_PATH = "src/main/resources/events.xml";
    private static final String XSD_FILE_PATH = "events.xsd";
    public static void main(String[] args) {
        try {
            XMLValidator xmlValidator = new XMLValidator();
            xmlValidator.validateXML(XML_FILE_PATH, XSD_FILE_PATH);

            SAXParser p = SAXParserFactory.newInstance().newSAXParser();
            p.parse(new FileInputStream(XML_FILE_PATH), new MySAXHandler());

        } catch (SAXException e) {
            e.printStackTrace();
            LOGGER.error("XML validation error: " + e.getMessage());
        } catch (ParserConfigurationException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
