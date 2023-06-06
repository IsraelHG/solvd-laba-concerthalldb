-- Alter table statements
ALTER TABLE `concerthalldb`.`venues` ADD COLUMN `website` VARCHAR(100);
ALTER TABLE `concerthalldb`.`artists`  ADD COLUMN `last_name` VARCHAR(100) NOT NULL AFTER `name`,  ADD COLUMN `email` VARCHAR(100) AFTER `genre`;
ALTER TABLE `concerthalldb`.`artists` CHANGE COLUMN `name` `first_name` VARCHAR(100) NOT NULL;
ALTER TABLE `concerthalldb`.`audiences` ADD COLUMN `last_name` VARCHAR(100) NOT NULL AFTER `name`;
ALTER TABLE `concerthalldb`.`audiences` CHANGE COLUMN `name` `first_name` VARCHAR(100) NOT NULL;
ALTER TABLE `concerthalldb`.`staffs` ADD COLUMN `last_name` VARCHAR(100) NOT NULL AFTER `name`; 
ALTER TABLE `concerthalldb`.`staffs` CHANGE COLUMN `name` `first_name` VARCHAR(100) NOT NULL; 
ALTER TABLE `concerthalldb`.`sponsors` ADD COLUMN `sponsorship_amount` DECIMAL(10, 2) AFTER `name`;
ALTER TABLE `concerthalldb`.`audiences` ADD COLUMN `email` VARCHAR(100) NULL AFTER `gender`;

