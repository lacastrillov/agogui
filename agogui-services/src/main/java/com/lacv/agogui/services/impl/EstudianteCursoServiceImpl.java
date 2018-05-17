/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lacv.agogui.services.impl;


import com.lacv.agogui.daos.EstudianteCursoJpa;
import com.lacv.agogui.model.entities.EstudianteCurso;
import com.lacv.agogui.model.mappers.EstudianteCursoMapper;
import com.lacv.agogui.services.EstudianteCursoService;
import com.lacv.jmagrexs.dao.GenericDao;
import com.lacv.jmagrexs.service.EntityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lcastrillo
 */
@Service("estudianteCursoService")
public class EstudianteCursoServiceImpl extends EntityServiceImpl<EstudianteCurso> implements EstudianteCursoService {
    
    @Autowired
    public EstudianteCursoJpa estudianteCursoJpa;
    
    @Autowired
    public EstudianteCursoMapper estudianteCursoMapper;
    
    @Override
    public GenericDao getGenericDao(){
        return estudianteCursoJpa;
    }
    
}