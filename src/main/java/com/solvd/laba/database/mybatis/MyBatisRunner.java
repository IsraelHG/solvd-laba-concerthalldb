package com.solvd.laba.database.mybatis;

import com.solvd.laba.database.mapperService.*;
import com.solvd.laba.database.model.*;
//import com.solvd.laba.database.mapperService.BookingService;
import com.solvd.laba.database.mapperService.FeedbackService;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class MyBatisRunner {
    public static final Logger LOGGER = LogManager.getLogger(MyBatisRunner.class.getName());
    public static void main(String[] args) {
        // Get the SqlSessionFactory from MyBatisConfig
        SqlSessionFactory sqlSessionFactory = MyBatisConfig.getSqlSessionFactory();

        ArtistService artistService = new ArtistService(sqlSessionFactory);
        EventService eventService = new EventService(sqlSessionFactory);
        SponsorService sponsorService = new SponsorService(sqlSessionFactory);
        EquipmentService equipmentService = new EquipmentService(sqlSessionFactory);
        VenueService venueService = new VenueService(sqlSessionFactory);
        StaffService staffService = new StaffService(sqlSessionFactory);
        TicketService ticketService = new TicketService(sqlSessionFactory);
        AudienceService audienceService = new AudienceService(sqlSessionFactory);
        //BookingService bookingService = new BookingService(sqlSessionFactory);
        FeedbackService feedbackService = new FeedbackService(sqlSessionFactory);

        // GET - Select by id
        Artist artistFromDb = artistService.getArtistById(1);
        Event eventFromDb = eventService.getEventById(1);
        Sponsor sponsorFromDb = sponsorService.getSponsorById(1);
        Equipment equipmentFromDb = equipmentService.getEquipmentById(1);
        Venue venueFromDb = venueService.getVenueById(1);
        Staff staffFromDb = staffService.getStaffById(1);
        Ticket ticketFromDb = ticketService.getTicketById(1);
        Audience audienceFromDb = audienceService.getAudienceById(1);
        //Booking bookingFromDb = bookingService.getBookingById(1);
        Feedback feedbackFromDb = feedbackService.getFeedbackById(1);


        LOGGER.info("Artist FROM DB: " + artistFromDb);
        LOGGER.info("Event FROM DB: " + eventFromDb);
        LOGGER.info("Sponsor FROM DB: " + sponsorFromDb);
        LOGGER.info("Equipment FROM DB: " + equipmentFromDb);
        LOGGER.info("Venue FROM DB: " + venueFromDb);
        LOGGER.info("Staff FROM DB: " + staffFromDb);
        LOGGER.info("Ticket FROM DB: " + ticketFromDb);
        LOGGER.info("Audience FROM DB: " + audienceFromDb);
        //LOGGER.info("Booking FROM DB: " + bookingFromDb);
        LOGGER.info("Feedback FROM DB: " + feedbackFromDb);
    }
}