-- Insertion statements
INSERT INTO `concerthalldb`.`audiences` (`first_name`, `last_name`, `age`, `gender`) VALUES ('John', 'Smith', '35', 'Male');
INSERT INTO `concerthalldb`.`audiences` (`first_name`, `last_name`, `age`, `gender`) VALUES ('Emily', 'Johnson', '28', 'Female');
INSERT INTO `concerthalldb`.`audiences` (`first_name`, `last_name`, `age`, `gender`) VALUES ('Michael', 'Davis', '42', 'Male');
INSERT INTO `concerthalldb`.`audiences` (`first_name`, `last_name`, `age`, `gender`) VALUES ('Sophia', 'Wilson', '30', 'Female');
INSERT INTO `concerthalldb`.`audiences` (`first_name`, `last_name`, `age`, `gender`) VALUES ('David', 'Thompson', '55', 'Male');
INSERT INTO `concerthalldb`.`events` (`name`, `start_date`, `end_date`) VALUES ('Event 1', '2023-05-26 10:00:00', '2023-05-26 12:00:00');
INSERT INTO `concerthalldb`.`events` (`name`, `start_date`, `end_date`) VALUES ('Event 2', '2023-05-27 15:00:00', '2023-05-27 17:00:00');
INSERT INTO `concerthalldb`.`events` (`name`, `start_date`, `end_date`) VALUES ('Event 3', '2023-05-21 12:00:00', '2023-05-21 14:00:00');
INSERT INTO `concerthalldb`.`events` (`name`, `start_date`, `end_date`) VALUES ('Event 4', '2023-05-19 18:00:00', '2023-05-19 20:00:00');
INSERT INTO `concerthalldb`.`events` (`name`, `start_date`, `end_date`) VALUES ('Event 5', '2023-06-02 12:00:00', '2023-06-02 14:00:00');
INSERT INTO `concerthalldb`.`venues` (`name`, `city`, `state`, `capacity`) VALUES ('Hollywood Bowl', 'Los Angeles', 'California', '17500');
INSERT INTO `concerthalldb`.`venues` (`name`, `city`, `state`, `capacity`) VALUES ('Red Rocks Amphitheatre', 'Morrison', 'Colorado', '9525');
INSERT INTO `concerthalldb`.`venues` (`name`, `city`, `state`, `capacity`) VALUES ('Radio City Music Hall', 'New York', 'New York', '9560');
INSERT INTO `concerthalldb`.`venues` (`name`, `city`, `state`, `capacity`, `website`) VALUES ('Tabernacle', 'Atlanta', 'Georgia', '2600', 'https://www.tabernacleatl.com/');
INSERT INTO `concerthalldb`.`artists` (`first_name`, `last_name`, `genre`, `email`) VALUES ('Freddy', 'Mercury', 'Rock', 'freddy.mercury@gmail.com');
INSERT INTO `concerthalldb`.`artists` (`first_name`, `last_name`, `genre`, `email`) VALUES ('Beyonce', 'Knowles', 'Pop', 'beyonce.knowles@gmail.com');
INSERT INTO `concerthalldb`.`artists` (`first_name`, `last_name`, `genre`, `email`) VALUES ('Stevie', 'Wonder', 'R&B', 'stevie.wonder@gmail.com');
INSERT INTO `concerthalldb`.`artists` (`first_name`, `last_name`, `genre`, `email`) VALUES ('Taylor', 'Swift', 'Country', 'taylor.swift@gmail.com');
INSERT INTO `concerthalldb`.`artists` (`first_name`, `last_name`, `genre`, `email`) VALUES ('Kendrick', 'Lamar', 'Hip-Hop', 'kendrick.lamar@gmail.com');
INSERT INTO `concerthalldb`.`artists` (`first_name`, `last_name`, `genre`, `email`) VALUES ('Kurt', 'Cobain', 'Rock', 'kurt.cobain@gmail.com');
INSERT INTO `concerthalldb`.`artists` (`first_name`, `last_name`, `genre`, `email`) VALUES ('Doja', 'Cat', 'Pop', 'doja.cat@gmail.com');
INSERT INTO `concerthalldb`.`artists` (`first_name`, `last_name`, `genre`, `email`) VALUES ('Daft', 'Punk', 'Electronic', 'daft.punk@gmail.com');
INSERT INTO `concerthalldb`.`artists` (`first_name`, `last_name`, `genre`, `email`) VALUES ('Bob', 'Marley', 'Reggae', 'bob.marley@gmail.com');
INSERT INTO `concerthalldb`.`tickets` (`seat_number`) VALUES ('100');
INSERT INTO `concerthalldb`.`tickets` (`seat_number`) VALUES ('200');
INSERT INTO `concerthalldb`.`tickets` (`seat_number`) VALUES ('300');
INSERT INTO `concerthalldb`.`tickets` (`seat_number`) VALUES ('400');
INSERT INTO `concerthalldb`.`tickets` (`seat_number`) VALUES ('500');
INSERT INTO `concerthalldb`.`staffs` (`first_name`, `last_name`, `role`) VALUES ('Sophia', 'Robinson', 'Manager');
INSERT INTO `concerthalldb`.`staffs` (`first_name`, `last_name`, `role`) VALUES ('Erick', 'Rodriguez', 'Event Coordinator');
INSERT INTO `concerthalldb`.`staffs` (`first_name`, `last_name`, `role`) VALUES ('Joshua', 'Martin', 'Event Coordinator');
INSERT INTO `concerthalldb`.`staffs` (`first_name`, `last_name`, `role`) VALUES ('Matthew', 'Brown', 'Technical Staff');
INSERT INTO `concerthalldb`.`events_has_venues` (`event_id`, `venue_id`) VALUES ('1', '1');
INSERT INTO `concerthalldb`.`events_has_venues` (`event_id`, `venue_id`) VALUES ('2', '2');
INSERT INTO `concerthalldb`.`events_has_venues` (`event_id`, `venue_id`) VALUES ('3', '3');
INSERT INTO `concerthalldb`.`events_has_venues` (`event_id`, `venue_id`) VALUES ('4', '4');
INSERT INTO `concerthalldb`.`events_has_venues` (`event_id`, `venue_id`) VALUES ('1', '4');
INSERT INTO `concerthalldb`.`events_has_artists` (`event_id`, `artist_id`) VALUES ('1', '1');
INSERT INTO `concerthalldb`.`events_has_artists` (`event_id`, `artist_id`) VALUES ('2', '2');
INSERT INTO `concerthalldb`.`events_has_artists` (`event_id`, `artist_id`) VALUES ('3', '3');
INSERT INTO `concerthalldb`.`events_has_artists` (`event_id`, `artist_id`) VALUES ('4', '4');
INSERT INTO `concerthalldb`.`events_has_artists` (`event_id`, `artist_id`) VALUES ('5', '5');
INSERT INTO `concerthalldb`.`bookings` (`event_id`, `audience_id`, `staff_id`, `booking_date`, `ticket_id`) VALUES ('1', '2', '1', '2023-05-26 10:00:00', '1');
INSERT INTO `concerthalldb`.`bookings` (`event_id`, `audience_id`, `staff_id`, `booking_date`, `ticket_id`) VALUES ('2', '3', '2', '2023-05-27 15:00:00', '2');
INSERT INTO `concerthalldb`.`bookings` (`event_id`, `audience_id`, `staff_id`, `booking_date`, `ticket_id`) VALUES ('3', '1', '3', '2023-05-21 12:00:00', '3');
INSERT INTO `concerthalldb`.`sponsors` (`name`, `sponsorship_amount`)
VALUES ('Company A', 5000.00),
       ('Company B', 7500.00),
       ('Company C', 10000.00);
