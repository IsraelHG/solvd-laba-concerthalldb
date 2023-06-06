package com.solvd.laba.database;

import com.solvd.laba.database.model.Event;
import com.solvd.laba.database.model.Venue;
import com.solvd.laba.database.service.EventService;
import com.solvd.laba.database.service.VenueService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;

public class Main {
    public static final Logger LOGGER = LogManager.getLogger(Main.class.getName());
    public static void main(String[] args) {
//        Testing my DAO interfaces
//        ---------------------------------------------
//        VenuesDAO venuesDAO = new VenuesDAOImpl();
//        EventsDAO eventsDAO = new EventsDAOImpl();
//        Venues venue1;
//        Events event1;
//        EventsHasVenuesDAO eventsHasVenuesDAO = new EventsHasVenuesDAOImpl();
//        ArrayList<Venues> allVenues;
//        ArrayList<Events> allEvents;
//
//        try {
//            venue1 = venuesDAO.get(1);
//            venue1.getEvents(eventsDAO);
//            allVenues = venuesDAO.getAll();
//
//            event1 = eventsDAO.get(1);
//            event1.getVenues(venuesDAO);
//            allEvents = eventsDAO.getAll();
//
//            EventsHasVenues eventsHasVenues = eventsHasVenuesDAO.get(1);
//
//            LOGGER.info(venue1);
//            LOGGER.info(event1);
//            LOGGER.info(eventsHasVenues);
//            LOGGER.info(allVenues);
//            LOGGER.info(allEvents);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }

//      Testing my Service layer
//      --------------------------------------
        VenueService venueService = new VenueService();
        Venue venue1;

        EventService eventService = new EventService();
        Event event1;
        try {
            venue1 = venueService.getVenue(1);
            LOGGER.info(venue1);

            event1 = eventService.getEvent(1);
            LOGGER.info(event1);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
