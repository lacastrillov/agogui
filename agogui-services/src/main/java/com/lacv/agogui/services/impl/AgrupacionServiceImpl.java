/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lacv.agogui.services.impl;


import com.lacv.agogui.daos.AgrupacionJpa;
import com.lacv.agogui.model.entities.Agrupacion;
import com.lacv.agogui.model.mappers.AgrupacionMapper;
import com.lacv.agogui.services.AgrupacionService;
import com.lacv.jmagrexs.dao.GenericDao;
import com.lacv.jmagrexs.mapper.EntityMapper;
import com.lacv.jmagrexs.service.EntityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lcastrillo
 */
@Service("agrupacionService")
public class AgrupacionServiceImpl extends EntityServiceImpl<Agrupacion> implements AgrupacionService {
    
    @Autowired
    public AgrupacionJpa agrupacionJpa;
    
    @Autowired
    public AgrupacionMapper agrupacionMapper;
    
    @Override
    public GenericDao getGenericDao(){
        return agrupacionJpa;
    }
    
    @Override
    public EntityMapper getEntityMapper(){
        return agrupacionMapper;
    }
    
}