/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  lacastrillov
 * Created: 8/02/2020
 */

ALTER TABLE `sys_db_operation` 
DROP COLUMN `duration`,
DROP COLUMN `data_in`,
CHANGE COLUMN `data_out` `data_new` LONGTEXT NULL DEFAULT NULL ,
CHANGE COLUMN `status` `success` TINYINT(1) NULL DEFAULT NULL ;

ALTER TABLE `sys_massive_operation` 
DROP COLUMN `source_file`;
