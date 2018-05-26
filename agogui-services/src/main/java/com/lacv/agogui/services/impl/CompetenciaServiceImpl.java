/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lacv.agogui.services.impl;


import com.lacv.agogui.daos.CompetenciaJpa;
import com.lacv.agogui.model.entities.Competencia;
import com.lacv.agogui.model.mappers.CompetenciaMapper;
import com.lacv.agogui.services.CompetenciaService;
import com.lacv.jmagrexs.dao.GenericDao;
import com.lacv.jmagrexs.mapper.EntityMapper;
import com.lacv.jmagrexs.service.EntityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lcastrillo
 */
@Service("competenciaService")
public class CompetenciaServiceImpl extends EntityServiceImpl<Competencia> implements CompetenciaService {
    
    @Autowired
    public CompetenciaJpa competenciaJpa;
    
    @Autowired
    public CompetenciaMapper competenciaMapper;
    
    @Override
    public GenericDao getGenericDao(){
        return competenciaJpa;
    }

    @Override
    public EntityMapper getEntityMapper() {
        return competenciaMapper;
    }
    
}