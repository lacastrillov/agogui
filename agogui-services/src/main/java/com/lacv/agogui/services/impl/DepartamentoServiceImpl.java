/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lacv.agogui.services.impl;


import com.lacv.agogui.daos.DepartamentoJpa;
import com.lacv.agogui.model.entities.Departamento;
import com.lacv.agogui.model.mappers.DepartamentoMapper;
import com.lacv.agogui.services.DepartamentoService;
import com.lacv.jmagrexs.dao.GenericDao;
import com.lacv.jmagrexs.mapper.EntityMapper;
import com.lacv.jmagrexs.service.EntityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lcastrillo
 */
@Service("departamentoService")
public class DepartamentoServiceImpl extends EntityServiceImpl<Departamento> implements DepartamentoService {
    
    @Autowired
    public DepartamentoJpa departamentoJpa;
    
    @Autowired
    public DepartamentoMapper departamentoMapper;
    
    @Override
    public GenericDao getGenericDao(){
        return departamentoJpa;
    }

    @Override
    public EntityMapper getEntityMapper() {
        return departamentoMapper;
    }
    
}