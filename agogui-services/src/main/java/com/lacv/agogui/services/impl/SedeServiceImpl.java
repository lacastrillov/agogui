/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lacv.agogui.services.impl;


import com.lacv.agogui.daos.SedeJpa;
import com.lacv.agogui.model.entities.Sede;
import com.lacv.agogui.model.mappers.SedeMapper;
import com.lacv.agogui.services.SedeService;
import com.lacv.jmagrexs.dao.GenericDao;
import com.lacv.jmagrexs.service.EntityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lcastrillo
 */
@Service("sedeService")
public class SedeServiceImpl extends EntityServiceImpl<Sede> implements SedeService {
    
    @Autowired
    public SedeJpa sedeJpa;
    
    @Autowired
    public SedeMapper sedeMapper;
    
    @Override
    public GenericDao getGenericDao(){
        return sedeJpa;
    }
    
}