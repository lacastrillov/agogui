/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lacv.agogui.services.impl;


import com.lacv.agogui.daos.JornadaJpa;
import com.lacv.agogui.model.entities.Jornada;
import com.lacv.agogui.model.mappers.JornadaMapper;
import com.lacv.agogui.services.JornadaService;
import com.lacv.jmagrexs.dao.GenericDao;
import com.lacv.jmagrexs.service.EntityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lcastrillo
 */
@Service("jornadaService")
public class JornadaServiceImpl extends EntityServiceImpl<Jornada> implements JornadaService {
    
    @Autowired
    public JornadaJpa jornadaJpa;
    
    @Autowired
    public JornadaMapper jornadaMapper;
    
    @Override
    public GenericDao getGenericDao(){
        return jornadaJpa;
    }
    
}