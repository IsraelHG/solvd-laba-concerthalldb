package com.solvd.laba.database.factory;

import com.solvd.laba.database.interfaces.*;
import com.solvd.laba.database.service.*;

public class ServiceFactory {
    public static IArtistService createArtistService(String type) {
        switch (type.toLowerCase()) {
            case "dao" -> {
                return new ArtistService();
            }
            case "mybatis" -> {
                return new ArtistServiceMyBatis();
            }
            default -> {
                return null;
            }
        }
    }

    public static IAudienceService createAudienceService(String type) {
        switch (type.toLowerCase()) {
            case "dao" -> {
                return new AudienceService();
            }
            case "mybatis" -> {
                return new AudienceServiceMyBatis();
            }
            default -> {
                return null;
            }
        }
    }

    public static IBookingService createBookingService(String type) {
        switch (type.toLowerCase()) {
            case "dao" -> {
                return new BookingService();
            }
            case "mybatis" -> {
                return new BookingServiceMyBatis();
            }
            default -> {
                return null;
            }
        }
    }

    public static IEquipmentService createEquipmentService(String type) {
        switch (type.toLowerCase()) {
            case "dao" -> {
                return new EquipmentService();
            }
            case "mybatis" -> {
                return new EquipmentServiceMyBatis();
            }
            default -> {
                return null;
            }
        }
    }

    public static IEventService createEventService(String type) {
        switch (type.toLowerCase()) {
            case "dao" -> {
                return new EventService();
            }
            case "mybatis" -> {
                return new EventServiceMyBatis();
            }
            default -> {
                return null;
            }
        }
    }

    public static IFeedbackService createFeedbackService(String type) {
        switch (type.toLowerCase()) {
            case "dao" -> {
                return new FeedbackService();
            }
            case "mybatis" -> {
                return new FeedbackServiceMyBatis();
            }
            default -> {
                return null;
            }
        }
    }

    public static ISponsorService createSponsorService(String type) {
        switch (type.toLowerCase()) {
            case "dao" -> {
                return new SponsorService();
            }
            case "mybatis" -> {
                return new SponsorServiceMyBatis();
            }
            default -> {
                return null;
            }
        }
    }

    public static IStaffService createStaffService(String type) {
        switch (type.toLowerCase()) {
            case "dao" -> {
                return new StaffService();
            }
            case "mybatis" -> {
                return new StaffServiceMyBatis();
            }
            default -> {
                return null;
            }
        }
    }

    public static ITicketService createTicketService(String type) {
        switch (type.toLowerCase()) {
            case "dao" -> {
                return new TicketService();
            }
            case "mybatis" -> {
                return new TicketServiceMyBatis();
            }
            default -> {
                return null;
            }
        }
    }

    public static IVenueService createVenueService(String type) {
        switch (type.toLowerCase()) {
            case "dao" -> {
                return new VenueService();
            }
            case "mybatis" -> {
                return new VenueServiceMyBatis();
            }
            default -> {
                return null;
            }
        }
    }

}
