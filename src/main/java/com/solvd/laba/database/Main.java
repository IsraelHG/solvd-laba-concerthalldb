package com.solvd.laba.database;

import com.solvd.laba.database.model.*;
import com.solvd.laba.database.service.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.time.LocalDateTime;

public class Main {
    public static final Logger LOGGER = LogManager.getLogger(Main.class.getName());
    public static void main(String[] args) {

//      Testing my Service layer
//      --------------------------------------
        VenueService venueService = new VenueService();
        EventService eventService = new EventService();
        SponsorService sponsorService = new SponsorService();
        EquipmentService equipmentService = new EquipmentService();
        ArtistService artistService = new ArtistService();

        Venue venue1;
        Event event1;
        Sponsor sponsor1;
        Equipment equipment1;
        Artist artist1;

        try {
            venue1 = venueService.getVenue(1);
            LOGGER.info(venue1);

            event1 = eventService.getEvent(1);
            LOGGER.info(event1);

            sponsor1 = sponsorService.getSponsor(1);
            LOGGER.info(sponsor1);

            equipment1 = equipmentService.getEquipment(1);
            LOGGER.info(equipment1);

            artist1 = artistService.getArtist(1);
            LOGGER.info(artist1);
        } catch (SQLException e) {
            e.printStackTrace();
        }

//        Event eventToAdd = new Event(100, "New Event", LocalDateTime.now(), LocalDateTime.now().plusHours(2));
//        Artist artistToAdd = new Artist(100, "New", "Artist", "Rock", "new.artist@gmail.com");
//        Equipment equipmentToAdd = new Equipment(100, "Piano", 1);
//        Sponsor sponsorToAdd = new Sponsor(100, "New Company", 20000.00);
//        Venue venueToAdd = new Venue(100, "New Venue", "New City", "New State", 1000, "https://www.newvenue.com/");
//        try {
//            //venueService.setVenue(venueToAdd);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }


    }
}
