/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lacv.agogui.services.impl;


import com.lacv.agogui.daos.CursoJpa;
import com.lacv.agogui.model.entities.Curso;
import com.lacv.agogui.model.mappers.CursoMapper;
import com.lacv.agogui.services.CursoService;
import com.lacv.jmagrexs.dao.GenericDao;
import com.lacv.jmagrexs.mapper.EntityMapper;
import com.lacv.jmagrexs.service.EntityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lcastrillo
 */
@Service("cursoService")
public class CursoServiceImpl extends EntityServiceImpl<Curso> implements CursoService {
    
    @Autowired
    public CursoJpa cursoJpa;
    
    @Autowired
    public CursoMapper cursoMapper;
    
    @Override
    public GenericDao getGenericDao(){
        return cursoJpa;
    }

    @Override
    public EntityMapper getEntityMapper() {
        return cursoMapper;
    }
    
}