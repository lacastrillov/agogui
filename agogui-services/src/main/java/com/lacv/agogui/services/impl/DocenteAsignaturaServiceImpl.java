/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lacv.agogui.services.impl;


import com.lacv.agogui.daos.DocenteAsignaturaJpa;
import com.lacv.agogui.model.entities.DocenteAsignatura;
import com.lacv.agogui.model.mappers.DocenteAsignaturaMapper;
import com.lacv.agogui.services.DocenteAsignaturaService;
import com.lacv.jmagrexs.dao.GenericDao;
import com.lacv.jmagrexs.service.EntityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lcastrillo
 */
@Service("docenteAsignaturaService")
public class DocenteAsignaturaServiceImpl extends EntityServiceImpl<DocenteAsignatura> implements DocenteAsignaturaService {
    
    @Autowired
    public DocenteAsignaturaJpa docenteAsignaturaJpa;
    
    @Autowired
    public DocenteAsignaturaMapper docenteAsignaturaMapper;
    
    @Override
    public GenericDao getGenericDao(){
        return docenteAsignaturaJpa;
    }
    
}