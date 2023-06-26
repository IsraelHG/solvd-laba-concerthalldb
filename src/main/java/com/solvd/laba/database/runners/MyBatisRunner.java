package com.solvd.laba.database.runners;

import com.solvd.laba.database.model.*;
//import com.solvd.laba.database.mapperService.BookingService;
import com.solvd.laba.database.service.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyBatisRunner {
    public static final Logger LOGGER = LogManager.getLogger(MyBatisRunner.class.getName());
    public static void main(String[] args) {

        ArtistServiceMyBatis artistServiceMyBatis = new ArtistServiceMyBatis();
//        EventServiceMyBatis eventServiceMyBatis = new EventServiceMyBatis(sqlSessionFactory);
//        SponsorServiceMyBatis sponsorServiceMyBatis = new SponsorServiceMyBatis(sqlSessionFactory);
//        EquipmentServiceMyBatis equipmentServiceMyBatis = new EquipmentServiceMyBatis(sqlSessionFactory);
//        VenueServiceMyBatis venueServiceMyBatis = new VenueServiceMyBatis(sqlSessionFactory);
//        StaffServiceMyBatis staffServiceMyBatis = new StaffServiceMyBatis(sqlSessionFactory);
//        TicketServiceMyBatis ticketServiceMyBatis = new TicketServiceMyBatis(sqlSessionFactory);
//        AudienceServiceMyBatis audienceServiceMyBatis = new AudienceServiceMyBatis(sqlSessionFactory);
//        //BookingService bookingService = new BookingService(sqlSessionFactory);
//        FeedbackServiceMyBatis feedbackServiceMyBatis = new FeedbackServiceMyBatis(sqlSessionFactory);

        // GET - Select by id
        Artist artistFromDb = artistServiceMyBatis.getArtistById(1);
//        Event eventFromDb = eventServiceMyBatis.getEventById(1);
//        Sponsor sponsorFromDb = sponsorServiceMyBatis.getSponsorById(1);
//        Equipment equipmentFromDb = equipmentServiceMyBatis.getEquipmentById(1);
//        Venue venueFromDb = venueServiceMyBatis.getVenueById(1);
//        Staff staffFromDb = staffServiceMyBatis.getStaffById(1);
//        Ticket ticketFromDb = ticketServiceMyBatis.getTicketById(1);
//        Audience audienceFromDb = audienceServiceMyBatis.getAudienceById(1);
//        //Booking bookingFromDb = bookingService.getBookingById(1);
//        Feedback feedbackFromDb = feedbackServiceMyBatis.getFeedbackById(1);


        LOGGER.info("Artist FROM DB: " + artistFromDb);
//        LOGGER.info("Event FROM DB: " + eventFromDb);
//        LOGGER.info("Sponsor FROM DB: " + sponsorFromDb);
//        LOGGER.info("Equipment FROM DB: " + equipmentFromDb);
//        LOGGER.info("Venue FROM DB: " + venueFromDb);
//        LOGGER.info("Staff FROM DB: " + staffFromDb);
//        LOGGER.info("Ticket FROM DB: " + ticketFromDb);
//        LOGGER.info("Audience FROM DB: " + audienceFromDb);
//        //LOGGER.info("Booking FROM DB: " + bookingFromDb);
//        LOGGER.info("Feedback FROM DB: " + feedbackFromDb);
    }
}
