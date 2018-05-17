/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lacv.agogui.services.impl;


import com.lacv.agogui.daos.AreaJpa;
import com.lacv.agogui.model.entities.Area;
import com.lacv.agogui.model.mappers.AreaMapper;
import com.lacv.agogui.services.AreaService;
import com.lacv.jmagrexs.dao.GenericDao;
import com.lacv.jmagrexs.service.EntityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lcastrillo
 */
@Service("areaService")
public class AreaServiceImpl extends EntityServiceImpl<Area> implements AreaService {
    
    @Autowired
    public AreaJpa areaJpa;
    
    @Autowired
    public AreaMapper areaMapper;
    
    @Override
    public GenericDao getGenericDao(){
        return areaJpa;
    }
    
}