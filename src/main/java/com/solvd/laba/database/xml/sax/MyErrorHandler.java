package com.solvd.laba.database.xml.sax;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXParseException;

/**
 * <b>MyErrorHandler</b>
 * <p>The MyErrorHandler class is an implementation of the org.xml.sax.
 * ErrorHandler interface, used to handle parsing errors and warnings during XML validation.</p>
 * <b>Usage</b>
 * <p>To use the MyErrorHandler class, follow these steps:</p>
 * - Create an instance of the MyErrorHandler class.<br>
 * - Set the created instance as the error handler for the XML parser.<br>
 * <b>Example:</b>
 * <pre>
 *     // Create an instance of MyErrorHandler
 *      MyErrorHandler errorHandler = new MyErrorHandler();
 *
 *      // Set the created instance as the error handler for the XML parser
 *      SAXParserFactory factory = SAXParserFactory.newInstance();
 *      SAXParser parser = factory.newSAXParser();
 *      XMLReader reader = parser.getXMLReader();
 *      reader.setErrorHandler(errorHandler);
 *
 *      // Perform XML parsing and validation using the configured error handler
 *      reader.parse(xmlFilePath);
 * </pre>
 *
 */
public class MyErrorHandler implements ErrorHandler {
    public static final Logger LOGGER = LogManager.getLogger(MyErrorHandler.class.getName());
    @Override
    public void warning(SAXParseException exception) {
        LOGGER.warn(exception.getMessage());
    }

    @Override
    public void error(SAXParseException exception) {
        LOGGER.error(exception.getMessage());
    }

    @Override
    public void fatalError(SAXParseException exception) {
        LOGGER.fatal(exception.getMessage());
    }
}
