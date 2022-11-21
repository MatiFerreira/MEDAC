-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema libreria2
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema libreria2
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `libreria2` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema Libreria
-- -----------------------------------------------------
USE `libreria2` ;

-- -----------------------------------------------------
-- Table `libreria2`.`Cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `libreria2`.`Cliente` (
  `dni` VARCHAR(9) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`dni`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `libreria2`.`ticket_compra`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `libreria2`.`ticket_compra` (
  `idFactura` INT NOT NULL,
  `precio` VARCHAR(45) NOT NULL,
  `Cliente_dni` VARCHAR(9) NULL,
  PRIMARY KEY (`idFactura`),
  INDEX `fk_ticket_compra_Cliente1_idx` (`Cliente_dni` ASC) VISIBLE,
  CONSTRAINT `fk_ticket_compra_Cliente1`
    FOREIGN KEY (`Cliente_dni`)
    REFERENCES `libreria2`.`Cliente` (`dni`)
    ON DELETE SET NULL
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `libreria2`.`Libros`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `libreria2`.`Libros` (
  `id_libro` INT NOT NULL,
  `nombre` VARCHAR(45) NULL,
  `ticket_compra_idFactura` INT NOT NULL,
  PRIMARY KEY (`id_libro`),
  INDEX `fk_Libros_ticket_compra1_idx` (`ticket_compra_idFactura` ASC) VISIBLE,
  CONSTRAINT `fk_Libros_ticket_compra1`
    FOREIGN KEY (`ticket_compra_idFactura`)
    REFERENCES `libreria2`.`ticket_compra` (`idFactura`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `libreria2`.`Editorial`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `libreria2`.`Editorial` (
  `idEditorial` INT NOT NULL,
  `nombre_editorial` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idEditorial`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `libreria2`.`Proveedor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `libreria2`.`Proveedor` (
  `idProveedor` INT NOT NULL,
  `Nombre_proovedor` VARCHAR(45) NOT NULL,
  `Editorial_idEditorial` INT NOT NULL,
  PRIMARY KEY (`idProveedor`),
  INDEX `fk_Proveedor_Editorial1_idx` (`Editorial_idEditorial` ASC) VISIBLE,
  CONSTRAINT `fk_Proveedor_Editorial1`
    FOREIGN KEY (`Editorial_idEditorial`)
    REFERENCES `libreria2`.`Editorial` (`idEditorial`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `libreria2`.`libros_y_proveedores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `libreria2`.`libros_y_proveedores` (
  `Libros_id_libro` INT NOT NULL,
  `Proveedor_idProveedor` INT NOT NULL,
  PRIMARY KEY (`Libros_id_libro`, `Proveedor_idProveedor`),
  INDEX `fk_Libros_has_Proveedor_Proveedor1_idx` (`Proveedor_idProveedor` ASC) VISIBLE,
  INDEX `fk_Libros_has_Proveedor_Libros1_idx` (`Libros_id_libro` ASC) VISIBLE,
  CONSTRAINT `fk_Libros_has_Proveedor_Libros1`
    FOREIGN KEY (`Libros_id_libro`)
    REFERENCES `libreria2`.`Libros` (`id_libro`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Libros_has_Proveedor_Proveedor1`
    FOREIGN KEY (`Proveedor_idProveedor`)
    REFERENCES `libreria2`.`Proveedor` (`idProveedor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
