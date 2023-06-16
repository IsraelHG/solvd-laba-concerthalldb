package com.solvd.laba.database;

import com.solvd.laba.database.model.*;
import com.solvd.laba.database.service.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static final Logger LOGGER = LogManager.getLogger(Main.class.getName());
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

//      Testing my Service layer
//      --------------------------------------
        VenueService venueService = new VenueService();
        EventService eventService = new EventService();
        SponsorService sponsorService = new SponsorService();
        EquipmentService equipmentService = new EquipmentService();
        ArtistService artistService = new ArtistService();
        TicketService ticketService = new TicketService();
        StaffService staffService = new StaffService();
        AudienceService audienceService = new AudienceService();
        BookingService bookingService = new BookingService();
        FeedbackService feedbackService = new FeedbackService();

        Venue venue1;
        Event event1;
        Sponsor sponsor1;
        Equipment equipment1;
        Artist artist1;
        Ticket ticket1;
        Staff staff1;
        Audience audience1;
        Booking booking1;
        Feedback feedback1;

        CompletableFuture<Venue> venueFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Venue venue = venueService.getVenue(1);
                LOGGER.info(venue);
                return venue;
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }, executorService);

        CompletableFuture<Event> eventFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Event event = eventService.getEvent(1);
                LOGGER.info(event);
                return event;
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }, executorService);

        CompletableFuture<Sponsor> sponsorFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Sponsor sponsor = sponsorService.getSponsor(1);
                LOGGER.info(sponsor);
                return sponsor;
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }, executorService);

        CompletableFuture<Artist> artistFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Artist artist = artistService.getArtist(1);
                LOGGER.info(artist);
                return artist;
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }, executorService);

        CompletableFuture<Equipment> equipmentFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Equipment equipment = equipmentService.getEquipment(1);
                LOGGER.info(equipment);
                return equipment;
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }, executorService);

        CompletableFuture<Ticket> ticketFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Ticket ticket = ticketService.getTicket(1);
                LOGGER.info(ticket);
                return ticket;
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }, executorService);

        CompletableFuture<Staff> staffFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Staff staff = staffService.getStaff(1);
                LOGGER.info(staff);
                return staff;
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }, executorService);

        CompletableFuture<Audience> audienceFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Audience audience = audienceService.getAudience(1);
                LOGGER.info(audience);
                return audience;
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }, executorService);

        CompletableFuture<Booking> bookingFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Booking booking = bookingService.getBooking(1);
                LOGGER.info(booking);
                return booking;
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }, executorService);

        CompletableFuture<Feedback> feedbackFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Feedback feedback = feedbackService.getFeedback(1);
                LOGGER.info(feedback);
                return feedback;
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }, executorService);

        LOGGER.info("All threads are running: " + Thread.currentThread().getName());

        // Retrieves completed futures.
        try {
            venue1 = venueFuture.get();
            event1 = eventFuture.get();
            sponsor1 = sponsorFuture.get();
            artist1 = artistFuture.get();
            equipment1 = equipmentFuture.get();
            ticket1 = ticketFuture.get();
            staff1 = staffFuture.get();
            audience1 = audienceFuture.get();
            booking1 = bookingFuture.get();
            feedback1 = feedbackFuture.get();

        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

//        Testing the setEntity() from my services
//        --------------------------------------------
//        Event eventToAdd = new Event(100, "New Event", LocalDateTime.now(), LocalDateTime.now().plusHours(2));
//        Artist artistToAdd = new Artist(100, "New", "Artist", "Rock", "new.artist@gmail.com");
//        Equipment equipmentToAdd = new Equipment(100, "Piano", 1);
//        Sponsor sponsorToAdd = new Sponsor(100, "New Company", 20000.00);
//        Venue venueToAdd = new Venue(100, "New Venue", "New City", "New State", 1000, "https://www.newvenue.com/");
//        Ticket ticketToAdd = new Ticket(100, "6000");
//        Booking bookingToAdd = new Booking(100, LocalDateTime.now(), event1, audience1, staff1, ticket1);
//        try {
//            bookingService.setBooking(bookingToAdd);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        // Shutdown the executor service after all tasks are completed
        LOGGER.warn("Executor services shutting down...");
        executorService.shutdown();
    }
}
