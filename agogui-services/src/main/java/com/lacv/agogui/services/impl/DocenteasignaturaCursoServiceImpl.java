/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lacv.agogui.services.impl;


import com.lacv.agogui.daos.DocenteasignaturaCursoJpa;
import com.lacv.agogui.model.entities.DocenteasignaturaCurso;
import com.lacv.agogui.model.mappers.DocenteasignaturaCursoMapper;
import com.lacv.agogui.services.DocenteasignaturaCursoService;
import com.lacv.jmagrexs.dao.GenericDao;
import com.lacv.jmagrexs.service.EntityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lcastrillo
 */
@Service("docenteasignaturaCursoService")
public class DocenteasignaturaCursoServiceImpl extends EntityServiceImpl<DocenteasignaturaCurso> implements DocenteasignaturaCursoService {
    
    @Autowired
    public DocenteasignaturaCursoJpa docenteasignaturaCursoJpa;
    
    @Autowired
    public DocenteasignaturaCursoMapper docenteasignaturaCursoMapper;
    
    @Override
    public GenericDao getGenericDao(){
        return docenteasignaturaCursoJpa;
    }
    
}