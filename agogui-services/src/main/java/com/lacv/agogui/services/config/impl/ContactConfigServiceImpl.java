/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lacv.agogui.services.config.impl;

import com.lacv.agogui.model.dtos.config.ContactConfigDto;
import com.lacv.agogui.services.config.ContactConfigService;
import com.lacv.jmagrexs.dao.GenericDao;
import com.lacv.jmagrexs.modules.common.daos.JsonObjectJpa;
import com.lacv.jmagrexs.service.ConfigurationObjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lacastrillov
 */
@Service
public class ContactConfigServiceImpl extends ConfigurationObjectServiceImpl<ContactConfigDto> implements ContactConfigService {
    
    @Autowired
    JsonObjectJpa jsonObjectDao;
    
    @Override
    public GenericDao getJsonObjectDao() {
        return jsonObjectDao;
    }
    
}
