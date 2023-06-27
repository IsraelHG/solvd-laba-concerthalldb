package com.solvd.laba.database.runners;

import com.solvd.laba.database.enums.Gender;
import com.solvd.laba.database.facade.ConcertHallRegistration;
import com.solvd.laba.database.model.Audience;
import com.solvd.laba.database.model.Booking;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainRunner {
    public static final Logger LOGGER = LogManager.getLogger(ConcertHallRegistration.class.getName());

    //    ConcertHallFacade userAccount = new ConcertHallFacade("mybatis");
//    Audience person1 = userAccount.register("firstName", "lastName", "age", "gender", "email");
//    userAccount.book("event1", person1);
//    userAccount.giveFeedback("event1", person1);
    public static void main(String[] args) {
        ConcertHallRegistration concertHallRegistration = new ConcertHallRegistration();

        Audience israel = concertHallRegistration.register("Israel", "Hernandez", 24, "Male", "ihernandez.laba@solvd.com");
        if (concertHallRegistration.createBookingForEvent(israel, 3)) {
            LOGGER.info("Booking successful!");
        }
        else {
            LOGGER.info("Failed to book your given event ID.");
        }
    }
}
