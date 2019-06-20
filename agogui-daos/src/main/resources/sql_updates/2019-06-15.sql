/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  lacastrillov
 * Created: 15/06/2019
 */

ALTER TABLE `marketplatform`.`web_file` 
ADD COLUMN `user_id` INT NULL AFTER `parent_id`;