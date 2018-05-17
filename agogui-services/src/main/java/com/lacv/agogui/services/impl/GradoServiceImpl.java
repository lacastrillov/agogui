/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lacv.agogui.services.impl;


import com.lacv.agogui.daos.GradoJpa;
import com.lacv.agogui.model.entities.Grado;
import com.lacv.agogui.model.mappers.GradoMapper;
import com.lacv.agogui.services.GradoService;
import com.lacv.jmagrexs.dao.GenericDao;
import com.lacv.jmagrexs.service.EntityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lcastrillo
 */
@Service("gradoService")
public class GradoServiceImpl extends EntityServiceImpl<Grado> implements GradoService {
    
    @Autowired
    public GradoJpa gradoJpa;
    
    @Autowired
    public GradoMapper gradoMapper;
    
    @Override
    public GenericDao getGenericDao(){
        return gradoJpa;
    }
    
}