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

        Venue venue1;
        Event event1;
        Sponsor sponsor1;
        Equipment equipment1;
        Artist artist1;
        Ticket ticket1;

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

        LOGGER.info("All threads are running: " + Thread.currentThread().getName());

        // Retrieves completed futures.
        try {
            venue1 = venueFuture.get();
            event1 = eventFuture.get();
            sponsor1 = sponsorFuture.get();
            artist1 = artistFuture.get();
            equipment1 = equipmentFuture.get();
            ticket1 = ticketFuture.get();

        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
//        LOGGER.info(venue1);
//        LOGGER.info(event1);
//        LOGGER.info(sponsor1);
//        LOGGER.info(artist1);
//        LOGGER.info(equipment1);
//        LOGGER.info(ticket1);

        // Shutdown the executor service after all tasks are completed
        LOGGER.warn("Executor services shutting down...");
        executorService.shutdown();

//        Testing the setEntity() from my services
//        --------------------------------------------
//        Event eventToAdd = new Event(100, "New Event", LocalDateTime.now(), LocalDateTime.now().plusHours(2));
//        Artist artistToAdd = new Artist(100, "New", "Artist", "Rock", "new.artist@gmail.com");
//        Equipment equipmentToAdd = new Equipment(100, "Piano", 1);
//        Sponsor sponsorToAdd = new Sponsor(100, "New Company", 20000.00);
//        Venue venueToAdd = new Venue(100, "New Venue", "New City", "New State", 1000, "https://www.newvenue.com/");
//        Ticket ticketToAdd = new Ticket(100, "6000");
//        try {
//            ticketService.setTicket(ticketToAdd);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }
}
