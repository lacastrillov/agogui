/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  lacastrillov
 * Created: 19/05/2018
 */

CREATE TABLE `agogui_sch`.`institucion_user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `institucion_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_institucion_user_1_idx` (`institucion_id` ASC),
  INDEX `fk_institucion_user_2_idx` (`user_id` ASC),
  CONSTRAINT `fk_institucion_user_1`
    FOREIGN KEY (`institucion_id`)
    REFERENCES `agogui_sch`.`institucion` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_institucion_user_2`
    FOREIGN KEY (`user_id`)
    REFERENCES `agogui_sch`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

ALTER TABLE `agogui_sch`.`docente` 
DROP COLUMN `nacionalidad`;

ALTER TABLE `agogui_sch`.`docente` 
ADD COLUMN `id_pais` INT NULL AFTER `foto`,
ADD COLUMN `id_departamento` INT NULL AFTER `id_pais`,
ADD INDEX `fk_docente_3_idx` (`id_departamento` ASC),
ADD INDEX `fk_docente_4_idx` (`id_pais` ASC);
ALTER TABLE `agogui_sch`.`docente` 
ADD CONSTRAINT `fk_docente_3`
  FOREIGN KEY (`id_departamento`)
  REFERENCES `agogui_sch`.`departamento` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_docente_4`
  FOREIGN KEY (`id_pais`)
  REFERENCES `agogui_sch`.`pais` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `agogui_sch`.`docente` 
CHANGE COLUMN `estado` `estado` VARCHAR(20) NULL DEFAULT NULL ;

ALTER TABLE `agogui_sch`.`institucion` 
ADD COLUMN `id_pais` INT NULL AFTER `estado`,
ADD COLUMN `id_departamento` INT NULL AFTER `id_pais`;

ALTER TABLE `agogui_sch`.`institucion` 
ADD INDEX `fk_institucion_2_idx` (`id_departamento` ASC);
ALTER TABLE `agogui_sch`.`institucion` 
ADD CONSTRAINT `fk_institucion_2`
  FOREIGN KEY (`id_departamento`)
  REFERENCES `agogui_sch`.`departamento` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `agogui_sch`.`institucion` 
ADD INDEX `fk_institucion_3_idx` (`id_pais` ASC);
ALTER TABLE `agogui_sch`.`institucion` 
ADD CONSTRAINT `fk_institucion_3`
  FOREIGN KEY (`id_pais`)
  REFERENCES `agogui_sch`.`pais` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `agogui_sch`.`estudiante` 
DROP COLUMN `nacionalidad`;

ALTER TABLE `agogui_sch`.`estudiante` 
CHANGE COLUMN `estado` `estado` VARCHAR(20) NULL DEFAULT NULL ;

ALTER TABLE `agogui_sch`.`estudiante` 
ADD COLUMN `id_pais` INT NULL AFTER `foto`,
ADD COLUMN `id_departamento` INT NULL AFTER `id_pais`;

ALTER TABLE `agogui_sch`.`estudiante` 
ADD INDEX `fk_estudiante_3_idx` (`id_departamento` ASC),
ADD INDEX `fk_estudiante_4_idx` (`id_pais` ASC);
ALTER TABLE `agogui_sch`.`estudiante` 
ADD CONSTRAINT `fk_estudiante_3`
  FOREIGN KEY (`id_departamento`)
  REFERENCES `agogui_sch`.`departamento` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_estudiante_4`
  FOREIGN KEY (`id_pais`)
  REFERENCES `agogui_sch`.`pais` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;


ALTER TABLE `agogui_sch`.`periodo` 
DROP FOREIGN KEY `fk_periodo_1`;
ALTER TABLE `agogui_sch`.`periodo` 
DROP INDEX `fk_periodo_1_idx` ;

ALTER TABLE `agogui_sch`.`periodo` 
CHANGE COLUMN `id_grado` `codigo_institucion` INT(11) NOT NULL ,
ADD INDEX `fk_periodo_1_idx` (`codigo_institucion` ASC);
ALTER TABLE `agogui_sch`.`periodo` 
ADD CONSTRAINT `fk_periodo_1`
  FOREIGN KEY (`codigo_institucion`)
  REFERENCES `agogui_sch`.`institucion` (`codigo`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;


ALTER TABLE `agogui_sch`.`jornada` 
DROP FOREIGN KEY `fk_jornada_1`;
ALTER TABLE `agogui_sch`.`jornada` 
DROP INDEX `fk_jornada_1_idx` ;

ALTER TABLE `agogui_sch`.`jornada` 
CHANGE COLUMN `id_sede` `codigo_institucion` INT(11) NOT NULL ,
ADD INDEX `fk_jornada_1_idx` (`codigo_institucion` ASC);
ALTER TABLE `agogui_sch`.`jornada` 
ADD CONSTRAINT `fk_jornada_1`
  FOREIGN KEY (`codigo_institucion`)
  REFERENCES `agogui_sch`.`institucion` (`codigo`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `agogui_sch`.`estudiante` 
DROP FOREIGN KEY `fk_estudiante_2`;
ALTER TABLE `agogui_sch`.`estudiante` 
DROP INDEX `fk_estudiante_2_idx` ;

ALTER TABLE `agogui_sch`.`estudiante` 
CHANGE COLUMN `id_jornada` `codigo_institucion` INT(11) NOT NULL ,
ADD INDEX `fk_estudiante_2_idx` (`codigo_institucion` ASC);
ALTER TABLE `agogui_sch`.`estudiante` 
ADD CONSTRAINT `fk_estudiante_2`
  FOREIGN KEY (`codigo_institucion`)
  REFERENCES `agogui_sch`.`institucion` (`codigo`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `agogui_sch`.`curso` 
ADD COLUMN `id_sede` INT NOT NULL AFTER `id_grado`,
ADD INDEX `fk_curso_2_idx` (`id_sede` ASC);
ALTER TABLE `agogui_sch`.`curso` 
ADD CONSTRAINT `fk_curso_2`
  FOREIGN KEY (`id_sede`)
  REFERENCES `agogui_sch`.`sede` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;