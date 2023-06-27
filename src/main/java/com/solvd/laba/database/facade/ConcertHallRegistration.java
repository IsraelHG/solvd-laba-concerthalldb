package com.solvd.laba.database.facade;

import com.solvd.laba.database.enums.Gender;
import com.solvd.laba.database.factory.ServiceFactory;
import com.solvd.laba.database.interfaces.*;
import com.solvd.laba.database.model.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.time.LocalDateTime;
import java.util.Random;

/**
 * The ConcertHallRegistration class provides methods for audience registration and creating bookings for events
 * in a concert hall.
 */
public class ConcertHallRegistration {
    public static final Logger LOGGER = LogManager.getLogger(ConcertHallRegistration.class.getName());
    private final IAudienceService audienceService;
    private final ITicketService ticketService;
    private final IEventService eventToBookService;
    private final IBookingService bookingService;
    private final IStaffService staffService;

    /**
     * Constructs a new ConcertHallRegistration instance, initializing the required services.
     */
    public ConcertHallRegistration() {
        audienceService = ServiceFactory.createAudienceService("mybatis");
        ticketService = ServiceFactory.createTicketService("mybatis");
        eventToBookService = ServiceFactory.createEventService("mybatis");
        bookingService = ServiceFactory.createBookingService("mybatis");
        staffService = ServiceFactory.createStaffService("mybatis");
    }

    /**
     * Registers a new audience member.
     *
     * @param firstName the first name of the audience member
     * @param lastName the last name of the audience member
     * @param age the age of the audience member
     * @param gender the gender of the audience member (allowed values: "Male", "Female", "Other")
     * @param email the email address of the audience member
     * @return the registered Audience object if successful, null otherwise
     */
    public Audience register(String firstName, String lastName, int age, String gender, String email) {
        // Checks if account already exists in the database
        Audience audienceFromDb = audienceService.getAudienceByEmail(email);
        if (audienceFromDb != null) {
            LOGGER.info("You have an account with us already.");
            return audienceFromDb;
        }
        // Creates new account into the database
        Audience audienceToDb = new Audience(firstName, lastName, age, Gender.fromValue(gender), email);
        audienceService.setAudience(audienceToDb);

        LOGGER.info("Registration successful, " + firstName + "!");
        return audienceService.getAudienceByEmail(email);
    }

    /**
     * Creates a booking for an event for a given audience.
     *
     * @param audience the audience for whom the booking is created
     * @param eventToBookId the ID of the event to book
     * @return true if the booking is successful, false otherwise
     */
    public boolean createBookingForEvent(Audience audience, int eventToBookId) {
        Event eventToBook = eventToBookService.getEventById(eventToBookId);
        // if the event based on given ID does not exist in the database
        if (eventToBook == null) {
            return false;
        }
        // Sets up a booking for the given event ID and the given audience that wants to attend event
        Staff staffToBook = staffService.getStaffById(new Random().nextInt(3) + 1);
        Ticket ticketToBook = ticketService.getTicketById(new Random().nextInt(6) + 1);
        Booking newBooking = new Booking(LocalDateTime.now(), eventToBook, audience, staffToBook, ticketToBook);
        // sets a new booking and adds it to the database
        bookingService.setBooking(newBooking);
        return true;
    }
}
