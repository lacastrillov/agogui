/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lacv.agogui.services.impl;


import com.lacv.agogui.daos.InstitucionJpa;
import com.lacv.agogui.model.entities.Institucion;
import com.lacv.agogui.model.mappers.InstitucionMapper;
import com.lacv.agogui.services.InstitucionService;
import com.lacv.jmagrexs.dao.GenericDao;
import com.lacv.jmagrexs.service.EntityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lcastrillo
 */
@Service("institucionService")
public class InstitucionServiceImpl extends EntityServiceImpl<Institucion> implements InstitucionService {
    
    @Autowired
    public InstitucionJpa institucionJpa;
    
    @Autowired
    public InstitucionMapper institucionMapper;
    
    @Override
    public GenericDao getGenericDao(){
        return institucionJpa;
    }
    
}