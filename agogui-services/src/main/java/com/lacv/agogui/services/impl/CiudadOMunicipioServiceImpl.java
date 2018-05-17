/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lacv.agogui.services.impl;


import com.lacv.agogui.daos.CiudadOMunicipioJpa;
import com.lacv.agogui.model.entities.CiudadOMunicipio;
import com.lacv.agogui.model.mappers.CiudadOMunicipioMapper;
import com.lacv.agogui.services.CiudadOMunicipioService;
import com.lacv.jmagrexs.dao.GenericDao;
import com.lacv.jmagrexs.service.EntityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lcastrillo
 */
@Service("ciudadOMunicipioService")
public class CiudadOMunicipioServiceImpl extends EntityServiceImpl<CiudadOMunicipio> implements CiudadOMunicipioService {
    
    @Autowired
    public CiudadOMunicipioJpa ciudadOMunicipioJpa;
    
    @Autowired
    public CiudadOMunicipioMapper ciudadOMunicipioMapper;
    
    @Override
    public GenericDao getGenericDao(){
        return ciudadOMunicipioJpa;
    }
    
}