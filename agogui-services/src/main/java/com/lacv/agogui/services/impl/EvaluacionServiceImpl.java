/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lacv.agogui.services.impl;


import com.lacv.agogui.daos.EvaluacionJpa;
import com.lacv.agogui.model.entities.Evaluacion;
import com.lacv.agogui.model.mappers.EvaluacionMapper;
import com.lacv.agogui.services.EvaluacionService;
import com.lacv.jmagrexs.dao.GenericDao;
import com.lacv.jmagrexs.service.EntityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lcastrillo
 */
@Service("evaluacionService")
public class EvaluacionServiceImpl extends EntityServiceImpl<Evaluacion> implements EvaluacionService {
    
    @Autowired
    public EvaluacionJpa evaluacionJpa;
    
    @Autowired
    public EvaluacionMapper evaluacionMapper;
    
    @Override
    public GenericDao getGenericDao(){
        return evaluacionJpa;
    }
    
}