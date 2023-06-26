package com.solvd.laba.database.runners;

import com.solvd.laba.database.factory.ServiceFactory;
import com.solvd.laba.database.interfaces.*;
import com.solvd.laba.database.model.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FactoryRunner {
    public static final Logger LOGGER = LogManager.getLogger(FactoryRunner.class.getName());

    public static void main(String[] args) {
        IArtistService artistService = ServiceFactory.createArtistService("dao");
//        IAudienceService audienceService = ServiceFactory.createAudienceService("mybatis");
//        IEquipmentService equipmentService = ServiceFactory.createEquipmentService("MYBATIS");
//        IEventService eventService = ServiceFactory.createEventService("dao");
//        IFeedbackService feedbackService = ServiceFactory.createFeedbackService("mybatis");
//        ISponsorService sponsorService = ServiceFactory.createSponsorService("mybatis");
//        IStaffService staffService = ServiceFactory.createStaffService("mybatis");
//        ITicketService ticketService = ServiceFactory.createTicketService("mybatis");
//        IVenueService venueService = ServiceFactory.createVenueService("mybatis");

        assert artistService != null;
//        assert audienceService != null;
//        assert  equipmentService != null;
//        assert eventService != null;
//        assert feedbackService != null;
//        assert sponsorService != null;
//        assert staffService != null;
//        assert  ticketService != null;
//        assert venueService != null;

        // get - WORKS
        Artist artist = artistService.getArtistById(1);
        LOGGER.info(artist);
//        Audience audience = audienceService.getAudienceById(1);
//        LOGGER.info(audience);
//        Equipment equipment = equipmentService.getEquipmentById(1);
//        LOGGER.info(equipment);
//        Event event = eventService.getEventById(1);
//        LOGGER.info(event);
//        Feedback feedback = feedbackService.getFeedbackById(1);
//        LOGGER.info(feedback);
//        Sponsor sponsor = sponsorService.getSponsorById(1);
//        LOGGER.info(sponsor);
//        Staff staff = staffService.getStaffById(1);
//        LOGGER.info(staff);
//        Ticket ticket = ticketService.getTicketById(1);
//        LOGGER.info(ticket);
//        Venue venue = venueService.getVenueById(1);
//        LOGGER.info(venue);

        //get all - WORKS
//        ArrayList<Artist> artists = artistService.getArtists();
//        artists.forEach(LOGGER::info);
//        ArrayList<Audience> audiences = audienceService.getAudiences();
//        audiences.forEach(LOGGER::info);
//        ArrayList<Equipment> equipments = equipmentService.getEquipments();
//        equipments.forEach(LOGGER::info);
//        ArrayList<Event> events = eventService.getEvents();
//        events.forEach(LOGGER::info);
//        ArrayList<Feedback> feedbacks = feedbackService.getFeedbacks();
//        feedbacks.forEach(LOGGER::info);
//        ArrayList<Sponsor> sponsors = sponsorService.getSponsors();
//        sponsors.forEach(LOGGER::info);
//        ArrayList<Staff> staffs = staffService.getStaffs();
//        staffs.forEach(LOGGER::info);
//        ArrayList<Ticket> tickets = ticketService.getTickets();
//        tickets.forEach(LOGGER::info);
//        ArrayList<Venue> venues = venueService.getVenues();
//        venues.forEach(LOGGER::info);

        //insert - WORKS
//        Artist artistToInsert = new Artist(100, "New", "Artist", "DAO", "new.DAO.artist@gmail.com");
//        artistService.setArtist(artistToInsert);
//        Audience audienceToInsert = new Audience(2, "DAO", "DAO", 32, Gender.MALE, "new.audience.DAO@gmail.com");
//        audienceService.setAudience(audienceToInsert);
//        Equipment equipmentToInsert = new Equipment(100, "MyBatis", 99);
//        equipmentService.setEquipment(equipmentToInsert);
//        Event eventToInsert = new Event(2, "DAO", LocalDateTime.now(), LocalDateTime.now().plusHours(2));
//        eventService.setEvent(eventToInsert);
//        Feedback feedbackToInsert = new Feedback(100, eventToInsert, audienceToInsert, 5);
//        feedbackService.setFeedback(feedbackToInsert);
//        Sponsor sponsorToInsert = new Sponsor(100, "MyBatis", 9999.99);
//        sponsorService.setSponsor(sponsorToInsert);
//        Staff staffToInsert = new Staff(100, "New", "Staff", "MyBatis");
//        staffService.setStaff(staffToInsert);
//        Ticket ticketToInsert = new Ticket(100, "4321");
//        ticketService.setTicket(ticketToInsert);
//        Venue venueToInsert = new Venue(100, "New Venue", "MyBatis", "MyBatis", 1000, "new.venue.mybatis@gmail.com");
//        venueService.setVenue(venueToInsert);

        //update - WORKS
//        Artist artistFromDbToUpdate = artistService.getArtistById(12);
//        artistFromDbToUpdate.setGenre("UpdatedMyBatis");
//        artistService.updateArtist(artistFromDbToUpdate);
//        Audience audienceFromDbToUpdate = audienceService.getAudienceById(7);
//        audienceFromDbToUpdate.setLastName("UpdatedDAO");
//        audienceService.updateAudience(audienceFromDbToUpdate);
//        Equipment equipmentFromDbToUpdate = equipmentService.getEquipmentById(6);
//        equipmentFromDbToUpdate.setName("MyBatisUpdated");
//        equipmentService.updateEquipment(equipmentFromDbToUpdate);
//        Event eventFromDbToUpdate = eventService.getEventById(100);
//        eventFromDbToUpdate.setName("MyBatisUpdated");
//        eventService.updateEvent(eventFromDbToUpdate);
//        Feedback feedbackFromDbToUpdate = feedbackService.getFeedbackById(4);
//        feedbackFromDbToUpdate.setRating(200);
//        feedbackService.updateFeedback(feedbackFromDbToUpdate);
//        Sponsor sponsorFromDbToUpdate = sponsorService.getSponsorById(6);
//        sponsorFromDbToUpdate.setName("MyBatisUpdated");
//        sponsorService.updateSponsor(sponsorFromDbToUpdate);
//        Staff staffFromDbToUpdate = staffService.getStaffById(6);
//        staffFromDbToUpdate.setRole("UpdatedMyBatis");
//        staffService.updateStaff(staffFromDbToUpdate);
//        Ticket ticketFromDbToUpdate = ticketService.getTicketById(8);
//        ticketFromDbToUpdate.setSeatNumber("7654");
//        ticketService.updateTicket(ticketFromDbToUpdate);
//        Venue venueFromDbToUpdate = venueService.getVenueById(7);
//        venueFromDbToUpdate.setCity("UpdatedMyBatis");
//        venueService.updateVenue(venueFromDbToUpdate);


        //delete - WORKS
//        Artist artistFromDbToDelete = artistService.getArtistById(11);
//        artistService.deleteArtist(artistFromDbToDelete);
//        Audience audienceFromDbToDelete = audienceService.getAudienceById(6);
//        audienceService.deleteAudience(audienceFromDbToDelete);
//        Equipment equipmentFromDbToDelete = equipmentService.getEquipmentById(6);
//        equipmentService.deleteEquipment(equipmentFromDbToDelete);
//        Event eventFromDbToDelete = eventService.getEventById(102);
//        eventService.deleteEvent(eventFromDbToDelete);
//        Feedback feedbackFromDbToDelete = feedbackService.getFeedbackById(4);
//        feedbackService.deleteFeedback(feedbackFromDbToDelete);
//        Sponsor sponsorFromDbToDelete = sponsorService.getSponsorById(6);
//        sponsorService.deleteSponsor(sponsorFromDbToDelete);
//        Staff staffFromDbToDelete = staffService.getStaffById(6);
//        staffService.deleteStaff(staffFromDbToDelete);
//        Ticket ticketFromDbToDelete = ticketService.getTicketById(8);
//        ticketService.deleteTicket(ticketFromDbToDelete);
//        Venue venueFromDbToDelete = venueService.getVenueById(7);
//        venueService.deleteVenue(venueFromDbToDelete);
    }

}
