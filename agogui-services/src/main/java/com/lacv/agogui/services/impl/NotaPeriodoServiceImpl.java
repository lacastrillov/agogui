/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lacv.agogui.services.impl;


import com.lacv.agogui.daos.NotaPeriodoJpa;
import com.lacv.agogui.model.entities.NotaPeriodo;
import com.lacv.agogui.model.mappers.NotaPeriodoMapper;
import com.lacv.agogui.services.NotaPeriodoService;
import com.lacv.jmagrexs.dao.GenericDao;
import com.lacv.jmagrexs.mapper.EntityMapper;
import com.lacv.jmagrexs.service.EntityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lcastrillo
 */
@Service("notaPeriodoService")
public class NotaPeriodoServiceImpl extends EntityServiceImpl<NotaPeriodo> implements NotaPeriodoService {
    
    @Autowired
    public NotaPeriodoJpa notaPeriodoJpa;
    
    @Autowired
    public NotaPeriodoMapper notaPeriodoMapper;
    
    @Override
    public GenericDao getGenericDao(){
        return notaPeriodoJpa;
    }

    @Override
    public EntityMapper getEntityMapper() {
        return notaPeriodoMapper;
    }
    
}