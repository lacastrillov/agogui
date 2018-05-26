/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lacv.agogui.services.impl;


import com.lacv.agogui.daos.PaisJpa;
import com.lacv.agogui.model.entities.Pais;
import com.lacv.agogui.model.mappers.PaisMapper;
import com.lacv.agogui.services.PaisService;
import com.lacv.jmagrexs.dao.GenericDao;
import com.lacv.jmagrexs.mapper.EntityMapper;
import com.lacv.jmagrexs.service.EntityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lcastrillo
 */
@Service("paisService")
public class PaisServiceImpl extends EntityServiceImpl<Pais> implements PaisService {
    
    @Autowired
    public PaisJpa paisJpa;
    
    @Autowired
    public PaisMapper paisMapper;
    
    @Override
    public GenericDao getGenericDao(){
        return paisJpa;
    }

    @Override
    public EntityMapper getEntityMapper() {
        return paisMapper;
    }
    
}