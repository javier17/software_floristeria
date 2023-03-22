-- MySQL Script generated by MySQL Workbench
-- Tue Mar 21 22:20:25 2023
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=1;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=1;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema floristeria
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema floristeria
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `floristeria` DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci ;
USE `floristeria` ;

-- -----------------------------------------------------
-- Table `floristeria`.`Categorias`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `floristeria`.`Categorias` (
  `id_categoria` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(200) NOT NULL,
  `foto` VARCHAR(250) NULL,
  `fecha_creacion` DATE NOT NULL,
  `estado` TINYINT(1) NOT NULL DEFAULT 1,
  `id_padre_categoria` INT NULL,
  PRIMARY KEY (`id_categoria`),
  UNIQUE INDEX `UQ_ID_CATEGORIA` (`id_categoria` ASC) VISIBLE,
  INDEX `IDX_ID_CATEGORIA` (`id_padre_categoria` ASC) VISIBLE,
  CONSTRAINT `FK_CATEGORIAS_ID_PADRE_CATEGORIA`
    FOREIGN KEY (`id_padre_categoria`)
    REFERENCES `floristeria`.`Categorias` (`id_categoria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

