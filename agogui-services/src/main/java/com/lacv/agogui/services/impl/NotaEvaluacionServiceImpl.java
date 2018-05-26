/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lacv.agogui.services.impl;


import com.lacv.agogui.daos.NotaEvaluacionJpa;
import com.lacv.agogui.model.entities.NotaEvaluacion;
import com.lacv.agogui.model.mappers.NotaEvaluacionMapper;
import com.lacv.agogui.services.NotaEvaluacionService;
import com.lacv.jmagrexs.dao.GenericDao;
import com.lacv.jmagrexs.mapper.EntityMapper;
import com.lacv.jmagrexs.service.EntityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lcastrillo
 */
@Service("notaEvaluacionService")
public class NotaEvaluacionServiceImpl extends EntityServiceImpl<NotaEvaluacion> implements NotaEvaluacionService {
    
    @Autowired
    public NotaEvaluacionJpa notaEvaluacionJpa;
    
    @Autowired
    public NotaEvaluacionMapper notaEvaluacionMapper;
    
    @Override
    public GenericDao getGenericDao(){
        return notaEvaluacionJpa;
    }

    @Override
    public EntityMapper getEntityMapper() {
        return notaEvaluacionMapper;
    }
    
}