package com.solvd.laba.database.xml.sax;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

/**
 * <b>XML Validator</b>
 * <p>The XMLValidator class is responsible for validating an XML document
 * against an XML Schema Definition (XSD) file using the SAX parser.</p>
 *
 * <b>Usage</b>
 * <p>To use the XMLValidator class, follow these steps:</p>
 *
 * - Create an instance of the XMLValidator class.<br>
 * - Call the validateXML method, passing the path to the XML file and the path to the XSD file as arguments.<br>
 * - Handle any exceptions that may be thrown during the validation process.
 * <p>
 * <b>Example</b>
 * <pre>
 * try {
 *     XMLValidator validator = new XMLValidator();
 *     validator.validateXML("path/to/xml/file.xml", "path/to/xsd/file.xsd");
 *     System.out.println("XML validation succeeded.");
 * } catch (SAXException e) {
 *     System.out.println("XML validation failed. Error: " + e.getMessage());
 * }
 * </pre>
 *
 */
public class XMLValidator {
    public static final Logger LOGGER = LogManager.getLogger(XMLValidator.class.getName());
    /**
     * This method validates an XML document against an XSD file.
     * @param xmlFilePath The path to the XML file that needs to be validated.
     * @param xsdFilePath The path to the XSD file that contains the schema definition.
     * @throws SAXException Thrown if the XML validation fails or there is an error during the parsing process.
     */
    public void validateXML(String xmlFilePath, String xsdFilePath) throws SAXException {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            factory.setValidating(true);
            factory.setNamespaceAware(true);
            factory.setFeature("http://apache.org/xml/features/validation/schema", true);

            SAXParser parser = factory.newSAXParser();
            XMLReader reader = parser.getXMLReader();
            reader.setProperty("http://apache.org/xml/properties/schema/external-noNamespaceSchemaLocation", xsdFilePath);
            reader.setErrorHandler(new MyErrorHandler());

            reader.parse(xmlFilePath);
        } catch (ParserConfigurationException | IOException e) {
            e.printStackTrace();
            LOGGER.error("Parser configuration error: " + e.getMessage());
        }
    }
}
