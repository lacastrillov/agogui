/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lacv.agogui.services.impl;


import com.lacv.agogui.daos.NotaFinalJpa;
import com.lacv.agogui.model.entities.NotaFinal;
import com.lacv.agogui.model.mappers.NotaFinalMapper;
import com.lacv.agogui.services.NotaFinalService;
import com.lacv.jmagrexs.dao.GenericDao;
import com.lacv.jmagrexs.mapper.EntityMapper;
import com.lacv.jmagrexs.service.EntityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lcastrillo
 */
@Service("notaFinalService")
public class NotaFinalServiceImpl extends EntityServiceImpl<NotaFinal> implements NotaFinalService {
    
    @Autowired
    public NotaFinalJpa notaFinalJpa;
    
    @Autowired
    public NotaFinalMapper notaFinalMapper;
    
    @Override
    public GenericDao getGenericDao(){
        return notaFinalJpa;
    }

    @Override
    public EntityMapper getEntityMapper() {
        return notaFinalMapper;
    }
    
}