/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lacv.agogui.services.impl;


import com.lacv.agogui.daos.EstudianteJpa;
import com.lacv.agogui.model.entities.Estudiante;
import com.lacv.agogui.model.mappers.EstudianteMapper;
import com.lacv.agogui.services.EstudianteService;
import com.lacv.jmagrexs.dao.GenericDao;
import com.lacv.jmagrexs.mapper.EntityMapper;
import com.lacv.jmagrexs.service.EntityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lcastrillo
 */
@Service("estudianteService")
public class EstudianteServiceImpl extends EntityServiceImpl<Estudiante> implements EstudianteService {
    
    @Autowired
    public EstudianteJpa estudianteJpa;
    
    @Autowired
    public EstudianteMapper estudianteMapper;
    
    @Override
    public GenericDao getGenericDao(){
        return estudianteJpa;
    }

    @Override
    public EntityMapper getEntityMapper() {
        return estudianteMapper;
    }
    
}