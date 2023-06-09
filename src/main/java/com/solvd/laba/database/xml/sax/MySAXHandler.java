package com.solvd.laba.database.xml.sax;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

/**
 * <b>MySAXHandler</b>
 * <p>The MySAXHandler class extends the org.xml.sax.helpers.DefaultHandler class
 * and provides customized handling of SAX events during XML parsing.</p>
 * <b>Usage</b>
 * <p>To use the MySAXHandler class, follow these steps:</p>
 * - Create an instance of the MySAXHandler class.<br>
 * - Set the created instance as the handler for the XML parser.<br>
 * - Perform XML parsing using the configured handler.<br>
 * <b>Example:</b>
 * <pre>
 *      // Create an instance of MySAXHandler
 *      MySAXHandler saxHandler = new MySAXHandler();
 *
 *      // Note: Configure the logging mechanism (e.g., Log4j2)
 *
 *      // Set the created instance as the handler for the XML parser
 *      SAXParserFactory factory = SAXParserFactory.newInstance();
 *      SAXParser parser = factory.newSAXParser();
 *      XMLReader reader = parser.getXMLReader();
 *      reader.setContentHandler(saxHandler);
 *
 *      // Perform XML parsing using the configured handler
 *      reader.parse(xmlFilePath);
 * </pre>
 */
public class MySAXHandler extends DefaultHandler {
    public static final Logger LOGGER = LogManager.getLogger(MySAXHandler.class.getName());
    @Override
    public void startDocument() {
        LOGGER.info("Document begins here");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        LOGGER.info("<" + qName + ">");
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        LOGGER.info(new String(ch, start, length));
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        LOGGER.info("</" + qName + ">");
    }

    @Override
    public void endDocument() {
        LOGGER.info("Document ends here");
    }
}