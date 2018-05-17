/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lacv.agogui.services.impl;


import com.lacv.agogui.daos.PeriodoJpa;
import com.lacv.agogui.model.entities.Periodo;
import com.lacv.agogui.model.mappers.PeriodoMapper;
import com.lacv.agogui.services.PeriodoService;
import com.lacv.jmagrexs.dao.GenericDao;
import com.lacv.jmagrexs.service.EntityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lcastrillo
 */
@Service("periodoService")
public class PeriodoServiceImpl extends EntityServiceImpl<Periodo> implements PeriodoService {
    
    @Autowired
    public PeriodoJpa periodoJpa;
    
    @Autowired
    public PeriodoMapper periodoMapper;
    
    @Override
    public GenericDao getGenericDao(){
        return periodoJpa;
    }
    
}