-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema israel_concerthalldb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `israel_concerthalldb` DEFAULT CHARACTER SET utf8 ;
USE `israel_concerthalldb` ;

-- -----------------------------------------------------
-- Table `israel_concerthalldb`.`artists`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `israel_concerthalldb`.`artists` (
  `artist_id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(100) NOT NULL,
  `last_name` VARCHAR(100) NOT NULL,
  `genre` VARCHAR(45) NOT NULL,
  `email` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`artist_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `israel_concerthalldb`.`audiences`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `israel_concerthalldb`.`audiences` (
  `audience_id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(100) NOT NULL,
  `last_name` VARCHAR(100) NOT NULL,
  `age` INT NOT NULL,
  `gender` ENUM('Male', 'Female', 'Other') NOT NULL,
  `email` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`audience_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `israel_concerthalldb`.`events`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `israel_concerthalldb`.`events` (
  `event_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `start_date` DATETIME NOT NULL,
  `end_date` DATETIME NOT NULL,
  PRIMARY KEY (`event_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `israel_concerthalldb`.`staffs`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `israel_concerthalldb`.`staffs` (
  `staff_id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(100) NOT NULL,
  `last_name` VARCHAR(100) NOT NULL,
  `role` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`staff_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `israel_concerthalldb`.`tickets`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `israel_concerthalldb`.`tickets` (
  `ticket_id` INT NOT NULL AUTO_INCREMENT,
  `seat_number` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`ticket_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `israel_concerthalldb`.`bookings`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `israel_concerthalldb`.`bookings` (
  `booking_id` INT NOT NULL AUTO_INCREMENT,
  `event_id` INT NOT NULL,
  `audience_id` INT NOT NULL,
  `staff_id` INT NOT NULL,
  `booking_date` DATETIME NOT NULL,
  `ticket_id` INT NOT NULL,
  PRIMARY KEY (`booking_id`),
  INDEX `fk_Bookings_Tickets1_idx` (`ticket_id` ASC),
  INDEX `fk_Bookings_Staffs1_idx` (`staff_id` ASC),
  INDEX `fk_Bookings_Audiences1_idx` (`audience_id` ASC),
  INDEX `fk_Bookings_Events1_idx` (`event_id` ASC),
  CONSTRAINT `fk_Bookings_Audiences1`
    FOREIGN KEY (`audience_id`)
    REFERENCES `israel_concerthalldb`.`audiences` (`audience_id`),
  CONSTRAINT `fk_Bookings_Events1`
    FOREIGN KEY (`event_id`)
    REFERENCES `israel_concerthalldb`.`events` (`event_id`),
  CONSTRAINT `fk_Bookings_Staffs1`
    FOREIGN KEY (`staff_id`)
    REFERENCES `israel_concerthalldb`.`staffs` (`staff_id`),
  CONSTRAINT `fk_Bookings_Tickets1`
    FOREIGN KEY (`ticket_id`)
    REFERENCES `israel_concerthalldb`.`tickets` (`ticket_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `israel_concerthalldb`.`equipments`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `israel_concerthalldb`.`equipments` (
  `equipment_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `quantity` INT NOT NULL,
  PRIMARY KEY (`equipment_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `israel_concerthalldb`.`events_has_artists`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `israel_concerthalldb`.`events_has_artists` (
  `events_has_artists_id` INT NOT NULL AUTO_INCREMENT,
  `event_id` INT NOT NULL,
  `artist_id` INT NOT NULL,
  PRIMARY KEY (`events_has_artists_id`, `event_id`, `artist_id`),
  INDEX `fk_Events_has_Artists_Artists1_idx` (`artist_id` ASC),
  INDEX `fk_Events_has_Artists_Events1_idx` (`event_id` ASC),
  CONSTRAINT `fk_Events_has_Artists_Artists1`
    FOREIGN KEY (`artist_id`)
    REFERENCES `israel_concerthalldb`.`artists` (`artist_id`),
  CONSTRAINT `fk_Events_has_Artists_Events1`
    FOREIGN KEY (`event_id`)
    REFERENCES `israel_concerthalldb`.`events` (`event_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `israel_concerthalldb`.`events_has_equipments`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `israel_concerthalldb`.`events_has_equipments` (
  `events_has_equipments_id` INT NOT NULL AUTO_INCREMENT,
  `event_id` INT NOT NULL,
  `equipment_id` INT NOT NULL,
  PRIMARY KEY (`events_has_equipments_id`, `event_id`, `equipment_id`),
  INDEX `fk_Events_has_Equipments_Equipments1_idx` (`equipment_id` ASC),
  INDEX `fk_Events_has_Equipments_Events1_idx` (`event_id` ASC),
  CONSTRAINT `fk_Events_has_Equipments_Equipments1`
    FOREIGN KEY (`equipment_id`)
    REFERENCES `israel_concerthalldb`.`equipments` (`equipment_id`),
  CONSTRAINT `fk_Events_has_Equipments_Events1`
    FOREIGN KEY (`event_id`)
    REFERENCES `israel_concerthalldb`.`events` (`event_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `israel_concerthalldb`.`sponsors`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `israel_concerthalldb`.`sponsors` (
  `sponsor_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `sponsorship_amount` DECIMAL(10,2) NULL DEFAULT NULL,
  PRIMARY KEY (`sponsor_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `israel_concerthalldb`.`events_has_sponsors`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `israel_concerthalldb`.`events_has_sponsors` (
  `events_has_sponsors_id` INT NOT NULL AUTO_INCREMENT,
  `event_id` INT NOT NULL,
  `sponsor_id` INT NOT NULL,
  PRIMARY KEY (`events_has_sponsors_id`, `event_id`, `sponsor_id`),
  INDEX `fk_Events_has_Sponsors_Sponsors1_idx` (`sponsor_id` ASC),
  INDEX `fk_Events_has_Sponsors_Events1_idx` (`event_id` ASC),
  CONSTRAINT `fk_Events_has_Sponsors_Events1`
    FOREIGN KEY (`event_id`)
    REFERENCES `israel_concerthalldb`.`events` (`event_id`),
  CONSTRAINT `fk_Events_has_Sponsors_Sponsors1`
    FOREIGN KEY (`sponsor_id`)
    REFERENCES `israel_concerthalldb`.`sponsors` (`sponsor_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `israel_concerthalldb`.`venues`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `israel_concerthalldb`.`venues` (
  `venue_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `city` VARCHAR(45) NOT NULL,
  `state` VARCHAR(45) NOT NULL,
  `capacity` INT NOT NULL,
  `website` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`venue_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `israel_concerthalldb`.`events_has_venues`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `israel_concerthalldb`.`events_has_venues` (
  `Events_has_Venue_id` INT NOT NULL AUTO_INCREMENT,
  `event_id` INT NOT NULL,
  `venue_id` INT NOT NULL,
  PRIMARY KEY (`Events_has_Venue_id`, `event_id`, `venue_id`),
  INDEX `fk_Events_has_Venues_Venues1_idx` (`venue_id` ASC),
  INDEX `fk_Events_has_Venues_Events1_idx` (`event_id` ASC),
  CONSTRAINT `fk_Events_has_Venues_Events1`
    FOREIGN KEY (`event_id`)
    REFERENCES `israel_concerthalldb`.`events` (`event_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Events_has_Venues_Venues1`
    FOREIGN KEY (`venue_id`)
    REFERENCES `israel_concerthalldb`.`venues` (`venue_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `israel_concerthalldb`.`feedbacks`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `israel_concerthalldb`.`feedbacks` (
  `feedback_id` INT NOT NULL AUTO_INCREMENT,
  `event_id` INT NOT NULL,
  `audience_id` INT NOT NULL,
  `rating` INT NOT NULL,
  PRIMARY KEY (`feedback_id`),
  INDEX `fk_Feedbacks_Audiences1_idx` (`audience_id` ASC),
  INDEX `fk_Feedbacks_Events1_idx` (`event_id` ASC),
  CONSTRAINT `fk_Feedbacks_Audiences1`
    FOREIGN KEY (`audience_id`)
    REFERENCES `israel_concerthalldb`.`audiences` (`audience_id`),
  CONSTRAINT `fk_Feedbacks_Events1`
    FOREIGN KEY (`event_id`)
    REFERENCES `israel_concerthalldb`.`events` (`event_id`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
