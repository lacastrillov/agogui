/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lacv.agogui.services.impl;


import com.lacv.agogui.daos.TemaJpa;
import com.lacv.agogui.model.entities.Tema;
import com.lacv.agogui.model.mappers.TemaMapper;
import com.lacv.agogui.services.TemaService;
import com.lacv.jmagrexs.dao.GenericDao;
import com.lacv.jmagrexs.mapper.EntityMapper;
import com.lacv.jmagrexs.service.EntityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lcastrillo
 */
@Service("temaService")
public class TemaServiceImpl extends EntityServiceImpl<Tema> implements TemaService {
    
    @Autowired
    public TemaJpa temaJpa;
    
    @Autowired
    public TemaMapper temaMapper;
    
    @Override
    public GenericDao getGenericDao(){
        return temaJpa;
    }

    @Override
    public EntityMapper getEntityMapper() {
        return temaMapper;
    }
    
}