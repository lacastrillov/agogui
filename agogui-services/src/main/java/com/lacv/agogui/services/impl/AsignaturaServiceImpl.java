/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lacv.agogui.services.impl;


import com.lacv.agogui.daos.AsignaturaJpa;
import com.lacv.agogui.model.entities.Asignatura;
import com.lacv.agogui.model.mappers.AsignaturaMapper;
import com.lacv.agogui.services.AsignaturaService;
import com.lacv.jmagrexs.dao.GenericDao;
import com.lacv.jmagrexs.service.EntityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lcastrillo
 */
@Service("asignaturaService")
public class AsignaturaServiceImpl extends EntityServiceImpl<Asignatura> implements AsignaturaService {
    
    @Autowired
    public AsignaturaJpa asignaturaJpa;
    
    @Autowired
    public AsignaturaMapper asignaturaMapper;
    
    @Override
    public GenericDao getGenericDao(){
        return asignaturaJpa;
    }
    
}