/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lacv.agogui.services.impl;


import com.lacv.agogui.daos.DocenteJpa;
import com.lacv.agogui.model.entities.Docente;
import com.lacv.agogui.model.mappers.DocenteMapper;
import com.lacv.agogui.services.DocenteService;
import com.lacv.jmagrexs.dao.GenericDao;
import com.lacv.jmagrexs.service.EntityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lcastrillo
 */
@Service("docenteService")
public class DocenteServiceImpl extends EntityServiceImpl<Docente> implements DocenteService {
    
    @Autowired
    public DocenteJpa docenteJpa;
    
    @Autowired
    public DocenteMapper docenteMapper;
    
    @Override
    public GenericDao getGenericDao(){
        return docenteJpa;
    }
    
}