INSERT INTO `concerthalldb`.`events_has_sponsors` (`event_id`, `sponsor_id`)
VALUES (1, 1),
       (2, 2),
       (3, 3);
INSERT INTO `concerthalldb`.`equipments` (`name`, `quantity`)
VALUES ('Microphone', 10),
       ('Guitar', 5),
       ('Drums', 3);
INSERT INTO `concerthalldb`.`events_has_equipments` (`event_id`, `equipment_id`)
VALUES (1, 1),
       (2, 2),
       (3, 3);
INSERT INTO `concerthallDB`.`Feedbacks` (`event_id`, `audience_id`, `rating`)
VALUES (1, 1, 5),
       (2, 2, 4),
       (3, 3, 3);

-- Update statements
UPDATE `concerthalldb`.`venues` SET `website` = 'https://www.hollywoodbowl.com' WHERE (`venue_id` = '1');
UPDATE `concerthalldb`.`venues` SET `website` = 'https://www.redrocksonline.com' WHERE (`venue_id` = '2');
UPDATE `concerthalldb`.`venues` SET `website` = 'https://www.msg.com/radio-city-music-hall' WHERE (`venue_id` = '3');
UPDATE `concerthalldb`.`audiences` SET `email` = 'john.smith@gmail.com' WHERE (`audience_id` = '1');
UPDATE `concerthalldb`.`audiences` SET `email` = 'emily.johnson@gmail.com' WHERE (`audience_id` = '2');
UPDATE `concerthalldb`.`audiences` SET `email` = 'michael.davis@gmail.com' WHERE (`audience_id` = '3');
UPDATE `concerthalldb`.`audiences` SET `email` = 'sophia.wilson@gmail.com' WHERE (`audience_id` = '4');
UPDATE `concerthalldb`.`audiences` SET `email` = 'david.thompson@gmail.com' WHERE (`audience_id` = '5');
UPDATE `concerthalldb`.`events` SET `start_date` = '2023-05-19 19:30:00', `end_date` = '2023-05-19 21:30:00' WHERE (`event_id` = '4');

-- deletion statements
DELETE FROM `concerthalldb`.`audiences` WHERE (`audience_id` = '5');
DELETE FROM `concerthalldb`.`audiences` WHERE (`audience_id` = '4');
DELETE FROM `concerthalldb`.`artists` WHERE (`artist_id` = '9');
DELETE FROM `concerthalldb`.`artists` WHERE (`artist_id` = '8');
DELETE FROM `concerthalldb`.`staffs` WHERE (`staff_id` = '4');
DELETE FROM `concerthalldb`.`events_has_venues` WHERE (`Events_has_Venue_id` = '4') and (`event_id` = '4') and (`venue_id` = '4');

-- Big statement to join all tables
SELECT *
FROM Venues v
JOIN Events_has_Venues ev ON v.venue_id = ev.venue_id
JOIN Events e ON e.event_id = ev.event_id
JOIN Events_Has_Artists ea ON e.event_id = ea.event_id
JOIN Artists a ON a.artist_id = ea.artist_id
JOIN Bookings b ON b.event_id = e.event_id
JOIN Audiences au ON au.audience_id = b.audience_id
JOIN Staffs s ON s.staff_id = b.staff_id
JOIN Tickets t ON t.ticket_id = b.ticket_id
JOIN Events_Has_Equipments ee ON ee.event_id = e.event_id
JOIN Equipments eq ON eq.equipment_id = ee.equipment_id;

-- Left Join:
-- Retrieves data about events and their associated venues
SELECT e.name AS event_name, v.name AS venue_name
FROM Events AS e
LEFT JOIN Events_has_Venues AS ev ON e.event_id = ev.event_id
LEFT JOIN Venues AS v ON ev.venue_id = v.venue_id;

-- Right Join:
-- Retrieves data about events and their associated venues
SELECT e.name AS event_name, v.name AS venue_name
FROM Venues AS v
RIGHT JOIN Events_has_Venues AS ev ON v.venue_id = ev.venue_id
RIGHT JOIN Events AS e ON ev.event_id = e.event_id;

-- Inner Join:
-- Retrieves data about events and their associated artists
SELECT e.name AS event_name, a.first_name AS artist_name
FROM Events AS e
INNER JOIN Events_Has_Artists AS ea ON e.event_id = ea.event_id
INNER JOIN Artists AS a ON ea.artist_id = a.artist_id;

