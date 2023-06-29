package com.solvd.laba.database.facade;

import org.apache.commons.lang3.StringUtils;
import com.solvd.laba.database.enums.Gender;
import com.solvd.laba.database.factory.ServiceFactory;
import com.solvd.laba.database.interfaces.*;
import com.solvd.laba.database.model.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.time.LocalDateTime;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The ConcertHallRegistration class provides methods for audience registration and creating bookings for events
 * in a concert hall.
 */
public class ConcertHallAccount {
    public static final Logger LOGGER = LogManager.getLogger(ConcertHallAccount.class.getName());
    private final IAudienceService audienceService;
    private final ITicketService ticketService;
    private final IEventService eventToBookService;
    private final IBookingService bookingService;
    private final IStaffService staffService;
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String REGEX = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";

    /**
     * Constructs a new ConcertHallRegistration instance, initializing the required services.
     */
    public ConcertHallAccount() {
        audienceService = ServiceFactory.createAudienceService("mybatis");
        ticketService = ServiceFactory.createTicketService("mybatis");
        eventToBookService = ServiceFactory.createEventService("mybatis");
        bookingService = ServiceFactory.createBookingService("mybatis");
        staffService = ServiceFactory.createStaffService("mybatis");
    }

    /**
     * Registers a new audience member.
     */
    public Audience register() {
        LOGGER.info("What is your email?");
        String email = SCANNER.nextLine().trim().toLowerCase();

        boolean validEmail = false;
        do {
            Pattern pattern = Pattern.compile(REGEX);
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()) {
                validEmail = true;
            } else {
                LOGGER.info("Invalid email format. Please enter a valid email address.");
                LOGGER.info("What is your email?");
                email = SCANNER.nextLine().trim().toLowerCase();
            }
        } while (!validEmail);


        Audience audienceFromDb = audienceService.getAudienceByEmail(email);
        if (audienceFromDb != null) {
            LOGGER.info("You already have an account with us.");
            LOGGER.info(audienceFromDb);
            return audienceFromDb;
        }

        LOGGER.info("What is your first name?");
        String firstName = StringUtils.capitalize(SCANNER.nextLine().trim().toLowerCase());

        LOGGER.info("What is your last name?");
        String lastName = StringUtils.capitalize(SCANNER.nextLine().trim().toLowerCase());

        LOGGER.info("What is your age?");
        int age = SCANNER.nextInt();

        SCANNER.nextLine(); // Consume the remaining newline character

        String gender = "Other";
        boolean validGenderInput = false;
        do {
            LOGGER.info("What is your gender? [(M)ale / (F)emale / Other]");
            String input = SCANNER.nextLine().trim().toLowerCase();

            if (input.matches("^(m|male)$")) {
                gender = "Male";
                validGenderInput = true;
            } else if (input.matches("^(f|female)$")) {
                gender = "Female";
                validGenderInput = true;
            } else if (input.matches("^(o|other)$")) {
                gender = "Other";
                validGenderInput = true;
            } else {
                LOGGER.info("Invalid gender input. Please enter 'M' for Male, 'F' for Female, or 'Other'.");
            }
        } while (!validGenderInput);


        Audience newAccount = new Audience(firstName, lastName, age, Gender.fromValue(gender), email);
        audienceService.setAudience(newAccount);
        LOGGER.info("Registration successful!");

        return audienceService.getAudienceByEmail(email);
    }


    public Audience login() {
        Audience audienceFromDb = null;
        boolean validEmail = false;

        do {
            LOGGER.info("What is your email?");
            String email = SCANNER.nextLine();

            Pattern pattern = Pattern.compile(REGEX);
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()) {
                audienceFromDb = audienceService.getAudienceByEmail(email);
                validEmail = true;
            } else {
                LOGGER.info("Invalid email format. Please enter a valid email address.");
            }
        } while (!validEmail);


        if (audienceFromDb == null) {
            LOGGER.info("You do not have an account with us.");
            boolean validInput = false;
            do {
                LOGGER.info("Would you like to create an account? [y/n]");
                String input = SCANNER.nextLine().trim().toLowerCase();

                if (input.matches("^(y|yes)$")) {
                    return register();
                } else if (input.matches("^(n|no)$")) {
                    validInput = true;
                } else {
                    LOGGER.info("Invalid input. Please enter 'y' for Yes or 'n' for No.");
                }
            } while (!validInput);
        }
        return audienceFromDb;
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
            LOGGER.info("The event you provided does not exist.");
            return false;
        }
        // Gets the booking (if any) of a specific audience to see if they already booked for an event.
        Booking bookingFromDb = bookingService.getBookingByAudienceId(audience.getAudienceId());
        if (bookingFromDb != null) {
            LOGGER.info("You already booked for an event: ");
            LOGGER.info("Event: " + bookingFromDb.getEvent().getName());
            LOGGER.info("Your name: " + bookingFromDb.getAudience().getFirstName());
            LOGGER.info("Date: " + bookingFromDb.getBookingDate());
            return false;
        }

        // Sets up a booking for the given event ID and the given audience that wants to attend event
        Staff staffToBook = staffService.getStaffById(new Random().nextInt(3) + 1);
        Ticket ticketToBook = ticketService.getTicketById(new Random().nextInt(31) + 1);
        Booking newBooking = new Booking(LocalDateTime.now(), eventToBook, audience, staffToBook, ticketToBook);
        // sets a new booking and adds it to the database
        bookingService.setBooking(newBooking);
        LOGGER.info("Booking successful!");
        return true;
    }
}
