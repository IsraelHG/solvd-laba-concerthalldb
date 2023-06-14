package com.solvd.laba.database.xml.sax;

import com.solvd.laba.database.model.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;

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
    private StringBuilder data;
    private Event event;
    private Venue currentVenue;
    private Artist currentArtist;
    private Equipment currentEquipment;
    private Sponsor currentSponsor;

    @Override
    public void startDocument() {
        LOGGER.info("Document begins here");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        data = new StringBuilder();
        switch (qName) {
            case "event" -> event = new Event();
            case "venue" -> currentVenue = new Venue();
            case "artist" -> currentArtist = new Artist();
            case "equipment" -> currentEquipment = new Equipment();
            case "sponsor" -> currentSponsor = new Sponsor();
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        data.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        switch (qName) {
            case "eventId" -> event.setEventId(Integer.parseInt(data.toString()));
            case "eventName" -> event.setName(data.toString());
            case "startDate" -> event.setStartDate(LocalDateTime.parse(data.toString()));
            case "endDate" -> event.setEndDate(LocalDateTime.parse(data.toString()));
            case "venueId" -> {
                currentVenue.setVenueId(Integer.parseInt(data.toString()));
                addVenueToEvent(currentVenue);
            }
            case "venueName" -> currentVenue.setName(data.toString());
            case "city" -> currentVenue.setCity(data.toString());
            case "state" -> currentVenue.setState(data.toString());
            case "capacity" -> currentVenue.setCapacity(Integer.parseInt(data.toString()));
            case "website" -> currentVenue.setWebsite(data.toString());
            case "artistId" -> {
                currentArtist.setArtistId(Integer.parseInt(data.toString()));
                addArtistToEvent(currentArtist);
            }
            case "firstName" -> currentArtist.setFirstName(data.toString());
            case "lastName" -> currentArtist.setLastName(data.toString());
            case "genre" -> currentArtist.setGenre(data.toString());
            case "email" -> currentArtist.setEmail(data.toString());
            case "equipmentId" -> {
                currentEquipment.setEquipmentId(Integer.parseInt(data.toString()));
                addEquipmentToEvent(currentEquipment);
            }
            case "equipmentName" -> currentEquipment.setName(data.toString());
            case "quantity" -> currentEquipment.setQuantity(Integer.parseInt(data.toString()));
            case "sponsorId" -> {
                currentSponsor.setSponsorId(Integer.parseInt(data.toString()));
                addSponsorToEvent(currentSponsor);
            }
            case "sponsorName" -> currentSponsor.setName(data.toString());
            case "sponsorshipAmount" -> currentSponsor.setSponsorshipAmount(Double.parseDouble(data.toString()));
            case "event" -> LOGGER.info(event);
        }
    }

     /**
     * Adds the provided Venue object to the event's list of venues.
     * If the venues list is null, it initializes a new ArrayList and adds the venue to it.
     *
     * @param venue The Venue object to be added.
     */
    private void addVenueToEvent(Venue venue) {
        if (event.getVenues() == null) {
            event.setVenues(new ArrayList<>());
        }
        event.getVenues().add(venue);
    }

    /**
     * Adds the provided Artist object to the event's list of artists.
     * If the artists list is null, it initializes a new ArrayList and adds the artist to it.
     *
     * @param artist The Artist object to be added.
     */
    private void addArtistToEvent(Artist artist) {
        if (event.getArtists() == null) {
            event.setArtists(new ArrayList<>());
        }
        event.getArtists().add(artist);
    }

    /**
     * Adds the provided Equipment object to the event's list of equipment.
     * If the equipment list is null, it initializes a new ArrayList and adds the equipment to it.
     *
     * @param equipment The Equipment object to be added.
     */
    private void addEquipmentToEvent(Equipment equipment) {
        if (event.getEquipments() == null) {
            event.setEquipments(new ArrayList<>());
        }
        event.getEquipments().add(equipment);
    }

    /**
     * Adds the provided Sponsor object to the event's list of sponsors.
     * If the sponsors list is null, it initializes a new ArrayList and adds the sponsor to it.
     *
     * @param sponsor The Sponsor object to be added.
     */
    private void addSponsorToEvent(Sponsor sponsor) {
        if (event.getSponsors() == null) {
            event.setSponsors(new ArrayList<>());
        }
        event.getSponsors().add(sponsor);
    }

    @Override
    public void endDocument() {
        LOGGER.info("Document ends here");
    }
}