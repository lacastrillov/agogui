/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lacv.agogui.services.impl;


import com.lacv.agogui.daos.InstitucionUserJpa;
import com.lacv.agogui.model.entities.InstitucionUser;
import com.lacv.agogui.model.mappers.InstitucionUserMapper;
import com.lacv.agogui.services.InstitucionUserService;
import com.lacv.jmagrexs.dao.GenericDao;
import com.lacv.jmagrexs.service.EntityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lcastrillo
 */
@Service("institucionUserService")
public class InstitucionUserServiceImpl extends EntityServiceImpl<InstitucionUser> implements InstitucionUserService {
    
    @Autowired
    public InstitucionUserJpa institucionUserJpa;
    
    @Autowired
    public InstitucionUserMapper institucionUserMapper;
    
    @Override
    public GenericDao getGenericDao(){
        return institucionUserJpa;
    }
    
}