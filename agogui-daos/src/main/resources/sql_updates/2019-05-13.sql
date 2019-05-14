/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  e11001a
 * Created: 13/05/2019
 */

ALTER TABLE `agogui_sch`.`table_column` 
ADD COLUMN `unique` TINYINT(1) NULL DEFAULT '0' AFTER `not_null`;