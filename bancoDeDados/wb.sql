-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema bdprova
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema bdprova
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bdprova` DEFAULT CHARACTER SET utf8 ;
USE `bdprova` ;

-- -----------------------------------------------------
-- Table `bdprova`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdprova`.`usuario` (
  `idusuario` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  `senha` VARCHAR(100) NOT NULL,
  `admin` TINYINT NOT NULL,
  PRIMARY KEY (`idusuario`),
  UNIQUE INDEX `idusuario_UNIQUE` (`idusuario` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bdprova`.`imagem`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdprova`.`imagem` (
  `idimagem` INT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(45) NOT NULL,
  `image` VARCHAR(300) NOT NULL,
  PRIMARY KEY (`idimagem`),
  UNIQUE INDEX `idimagem_UNIQUE` (`idimagem` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bdprova`.`permissao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdprova`.`permissao` (
  `idusuario` INT NOT NULL,
  `idimagem` INT NOT NULL,
  `excluir` TINYINT NOT NULL,
  `visualizar` TINYINT NOT NULL DEFAULT 0,
  `compartilhar` TINYINT NOT NULL DEFAULT 0,
  PRIMARY KEY (`idusuario`, `idimagem`),
  INDEX `fk_usuario_has_imagem_usuario_idx` (`idusuario` ASC) VISIBLE,
  INDEX `fk_permissao_imagem1_idx` (`idimagem` ASC) VISIBLE,
  CONSTRAINT `fk_usuario_has_imagem_usuario`
    FOREIGN KEY (`idusuario`)
    REFERENCES `bdprova`.`usuario` (`idusuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_permissao_imagem1`
    FOREIGN KEY (`idimagem`)
    REFERENCES `bdprova`.`imagem` (`idimagem`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bdprova`.`Notificacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdprova`.`Notificacao` (
  `idNotificacao` INT NULL AUTO_INCREMENT,
  `idusuario` INT NOT NULL,
  `descricao` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`idNotificacao`, `idusuario`),
  UNIQUE INDEX `idNotificacao_UNIQUE` (`idNotificacao` ASC) VISIBLE,
  INDEX `fk_Notificacao_usuario1_idx` (`idusuario` ASC) VISIBLE,
  CONSTRAINT `fk_Notificacao_usuario1`
    FOREIGN KEY (`idusuario`)
    REFERENCES `bdprova`.`usuario` (`idusuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
