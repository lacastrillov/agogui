/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lacv.agogui.controllers.view;

import com.lacv.agogui.model.dtos.CiudadOMunicipioDto;
import com.lacv.agogui.model.mappers.CiudadOMunicipioMapper;
import com.lacv.agogui.services.CiudadOMunicipioService;
import com.lacv.jmagrexs.controller.view.ExtEntityController;
import com.lacv.jmagrexs.dto.MenuItem;
import com.lacv.jmagrexs.dto.config.EntityConfig;
import com.lacv.jmagrexs.modules.security.services.bussiness.SecurityService;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author lacastrillov
 */
@Controller
@RequestMapping(value="/vista/ciudadOMunicipio")
public class CiudadOMunicipioViewController extends ExtEntityController {
    
    @Autowired
    CiudadOMunicipioService ciudadOMunicipioService;
    
    @Autowired
    CiudadOMunicipioMapper ciudadOMunicipioMapper;
    
    @Autowired
    SecurityService securityService;
    
    
    @PostConstruct
    public void init(){
        EntityConfig view= new EntityConfig("ciudadOMunicipio", ciudadOMunicipioService, CiudadOMunicipioDto.class);
        view.setSingularEntityTitle("Ciudad o Municipio");
        view.setPluralEntityTitle("Ciudades o Municipios");
        view.setMultipartFormData(false);
        view.setVisibleSeeAllButton(false);
        view.setDefaultOrder("nombre", "ASC");
        super.addControlMapping(view);
        
        MenuItem menuParent= new MenuItem("Sistema");
        MenuItem menuParent1= new MenuItem("Ubicaci&oacute;n", 5);
        MenuItem menuItem= new MenuItem("ciudadOMunicipio", "Gestionar Ciudades o Municipios", 3);
        menuParent1.addSubMenu(menuItem);
        menuParent.addSubMenu(menuParent1);
        menuComponent.addItemMenu(menuParent);
    }
    
    @Override
    public List<MenuItem> configureVisibilityMenu(List<MenuItem> menuData){
        return securityService.configureVisibilityMenu(menuData);
    }
    
}