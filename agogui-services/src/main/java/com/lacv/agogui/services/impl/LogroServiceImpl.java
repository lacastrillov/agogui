/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lacv.agogui.services.impl;


import com.lacv.agogui.daos.LogroJpa;
import com.lacv.agogui.model.entities.Logro;
import com.lacv.agogui.model.mappers.LogroMapper;
import com.lacv.agogui.services.LogroService;
import com.lacv.jmagrexs.dao.GenericDao;
import com.lacv.jmagrexs.service.EntityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lcastrillo
 */
@Service("logroService")
public class LogroServiceImpl extends EntityServiceImpl<Logro> implements LogroService {
    
    @Autowired
    public LogroJpa logroJpa;
    
    @Autowired
    public LogroMapper logroMapper;
    
    @Override
    public GenericDao getGenericDao(){
        return logroJpa;
    }
    
}