-- Outer Join (combination of Left and Right Joins):
-- Retrieves data about events and their sponsors
SELECT e.name AS event_name, s.name AS sponsor_name
FROM Events AS e
LEFT JOIN Events_Has_Sponsors AS es ON e.event_id = es.event_id
LEFT JOIN Sponsors AS s ON es.sponsor_id = s.sponsor_id
UNION
SELECT e.name AS event_name, s.name AS sponsor_name
FROM Events AS e
RIGHT JOIN Events_Has_Sponsors AS es ON e.event_id = es.event_id
RIGHT JOIN Sponsors AS s ON es.sponsor_id = s.sponsor_id;

-- Cross Join:
SELECT a.first_name AS artist_name, g.name AS genre_name
FROM Artists AS a
CROSS JOIN (SELECT DISTINCT genre AS name FROM Artists) AS g;

-- 7 statements with aggregate functions and group by, without having
-- Retrieve the total number of events held at each venue
SELECT COUNT(*) AS total_events, v.name AS venue_name
FROM Events_has_Venues AS ev
JOIN Venues AS v ON ev.venue_id = v.venue_id
GROUP BY v.name;

-- Retrieve the average rating for each event based on the feedback provided by the attendees
SELECT AVG(rating) AS average_rating, e.name AS event_name
FROM Feedbacks AS f
JOIN Events AS e ON f.event_id = e.event_id
GROUP BY e.name;

-- Calculate the total quantity of equipment used in each event
SELECT SUM(e.quantity) AS total_equipments, ev.name AS event_name
FROM Events_Has_Equipments AS ee
JOIN Events AS ev ON ee.event_id = ev.event_id
JOIN Equipments AS e ON ee.equipment_id = e.equipment_id
GROUP BY ev.name;

-- Finds the youngest audience member for each event
SELECT MIN(age) AS youngest_audience, e.name AS event_name
FROM Bookings AS b
JOIN Events AS e ON b.event_id = e.event_id
JOIN Audiences AS a ON b.audience_id = a.audience_id
GROUP BY e.name;

--  Finds the maximum capacity of each venue used for an event
SELECT MAX(capacity) AS max_capacity, e.name AS event_name
FROM Events_has_Venues AS ev
JOIN Events AS e ON ev.event_id = e.event_id
JOIN Venues AS v ON ev.venue_id = v.venue_id
GROUP BY e.name;

-- Total number of bookings for each artist in the Concerts table
SELECT COUNT(*) AS total_bookings, a.first_name AS artist_first_name, a.last_name AS artist_last_name
FROM Events_Has_Artists AS ea
JOIN Events AS e ON ea.event_id = e.event_id
JOIN Artists AS a ON ea.artist_id = a.artist_id
GROUP BY a.first_name, a.last_name;

-- Counts the number of sponsors for each event
SELECT COUNT(*) AS total_sponsors, e.name AS event_name
FROM Events_Has_Sponsors AS es
JOIN Events AS e ON es.event_id = e.event_id
GROUP BY e.name;

-- 7 statements with aggregate functions and group by, with having:
-- Get the average age of audiences who attended events in the month of January 2023
SELECT AVG(age) AS avg_age
FROM Bookings b
JOIN Audiences a ON b.audience_id = a.audience_id
JOIN Events e ON b.event_id = e.event_id
WHERE MONTH(start_date) = 5 AND YEAR(start_date) = 2023
GROUP BY e.event_id;

-- Get the total number of tickets sold for each event in the database
SELECT e.name, COUNT(*) AS total_tickets_sold
FROM Bookings b
JOIN Events e ON b.event_id = e.event_id
GROUP BY e.event_id;

-- Get the average rating for each event that has at least 1 feedback
SELECT e.name, AVG(f.rating) AS avg_rating
FROM Feedbacks f
JOIN Events e ON f.event_id = e.event_id
GROUP BY e.event_id
HAVING COUNT(*) >= 1;

-- Get the total number of bookings made by each staff member
SELECT s.first_name, COUNT(*) AS total_bookings
FROM Bookings b
JOIN Staffs s ON b.staff_id = s.staff_id
GROUP BY s.staff_id;

-- Get the total quantity of each equipment used in all events
SELECT eq.name, SUM(eq.quantity) AS total_quantity_used
FROM Events_Has_Equipments ee
JOIN Equipments eq ON ee.equipment_id = eq.equipment_id
GROUP BY eq.equipment_id;

-- Get the total number of concerts each artist has performed
SELECT a.first_name, COUNT(*) AS total_concerts
FROM Events_Has_Artists ea
JOIN Artists a ON ea.artist_id = a.artist_id
GROUP BY a.artist_id;

-- Get the total revenue generated by each event, assuming each ticket costs $50
SELECT e.name, COUNT(*) * 50 AS total_revenue
FROM Bookings b
JOIN Events e ON b.event_id = e.event_id
GROUP BY e.event_id;