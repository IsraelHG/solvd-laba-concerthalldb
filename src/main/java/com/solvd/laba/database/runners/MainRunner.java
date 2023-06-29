package com.solvd.laba.database.runners;

import com.solvd.laba.database.facade.ConcertHallAccount;
import com.solvd.laba.database.model.Audience;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class MainRunner {
    public static final Logger LOGGER = LogManager.getLogger(MainRunner.class.getName());
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ConcertHallAccount myAccount = new ConcertHallAccount();

        LOGGER.info("Welcome to the Concert Hall!");

        // Prompt user to login or register
        int choice = promptLoginOrRegister();

        // Perform login or registration based on user's choice
        Audience audience = null;
        if (choice == 1) {
            audience = myAccount.login();
        } else if (choice == 2) {
            audience = myAccount.register();
        }

        if (audience != null) {
            // Successful login or registration
            LOGGER.info("Welcome, " + audience.getFirstName() + "!");

            // Allow user to book an event
            boolean bookingSuccessful = promptBooking(myAccount, audience);
            if (bookingSuccessful) {
                LOGGER.info("Thank you for booking the event!");
            }
        } else {
            LOGGER.info("Login or registration failed. Exiting the program.");
        }
    }

    private static int promptLoginOrRegister() {
        String input;
        do {
            LOGGER.info("Please choose an option:");
            LOGGER.info("1. Login");
            LOGGER.info("2. Register");

            input = scanner.nextLine().trim().toLowerCase();
        } while (!input.matches("^(login|register|[12])$"));

        if (input.equals("login") || input.equals("1")) {
            return 1;
        } else {
            return 2;
        }
    }

    private static boolean promptBooking(ConcertHallAccount account, Audience audience) {
        LOGGER.info("Please enter the ID of the event you want to book:");
        int eventId = scanner.nextInt();
        scanner.nextLine(); // Consume the remaining newline character

        return account.createBookingForEvent(audience, eventId);
    }
}
