 
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema agogui_sch
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema agogui_sch
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `agogui_sch` DEFAULT CHARACTER SET latin1 ;
USE `agogui_sch` ;

-- -----------------------------------------------------
-- Table `agogui_sch`.`pais`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `agogui_sch`.`pais` ;

CREATE TABLE IF NOT EXISTS `agogui_sch`.`pais` (
  `id` INT(11) NOT NULL,
  `nombre` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `agogui_sch`.`departamento`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `agogui_sch`.`departamento` ;

CREATE TABLE IF NOT EXISTS `agogui_sch`.`departamento` (
  `id` INT(11) NOT NULL,
  `nombre` VARCHAR(70) NOT NULL,
  `id_pais` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `departamento_pais_fk_idx` (`id_pais` ASC),
  CONSTRAINT `departamento_pais_fk`
    FOREIGN KEY (`id_pais`)
    REFERENCES `agogui_sch`.`pais` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `agogui_sch`.`ciudad_o_municipio`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `agogui_sch`.`ciudad_o_municipio` ;

CREATE TABLE IF NOT EXISTS `agogui_sch`.`ciudad_o_municipio` (
  `id` INT(11) NOT NULL,
  `nombre` VARCHAR(100) NOT NULL,
  `id_departamento` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `ciudadomunicipio_departamento_fk_idx` (`id_departamento` ASC),
  CONSTRAINT `ciudadomunicipio_departamento_fk`
    FOREIGN KEY (`id_departamento`)
    REFERENCES `agogui_sch`.`departamento` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `agogui_sch`.`institucion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `agogui_sch`.`institucion` ;

CREATE TABLE IF NOT EXISTS `agogui_sch`.`institucion` (
  `codigo` INT(11) NOT NULL,
  `nombre` VARCHAR(150) NOT NULL,
  `nivel` VARCHAR(1) NOT NULL,
  `razon_social` VARCHAR(1) NOT NULL,
  `fecha_creacion` DATETIME NULL,
  `correo_electronico` VARCHAR(60) NULL,
  `telefono` VARCHAR(50) NULL,
  `estado` VARCHAR(20) NULL,
  `id_ciudad_o_municipio` INT(11) NOT NULL,
  PRIMARY KEY (`codigo`),
  INDEX `fk_institucion_1_idx` (`id_ciudad_o_municipio` ASC),
  CONSTRAINT `fk_institucion_1`
    FOREIGN KEY (`id_ciudad_o_municipio`)
    REFERENCES `agogui_sch`.`ciudad_o_municipio` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `agogui_sch`.`area`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `agogui_sch`.`area` ;

CREATE TABLE IF NOT EXISTS `agogui_sch`.`area` (
  `id` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `descripcion` TEXT NULL,
  `codigo_institucion` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_area_1_idx` (`codigo_institucion` ASC),
  CONSTRAINT `fk_area_1`
    FOREIGN KEY (`codigo_institucion`)
    REFERENCES `agogui_sch`.`institucion` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `agogui_sch`.`asignatura`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `agogui_sch`.`asignatura` ;

CREATE TABLE IF NOT EXISTS `agogui_sch`.`asignatura` (
  `codigo` INT(11) NOT NULL,
  `nombre` VARCHAR(100) NULL DEFAULT NULL,
  `id_area` INT(11) NOT NULL,
  PRIMARY KEY (`codigo`),
  INDEX `fk_asignatura_1_idx` (`id_area` ASC),
  CONSTRAINT `fk_asignatura_1`
    FOREIGN KEY (`id_area`)
    REFERENCES `agogui_sch`.`area` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `agogui_sch`.`sede`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `agogui_sch`.`sede` ;

CREATE TABLE IF NOT EXISTS `agogui_sch`.`sede` (
  `id` INT(11) NOT NULL,
  `nombre` VARCHAR(150) NOT NULL,
  `direccion` VARCHAR(150) NULL,
  `correo_electronico` VARCHAR(60) NULL,
  `telefono` VARCHAR(50) NULL,
  `codigo_institucion` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Sede_1_idx` (`codigo_institucion` ASC),
  CONSTRAINT `fk_Sede_1`
    FOREIGN KEY (`codigo_institucion`)
    REFERENCES `agogui_sch`.`institucion` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `agogui_sch`.`docente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `agogui_sch`.`docente` ;

CREATE TABLE IF NOT EXISTS `agogui_sch`.`docente` (
  `codigo` INT(11) NOT NULL,
  `documento_id` BIGINT(20) NOT NULL,
  `nombre` VARCHAR(100) NOT NULL,
  `primer_apellido` VARCHAR(100) NOT NULL,
  `segundo_apellido` VARCHAR(100) NOT NULL,
  `sexo` VARCHAR(1) NULL DEFAULT NULL,
  `fecha_nacimiento` DATE NULL DEFAULT NULL,
  `fecha_registro` DATETIME NULL,
  `estado_civil` VARCHAR(1) NULL DEFAULT NULL,
  `titulo_profesional` VARCHAR(200) NULL DEFAULT NULL,
  `foto` VARCHAR(100) NULL DEFAULT NULL,
  `nacionalidad` VARCHAR(50) NULL DEFAULT NULL,
  `id_ciudad_o_municipio` INT(11) NULL DEFAULT NULL,
  `barrio` VARCHAR(100) NULL DEFAULT NULL,
  `direccion` VARCHAR(150) NULL DEFAULT NULL,
  `telefono1` VARCHAR(50) NULL DEFAULT NULL,
  `telefono2` VARCHAR(50) NULL DEFAULT NULL,
  `correo_electronico` VARCHAR(60) NULL DEFAULT NULL,
  `tipo_acceso` INT(11) NULL DEFAULT NULL,
  `estado` TINYINT(1) NULL,
  `id_sede` INT(11) NOT NULL,
  PRIMARY KEY (`codigo`),
  INDEX `fk_docente_1_idx` (`id_sede` ASC),
  INDEX `fk_docente_2_idx` (`id_ciudad_o_municipio` ASC),
  CONSTRAINT `fk_docente_1`
    FOREIGN KEY (`id_sede`)
    REFERENCES `agogui_sch`.`sede` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_docente_2`
    FOREIGN KEY (`id_ciudad_o_municipio`)
    REFERENCES `agogui_sch`.`ciudad_o_municipio` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `agogui_sch`.`grado`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `agogui_sch`.`grado` ;

CREATE TABLE IF NOT EXISTS `agogui_sch`.`grado` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `numero` INT(11) NOT NULL,
  `alias` VARCHAR(45) NOT NULL,
  `codigo_institucion` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_grado_1_idx` (`codigo_institucion` ASC),
  CONSTRAINT `fk_grado_1`
    FOREIGN KEY (`codigo_institucion`)
    REFERENCES `agogui_sch`.`institucion` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `agogui_sch`.`jornada`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `agogui_sch`.`jornada` ;

CREATE TABLE IF NOT EXISTS `agogui_sch`.`jornada` (
  `id` INT(11) NOT NULL,
  `nombre` VARCHAR(60) NULL,
  `id_sede` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_jornada_1_idx` (`id_sede` ASC),
  CONSTRAINT `fk_jornada_1`
    FOREIGN KEY (`id_sede`)
    REFERENCES `agogui_sch`.`sede` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `agogui_sch`.`curso`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `agogui_sch`.`curso` ;

CREATE TABLE IF NOT EXISTS `agogui_sch`.`curso` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(30) NOT NULL,
  `fecha_creacion` DATETIME NULL,
  `anio_lectivo` INT(11) NOT NULL,
  `activo` TINYINT(1) NULL,
  `id_jornada` INT(11) NOT NULL,
  `id_grado` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `curso_jornada_fk_idx` (`id_jornada` ASC),
  INDEX `curso_grado_fk_idx` (`id_grado` ASC),
  CONSTRAINT `curso_grado_fk`
    FOREIGN KEY (`id_grado`)
    REFERENCES `agogui_sch`.`grado` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `curso_jornada_fk`
    FOREIGN KEY (`id_jornada`)
    REFERENCES `agogui_sch`.`jornada` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 12
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `agogui_sch`.`periodo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `agogui_sch`.`periodo` ;

CREATE TABLE IF NOT EXISTS `agogui_sch`.`periodo` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `numero` INT(11) NOT NULL,
  `alias` VARCHAR(45) NULL,
  `id_grado` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_periodo_1_idx` (`id_grado` ASC),
  CONSTRAINT `fk_periodo_1`
    FOREIGN KEY (`id_grado`)
    REFERENCES `agogui_sch`.`grado` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `agogui_sch`.`evaluacion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `agogui_sch`.`evaluacion` ;

CREATE TABLE IF NOT EXISTS `agogui_sch`.`evaluacion` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `numero` INT(11) NULL,
  `titulo` VARCHAR(150) NOT NULL,
  `porcentaje` INT NULL,
  `fecha` DATETIME NULL,
  `descripcion` TEXT NULL,
  `id_docente` INT(11) NOT NULL,
  `id_asignatura` INT(11) NOT NULL,
  `id_curso` INT(11) NOT NULL,
  `id_periodo` INT(11) NOT NULL,
  `tipo_calificacion_logros` INT(11) NULL,
  PRIMARY KEY (`id`),
  INDEX `calificacion_periodo_ref` (`titulo` ASC),
  INDEX `fk_evaluacion_1_idx` (`id_docente` ASC),
  INDEX `fk_evaluacion_2_idx` (`id_asignatura` ASC),
  INDEX `fk_evaluacion_3_idx` (`id_curso` ASC),
  INDEX `fk_evaluacion_4_idx` (`id_periodo` ASC),
  CONSTRAINT `fk_evaluacion_1`
    FOREIGN KEY (`id_docente`)
    REFERENCES `agogui_sch`.`docente` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_evaluacion_2`
    FOREIGN KEY (`id_asignatura`)
    REFERENCES `agogui_sch`.`asignatura` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_evaluacion_3`
    FOREIGN KEY (`id_curso`)
    REFERENCES `agogui_sch`.`curso` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_evaluacion_4`
    FOREIGN KEY (`id_periodo`)
    REFERENCES `agogui_sch`.`periodo` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 1321
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `agogui_sch`.`estudiante`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `agogui_sch`.`estudiante` ;

CREATE TABLE IF NOT EXISTS `agogui_sch`.`estudiante` (
  `codigo` INT(11) NOT NULL,
  `documento_id` BIGINT(20) NOT NULL,
  `nombre` VARCHAR(100) NOT NULL,
  `primer_apellido` VARCHAR(50) NOT NULL,
  `segundo_apellido` VARCHAR(50) NOT NULL,
  `sexo` VARCHAR(1) NULL DEFAULT NULL,
  `fecha_nacimiento` DATE NULL DEFAULT NULL,
  `fecha_registro` DATETIME NULL,
  `foto` VARCHAR(100) NULL DEFAULT NULL,
  `nacionalidad` VARCHAR(50) NULL DEFAULT NULL,
  `id_ciudad_o_municipio` INT(11) NULL DEFAULT NULL,
  `barrio` VARCHAR(100) NULL DEFAULT NULL,
  `direccion` VARCHAR(150) NULL DEFAULT NULL,
  `telefono1` VARCHAR(50) NULL DEFAULT NULL,
  `telefono2` VARCHAR(50) NULL DEFAULT NULL,
  `correo_electronico` VARCHAR(60) NULL DEFAULT NULL,
  `tipo_acceso` INT(11) NULL DEFAULT NULL,
  `estado` TINYINT(1) NULL,
  `id_jornada` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  INDEX `fk_estudiante_1_idx` (`id_ciudad_o_municipio` ASC),
  CONSTRAINT `fk_estudiante_1`
    FOREIGN KEY (`id_ciudad_o_municipio`)
    REFERENCES `agogui_sch`.`ciudad_o_municipio` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_estudiante_2`
    FOREIGN KEY (`id_jornada`)
    REFERENCES `agogui_sch`.`jornada` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `agogui_sch`.`docente_asignatura`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `agogui_sch`.`docente_asignatura` ;

CREATE TABLE IF NOT EXISTS `agogui_sch`.`docente_asignatura` (
  `id` INT(11) NOT NULL,
  `codigo_docente` INT(11) NOT NULL,
  `codigo_asignatura` INT(11) NOT NULL,
  `habilitado` VARCHAR(1) NULL,
  INDEX `fk_docente_asignatura_1_idx` (`codigo_docente` ASC),
  INDEX `fk_docente_asignatura_2_idx` (`codigo_asignatura` ASC),
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_docente_asignatura_1`
    FOREIGN KEY (`codigo_docente`)
    REFERENCES `agogui_sch`.`docente` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_docente_asignatura_2`
    FOREIGN KEY (`codigo_asignatura`)
    REFERENCES `agogui_sch`.`asignatura` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `agogui_sch`.`tema`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `agogui_sch`.`tema` ;

CREATE TABLE IF NOT EXISTS `agogui_sch`.`tema` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(200) NULL,
  `codigo_asignatura` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_tema_1_idx` (`codigo_asignatura` ASC),
  CONSTRAINT `fk_tema_1`
    FOREIGN KEY (`codigo_asignatura`)
    REFERENCES `agogui_sch`.`asignatura` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `agogui_sch`.`competencia`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `agogui_sch`.`competencia` ;

CREATE TABLE IF NOT EXISTS `agogui_sch`.`competencia` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `agogui_sch`.`logro`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `agogui_sch`.`logro` ;

CREATE TABLE IF NOT EXISTS `agogui_sch`.`logro` (
  `codigo` INT(11) NOT NULL,
  `descripcion` VARCHAR(500) NOT NULL,
  `id_tema` INT(11) NOT NULL,
  `id_competencia` INT(11) NOT NULL,
  `id_periodo` INT(11) NOT NULL,
  PRIMARY KEY (`codigo`),
  INDEX `fk_logro_1_idx` (`id_tema` ASC),
  INDEX `fk_logro_2_idx` (`id_competencia` ASC),
  INDEX `fk_logro_3_idx` (`id_periodo` ASC),
  CONSTRAINT `fk_logro_1`
    FOREIGN KEY (`id_tema`)
    REFERENCES `agogui_sch`.`tema` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_logro_2`
    FOREIGN KEY (`id_competencia`)
    REFERENCES `agogui_sch`.`competencia` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_logro_3`
    FOREIGN KEY (`id_periodo`)
    REFERENCES `agogui_sch`.`periodo` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `agogui_sch`.`docenteasignatura_curso`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `agogui_sch`.`docenteasignatura_curso` ;

CREATE TABLE IF NOT EXISTS `agogui_sch`.`docenteasignatura_curso` (
  `id` INT(11) NOT NULL,
  `intensidad_horaria` INT NULL,
  `codigo_docente` INT(11) NOT NULL,
  `codigo_asignatura` INT(11) NOT NULL,
  `id_curso` INT(11) NOT NULL,
  INDEX `fk_docenteasignatura_curso_3_idx` (`id_curso` ASC),
  INDEX `fk_docenteasignatura_curso_1_idx` (`codigo_docente` ASC),
  PRIMARY KEY (`id`),
  INDEX `fk_docenteasignatura_curso_2_idx` (`codigo_asignatura` ASC),
  CONSTRAINT `fk_docenteasignatura_curso_3`
    FOREIGN KEY (`id_curso`)
    REFERENCES `agogui_sch`.`curso` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_docenteasignatura_curso_1`
    FOREIGN KEY (`codigo_docente`)
    REFERENCES `agogui_sch`.`docente` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_docenteasignatura_curso_2`
    FOREIGN KEY (`codigo_asignatura`)
    REFERENCES `agogui_sch`.`asignatura` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `agogui_sch`.`estudiante_curso`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `agogui_sch`.`estudiante_curso` ;

CREATE TABLE IF NOT EXISTS `agogui_sch`.`estudiante_curso` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `codigo_estudiante` INT(11) NOT NULL,
  `id_curso` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_estudiante_curso_1_idx` (`codigo_estudiante` ASC),
  INDEX `fk_estudiante_curso_2_idx` (`id_curso` ASC),
  CONSTRAINT `fk_estudiante_curso_1`
    FOREIGN KEY (`codigo_estudiante`)
    REFERENCES `agogui_sch`.`estudiante` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_estudiante_curso_2`
    FOREIGN KEY (`id_curso`)
    REFERENCES `agogui_sch`.`curso` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `agogui_sch`.`notaxevaluacion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `agogui_sch`.`notaxevaluacion` ;

CREATE TABLE IF NOT EXISTS `agogui_sch`.`notaxevaluacion` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nota_numero` DOUBLE NULL,
  `nota_texto` VARCHAR(10) NULL,
  `formato` VARCHAR(1) NULL,
  `id_estudiante` INT(11) NOT NULL,
  `id_curso` INT(11) NOT NULL,
  `id_evaluacion` INT(11) NOT NULL,
  `id_asignatura` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_notaxevaluacion_1_idx` (`id_estudiante` ASC),
  INDEX `fk_notaxevaluacion_2_idx` (`id_curso` ASC),
  INDEX `fk_notaxevaluacion_3_idx` (`id_evaluacion` ASC),
  INDEX `fk_notaxevaluacion_4_idx` (`id_asignatura` ASC),
  CONSTRAINT `fk_notaxevaluacion_1`
    FOREIGN KEY (`id_estudiante`)
    REFERENCES `agogui_sch`.`estudiante` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_notaxevaluacion_2`
    FOREIGN KEY (`id_curso`)
    REFERENCES `agogui_sch`.`curso` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_notaxevaluacion_3`
    FOREIGN KEY (`id_evaluacion`)
    REFERENCES `agogui_sch`.`evaluacion` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_notaxevaluacion_4`
    FOREIGN KEY (`id_asignatura`)
    REFERENCES `agogui_sch`.`asignatura` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `agogui_sch`.`notaxperiodo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `agogui_sch`.`notaxperiodo` ;

CREATE TABLE IF NOT EXISTS `agogui_sch`.`notaxperiodo` (
  `id` INT(11) NOT NULL,
  `nota_numero` DOUBLE NULL,
  `nota_texto` VARCHAR(10) NULL,
  `desempenio` TEXT NULL,
  `formato` VARCHAR(1) NULL,
  `id_estudiante` INT(11) NOT NULL,
  `id_curso` INT(11) NOT NULL,
  `id_periodo` INT(11) NOT NULL,
  `id_asignatura` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_notaxperiodo_1_idx` (`id_estudiante` ASC),
  INDEX `fk_notaxperiodo_2_idx` (`id_curso` ASC),
  INDEX `fk_notaxperiodo_3_idx` (`id_periodo` ASC),
  INDEX `fk_notaxperiodo_5_idx` (`id_asignatura` ASC),
  CONSTRAINT `fk_notaxperiodo_1`
    FOREIGN KEY (`id_estudiante`)
    REFERENCES `agogui_sch`.`estudiante` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_notaxperiodo_2`
    FOREIGN KEY (`id_curso`)
    REFERENCES `agogui_sch`.`curso` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_notaxperiodo_3`
    FOREIGN KEY (`id_periodo`)
    REFERENCES `agogui_sch`.`periodo` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_notaxperiodo_5`
    FOREIGN KEY (`id_asignatura`)
    REFERENCES `agogui_sch`.`asignatura` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `agogui_sch`.`notafinal`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `agogui_sch`.`notafinal` ;

CREATE TABLE IF NOT EXISTS `agogui_sch`.`notafinal` (
  `id` INT(11) NOT NULL,
  `nota_numero` DOUBLE NULL,
  `nota_texto` VARCHAR(10) NULL,
  `desempenio` TEXT NULL,
  `formato` VARCHAR(1) NULL,
  `id_estudiante` INT(11) NOT NULL,
  `id_curso` INT(11) NOT NULL,
  `id_asignatura` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_notafinal_1_idx` (`id_estudiante` ASC),
  INDEX `fk_notafinal_2_idx` (`id_curso` ASC),
  INDEX `fk_notafinal_5_idx` (`id_asignatura` ASC),
  CONSTRAINT `fk_notafinal_1`
    FOREIGN KEY (`id_estudiante`)
    REFERENCES `agogui_sch`.`estudiante` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_notafinal_2`
    FOREIGN KEY (`id_curso`)
    REFERENCES `agogui_sch`.`curso` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_notafinal_5`
    FOREIGN KEY (`id_asignatura`)
    REFERENCES `agogui_sch`.`asignatura` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
