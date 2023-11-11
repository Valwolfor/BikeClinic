-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema motor_clinic
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema motor_clinic
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `motor_clinic` DEFAULT CHARACTER SET utf8mb3 ;
USE `motor_clinic` ;

-- -----------------------------------------------------
-- Table `motor_clinic`.`person`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `motor_clinic`.`person` ;

CREATE TABLE IF NOT EXISTS `motor_clinic`.`person` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `contact_number` VARCHAR(255) NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  `first_name` VARCHAR(255) NOT NULL,
  `last_name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 21
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `motor_clinic`.`customer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `motor_clinic`.`customer` ;

CREATE TABLE IF NOT EXISTS `motor_clinic`.`customer` (
  `type_id` VARCHAR(255) NULL DEFAULT NULL,
  `id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FKr9okrktxscw3omxi1wm7cg18u`
    FOREIGN KEY (`id`)
    REFERENCES `motor_clinic`.`person` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `motor_clinic`.`motorcycle`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `motor_clinic`.`motorcycle` ;

CREATE TABLE IF NOT EXISTS `motor_clinic`.`motorcycle` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `brand` VARCHAR(255) NULL DEFAULT NULL,
  `chassis_id` VARCHAR(255) NOT NULL,
  `engine_id` VARCHAR(255) NOT NULL,
  `model` VARCHAR(255) NULL DEFAULT NULL,
  `plate` VARCHAR(255) NOT NULL,
  `registration_year` VARCHAR(255) NOT NULL,
  `customer_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK4tu7obo3gxky2p31gfb5xx98x` (`customer_id` ASC) VISIBLE,
  UNIQUE INDEX `engine_id_UNIQUE` (`engine_id` ASC) VISIBLE,
  UNIQUE INDEX `plate_UNIQUE` (`plate` ASC) VISIBLE,
  UNIQUE INDEX `chassis_id_UNIQUE` (`chassis_id` ASC) VISIBLE,
  CONSTRAINT `FK4tu7obo3gxky2p31gfb5xx98x`
    FOREIGN KEY (`customer_id`)
    REFERENCES `motor_clinic`.`customer` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `motor_clinic`.`product`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `motor_clinic`.`product` ;

CREATE TABLE IF NOT EXISTS `motor_clinic`.`product` (
  `id_product` INT NOT NULL AUTO_INCREMENT,
  `product_name` VARCHAR(255) NOT NULL,
  `product_value` DECIMAL NOT NULL,
  `quantity` TINYINT NOT NULL,
  PRIMARY KEY (`id_product`),
  UNIQUE INDEX `product_name_UNIQUE` (`product_name` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `motor_clinic`.`status`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `motor_clinic`.`status` ;

CREATE TABLE IF NOT EXISTS `motor_clinic`.`status` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `brake_fluid` VARCHAR(255) NOT NULL,
  `brakes` VARCHAR(255) NOT NULL,
  `chain` VARCHAR(255) NOT NULL,
  `chassis` VARCHAR(255) NOT NULL,
  `clutch` VARCHAR(255) NOT NULL,
  `clutch_fluid` VARCHAR(255) NOT NULL,
  `coolant` VARCHAR(255) NOT NULL,
  `engine` VARCHAR(255) NOT NULL,
  `exhaust` VARCHAR(255) NOT NULL,
  `foot_pegs` VARCHAR(255) NOT NULL,
  `front_tire` VARCHAR(255) NOT NULL,
  `fuel` VARCHAR(255) NOT NULL,
  `horn` VARCHAR(255) NOT NULL,
  `indicators` VARCHAR(255) NOT NULL,
  `indicators_desc` VARCHAR(255) NOT NULL,
  `lights_good` VARCHAR(255) NOT NULL,
  `mileage` VARCHAR(255) NOT NULL,
  `mirrors` VARCHAR(255) NOT NULL,
  `oil` VARCHAR(255) NOT NULL,
  `oil_level` VARCHAR(255) NOT NULL,
  `rear_tire` VARCHAR(255) NOT NULL,
  `tank` VARCHAR(255) NOT NULL,
  `throttle` VARCHAR(255) NOT NULL,
  `transmission` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `motor_clinic`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `motor_clinic`.`user` ;

CREATE TABLE IF NOT EXISTS `motor_clinic`.`user` (
  `password` VARCHAR(255) NOT NULL,
  `roles` VARBINARY(255) NOT NULL,
  `status` ENUM('ACTIVE', 'INACTIVE') NOT NULL,
  `id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `password_UNIQUE` (`password` ASC) VISIBLE,
  CONSTRAINT `FKrfqycm0yt2on7769pb3frk32r`
    FOREIGN KEY (`id`)
    REFERENCES `motor_clinic`.`person` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `motor_clinic`.`service_order`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `motor_clinic`.`service_order` ;

CREATE TABLE IF NOT EXISTS `motor_clinic`.`service_order` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `advance` VARCHAR(255) NOT NULL,
  `advance_value` DECIMAL NULL DEFAULT NULL,
  `date` DATETIME(6) NOT NULL,
  `diagnostic_desc` VARCHAR(255) NULL DEFAULT NULL,
  `documents` VARCHAR(255) NOT NULL,
  `motorcycle_plate` VARCHAR(6) NOT NULL,
  `reason` VARCHAR(255) NOT NULL,
  `route_auth` TINYINT(1) NOT NULL DEFAULT 0,
  `motorcycle_id` BIGINT NOT NULL,
  `status_id` BIGINT NOT NULL,
  `user_id_mech` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_service_order_motorcycle1_idx` (`motorcycle_id` ASC) VISIBLE,
  INDEX `fk_service_order_status1_idx` (`status_id` ASC) VISIBLE,
  UNIQUE INDEX `status_id_UNIQUE` (`status_id` ASC) VISIBLE,
  INDEX `fk_service_order_user1_idx` (`user_id_mech` ASC) VISIBLE,
  CONSTRAINT `fk_service_order_motorcycle1`
    FOREIGN KEY (`motorcycle_id`)
    REFERENCES `motor_clinic`.`motorcycle` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_service_order_status1`
    FOREIGN KEY (`status_id`)
    REFERENCES `motor_clinic`.`status` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_service_order_user1`
    FOREIGN KEY (`user_id_mech`)
    REFERENCES `motor_clinic`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `motor_clinic`.`service`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `motor_clinic`.`service` ;

CREATE TABLE IF NOT EXISTS `motor_clinic`.`service` (
  `id_service` INT NOT NULL AUTO_INCREMENT,
  `service_detail` VARCHAR(255) NULL DEFAULT NULL,
  `service_name` VARCHAR(255) NOT NULL,
  `service_value` DECIMAL NOT NULL,
  PRIMARY KEY (`id_service`),
  UNIQUE INDEX `service_name_UNIQUE` (`service_name` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `motor_clinic`.`record_serv_prod`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `motor_clinic`.`record_serv_prod` ;

CREATE TABLE IF NOT EXISTS `motor_clinic`.`record_serv_prod` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `is_approved` TINYINT(1) NOT NULL DEFAULT 0,
  `product_id` INT NOT NULL,
  `service_id` INT NOT NULL,
  `order_id` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKmolr3cwn53d12mpqc643q8c5v` (`product_id` ASC) VISIBLE,
  INDEX `FKd81mp8mqsk08ntl0ioqsb0hit` (`service_id` ASC) VISIBLE,
  INDEX `FK8g3wi821i94w9id532xkn0p34` (`order_id` ASC) VISIBLE,
  CONSTRAINT `FK8g3wi821i94w9id532xkn0p34`
    FOREIGN KEY (`order_id`)
    REFERENCES `motor_clinic`.`service_order` (`id`),
  CONSTRAINT `FKd81mp8mqsk08ntl0ioqsb0hit`
    FOREIGN KEY (`service_id`)
    REFERENCES `motor_clinic`.`service` (`id_service`),
  CONSTRAINT `FKmolr3cwn53d12mpqc643q8c5v`
    FOREIGN KEY (`product_id`)
    REFERENCES `motor_clinic`.`product` (`id_product`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
