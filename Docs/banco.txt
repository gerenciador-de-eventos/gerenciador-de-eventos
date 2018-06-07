-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema event_manager
-- -----------------------------------------------------
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Place`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Place` (
  `idPlace` INT NOT NULL AUTO_INCREMENT,
  `PlaceName` VARCHAR(100) NOT NULL,
  `PlaceCampus` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`idPlace`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Person`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Person` (
  `idPerson` INT NOT NULL AUTO_INCREMENT,
  `PersonName` VARCHAR(100) NULL,
  `PersonRG` VARCHAR(20) NULL,
  `PersonCPF` VARCHAR(20) NULL,
  `PersonDateBorn` DATE NULL,
  `PersonPrivileges` TINYINT NULL,
  `PersonHourWork` VARCHAR(100) NULL,
  `PersonEmail` VARCHAR(45) NOT NULL,
  `PersonPassword` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idPerson`),
  UNIQUE INDEX `PersonName_UNIQUE` (`PersonName` ASC),
  UNIQUE INDEX `PersonRG_UNIQUE` (`PersonRG` ASC),
  UNIQUE INDEX `PersonCPF_UNIQUE` (`PersonCPF` ASC),
  UNIQUE INDEX `PersonDateBorn_UNIQUE` (`PersonDateBorn` ASC),
  UNIQUE INDEX `PersonPrivileges_UNIQUE` (`PersonPrivileges` ASC),
  UNIQUE INDEX `PersonHourWork_UNIQUE` (`PersonHourWork` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Campus`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Campus` (
  `idCampus` INT NOT NULL AUTO_INCREMENT,
  `CampusName` VARCHAR(100) NOT NULL,
  `CampusCity` VARCHAR(100) NOT NULL,
  `CampusFantasyName` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`idCampus`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Event`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Event` (
  `idEvent` INT NOT NULL AUTO_INCREMENT,
  `EventName` VARCHAR(100) NOT NULL,
  `EventDate` DATE NOT NULL,
  `EventClass` VARCHAR(100) NOT NULL,
  `EventCampus` VARCHAR(100) NOT NULL,
  `EventResponsible` VARCHAR(100) NOT NULL,
  `EventTrainee` VARCHAR(100) NULL,
  `EventHour` VARCHAR(100) NOT NULL,
  `Class_idClass` INT NOT NULL,
  `Person_idPerson` INT NOT NULL,
  `Campus_idCampus` INT NOT NULL,
  PRIMARY KEY (`idEvent`, `Person_idPerson`, `Campus_idCampus`),
  INDEX `fk_Event_Class1_idx` (`Class_idClass` ASC),
  INDEX `fk_Event_Person1_idx` (`Person_idPerson` ASC),
  INDEX `fk_Event_Campus1_idx` (`Campus_idCampus` ASC),
  CONSTRAINT `fk_Event_Class1`
    FOREIGN KEY (`Class_idClass`)
    REFERENCES `mydb`.`Place` (`idPlace`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Event_Person1`
    FOREIGN KEY (`Person_idPerson`)
    REFERENCES `mydb`.`Person` (`idPerson`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Event_Campus1`
    FOREIGN KEY (`Campus_idCampus`)
    REFERENCES `mydb`.`Campus` (`idCampus`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Type` (
  `idType` INT NOT NULL,
  `TypeName` VARCHAR(45) NULL,
  PRIMARY KEY (`idType`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Equipaments`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Equipaments` (
  `idEquipaments` INT NOT NULL AUTO_INCREMENT,
  `EquipamentsName` VARCHAR(200) NOT NULL,
  `EquipamentsType` INT NOT NULL,
  PRIMARY KEY (`idEquipaments`),
  INDEX `typefk_idx` (`EquipamentsType` ASC),
  CONSTRAINT `typefk`
    FOREIGN KEY (`EquipamentsType`)
    REFERENCES `mydb`.`Type` (`idType`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`EventEquipament`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`EventEquipament` (
  `idEventEquipament` INT NOT NULL,
  `idEvent` INT NULL,
  `idEquipament` INT NULL,
  PRIMARY KEY (`idEventEquipament`),
  INDEX `index2` (`idEvent` ASC, `idEquipament` ASC),
  INDEX `equipFk_idx` (`idEquipament` ASC),
  CONSTRAINT `equipFk`
    FOREIGN KEY (`idEquipament`)
    REFERENCES `mydb`.`Equipaments` (`idEquipaments`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `eventoFk`
    FOREIGN KEY (`idEvent`)
    REFERENCES `mydb`.`Event` (`idEvent`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
