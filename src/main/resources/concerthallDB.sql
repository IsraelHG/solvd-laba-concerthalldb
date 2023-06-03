-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema concerthallDB
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema concerthallDB
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `concerthallDB` DEFAULT CHARACTER SET utf8 ;
USE `concerthallDB` ;

-- -----------------------------------------------------
-- Table `concerthallDB`.`Venues`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `concerthallDB`.`Venues` (
  `venue_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `city` VARCHAR(45) NOT NULL,
  `state` VARCHAR(45) NOT NULL,
  `capacity` INT NOT NULL,
  PRIMARY KEY (`venue_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `concerthallDB`.`Events`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `concerthallDB`.`Events` (
  `event_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `start_date` DATETIME NOT NULL,
  `end_date` DATETIME NOT NULL,
  PRIMARY KEY (`event_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `concerthallDB`.`Artists`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `concerthallDB`.`Artists` (
  `artist_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `genre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`artist_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `concerthallDB`.`Concerts`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `concerthallDB`.`Concerts` (
  `concert_id` INT NOT NULL AUTO_INCREMENT,
  `event_id` INT NOT NULL,
  `artist_id` INT NOT NULL,
  PRIMARY KEY (`concert_id`),
  INDEX `fk_Concert_Event1_idx` (`event_id` ASC) VISIBLE,
  INDEX `fk_Concert_Artist1_idx` (`artist_id` ASC) VISIBLE,
  CONSTRAINT `fk_Concert_Event1`
    FOREIGN KEY (`event_id`)
    REFERENCES `concerthallDB`.`Events` (`event_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Concert_Artist1`
    FOREIGN KEY (`artist_id`)
    REFERENCES `concerthallDB`.`Artists` (`artist_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `concerthallDB`.`Tickets`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `concerthallDB`.`Tickets` (
  `ticket_id` INT NOT NULL AUTO_INCREMENT,
  `seat_number` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`ticket_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `concerthallDB`.`Audiences`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `concerthallDB`.`Audiences` (
  `audience_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `age` INT NOT NULL,
  `gender` ENUM('Male', 'Female', 'Other') NOT NULL,
  PRIMARY KEY (`audience_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `concerthallDB`.`Staffs`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `concerthallDB`.`Staffs` (
  `staff_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `role` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`staff_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `concerthallDB`.`Bookings`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `concerthallDB`.`Bookings` (
  `booking_id` INT NOT NULL AUTO_INCREMENT,
  `event_id` INT NOT NULL,
  `audience_id` INT NOT NULL,
  `staff_id` INT NOT NULL,
  `booking_date` DATETIME NOT NULL,
  `ticket_id` INT NOT NULL,
  PRIMARY KEY (`booking_id`),
  INDEX `fk_Booking_Event1_idx` (`event_id` ASC) VISIBLE,
  INDEX `fk_Booking_Audience1_idx` (`audience_id` ASC) VISIBLE,
  INDEX `fk_Booking_Staff1_idx` (`staff_id` ASC) VISIBLE,
  INDEX `fk_Bookings_Tickets1_idx` (`ticket_id` ASC) VISIBLE,
  CONSTRAINT `fk_Booking_Event1`
    FOREIGN KEY (`event_id`)
    REFERENCES `concerthallDB`.`Events` (`event_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Booking_Audience1`
    FOREIGN KEY (`audience_id`)
    REFERENCES `concerthallDB`.`Audiences` (`audience_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Booking_Staff1`
    FOREIGN KEY (`staff_id`)
    REFERENCES `concerthallDB`.`Staffs` (`staff_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Bookings_Tickets1`
    FOREIGN KEY (`ticket_id`)
    REFERENCES `concerthallDB`.`Tickets` (`ticket_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `concerthallDB`.`Equipments`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `concerthallDB`.`Equipments` (
  `equipment_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `quantity` INT NOT NULL,
  PRIMARY KEY (`equipment_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `concerthallDB`.`Event_Equipments`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `concerthallDB`.`Event_Equipments` (
  `event_equipment_id` INT NOT NULL AUTO_INCREMENT,
  `event_id` INT NOT NULL,
  `equipment_id` INT NOT NULL,
  INDEX `fk_Event_Equipment_Event1_idx` (`event_id` ASC) VISIBLE,
  INDEX `fk_Event_Equipment_Equipment1_idx` (`equipment_id` ASC) VISIBLE,
  PRIMARY KEY (`event_equipment_id`, `event_id`, `equipment_id`),
  CONSTRAINT `fk_Event_Equipment_Event1`
    FOREIGN KEY (`event_id`)
    REFERENCES `concerthallDB`.`Events` (`event_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Event_Equipment_Equipment1`
    FOREIGN KEY (`equipment_id`)
    REFERENCES `concerthallDB`.`Equipments` (`equipment_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `concerthallDB`.`Sponsors`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `concerthallDB`.`Sponsors` (
  `sponsor_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`sponsor_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `concerthallDB`.`Event_Sponsors`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `concerthallDB`.`Event_Sponsors` (
  `event_sponsor_id` INT NOT NULL AUTO_INCREMENT,
  `event_id` INT NOT NULL,
  `sponsor_id` INT NOT NULL,
  INDEX `fk_Event_Sponsor_Event1_idx` (`event_id` ASC) VISIBLE,
  INDEX `fk_Event_Sponsor_Sponsor1_idx` (`sponsor_id` ASC) VISIBLE,
  PRIMARY KEY (`event_sponsor_id`, `event_id`, `sponsor_id`),
  CONSTRAINT `fk_Event_Sponsor_Event1`
    FOREIGN KEY (`event_id`)
    REFERENCES `concerthallDB`.`Events` (`event_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Event_Sponsor_Sponsor1`
    FOREIGN KEY (`sponsor_id`)
    REFERENCES `concerthallDB`.`Sponsors` (`sponsor_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `concerthallDB`.`Feedbacks`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `concerthallDB`.`Feedbacks` (
  `feedback_id` INT NOT NULL AUTO_INCREMENT,
  `event_id` INT NOT NULL,
  `audience_id` INT NOT NULL,
  `rating` INT NOT NULL,
  PRIMARY KEY (`feedback_id`),
  INDEX `fk_Feedback_Event1_idx` (`event_id` ASC) VISIBLE,
  INDEX `fk_Feedback_Audience1_idx` (`audience_id` ASC) VISIBLE,
  CONSTRAINT `fk_Feedback_Event1`
    FOREIGN KEY (`event_id`)
    REFERENCES `concerthallDB`.`Events` (`event_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Feedback_Audience1`
    FOREIGN KEY (`audience_id`)
    REFERENCES `concerthallDB`.`Audiences` (`audience_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `concerthallDB`.`Events_has_Venues`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `concerthallDB`.`Events_has_Venues` (
  `Events_has_Venue_id` INT NOT NULL AUTO_INCREMENT,
  `event_id` INT NOT NULL,
  `venue_id` INT NOT NULL,
  PRIMARY KEY (`Events_has_Venue_id`, `event_id`, `venue_id`),
  INDEX `fk_Events_has_Venues_Venues1_idx` (`venue_id` ASC) VISIBLE,
  INDEX `fk_Events_has_Venues_Events1_idx` (`event_id` ASC) VISIBLE,
  CONSTRAINT `fk_Events_has_Venues_Events1`
    FOREIGN KEY (`event_id`)
    REFERENCES `concerthallDB`.`Events` (`event_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Events_has_Venues_Venues1`
    FOREIGN KEY (`venue_id`)
    REFERENCES `concerthallDB`.`Venues` (`venue_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
