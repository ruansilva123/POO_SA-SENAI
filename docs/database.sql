-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `footbapi` DEFAULT CHARACTER SET utf8 ;
USE `footbapi` ;

-- -----------------------------------------------------
-- Table `mydb`.`Teams`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `footbapi`.`Teams` (
  `id_team` INT NOT NULL AUTO_INCREMENT,
  `name_team` VARCHAR(80) NOT NULL,
  PRIMARY KEY (`id_team`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Player`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `footbapi`.`Player` (
  `id_player` INT NOT NULL AUTO_INCREMENT,
  `name_player` VARCHAR(50) NOT NULL,
  `Teams_id_team` INT NOT NULL,
  PRIMARY KEY (`id_player`),
  INDEX `fk_Player_Teams_idx` (`Teams_id_team` ASC) VISIBLE,
  CONSTRAINT `fk_Player_Teams`
    FOREIGN KEY (`Teams_id_team`)
    REFERENCES `footbapi`.`Teams` (`id_team`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Competitions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `footbapi`.`Competitions` (
  `id_competition` INT NOT NULL AUTO_INCREMENT,
  `name_competition` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_competition`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Match`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `footbapi`.`Match` (
  `id_match` INT NOT NULL AUTO_INCREMENT,
  `fk_competition` INT NOT NULL,
  `fk_home_team` INT NOT NULL,
  `fk_away_team` INT NOT NULL,
  `home_team_goal` INT NOT NULL,
  `away_team_goal` INT NOT NULL,
  `date_match` DATETIME NOT NULL,
  PRIMARY KEY (`id_match`, `fk_competition`, `fk_home_team`, `fk_away_team`),
  INDEX `fk_Competitions_has_Teams_Teams1_idx` (`fk_home_team` ASC) VISIBLE,
  INDEX `fk_Competitions_has_Teams_Competitions1_idx` (`fk_competition` ASC) VISIBLE,
  INDEX `fk_away_team_idx` (`fk_away_team` ASC) VISIBLE,
  CONSTRAINT `fk_Competitions_has_Teams_Competitions1`
    FOREIGN KEY (`fk_competition`)
    REFERENCES `footbapi`.`Competitions` (`id_competition`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Competitions_has_Teams_Teams1`
    FOREIGN KEY (`fk_home_team`)
    REFERENCES `footbapi`.`Teams` (`id_team`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_away_team`
    FOREIGN KEY (`fk_away_team`)
    REFERENCES `footbapi`.`Teams` (`id_team`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;