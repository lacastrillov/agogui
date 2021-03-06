/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lacv.agogui.controllers.view;

import com.lacv.agogui.model.dtos.InstitucionDto;
import com.lacv.agogui.model.mappers.InstitucionMapper;
import com.lacv.agogui.services.InstitucionService;
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
@RequestMapping(value="/vista/institucion")
public class InstitucionViewController extends ExtEntityController {
    
    @Autowired
    InstitucionService institucionService;
    
    @Autowired
    InstitucionMapper institucionMapper;
    
    @Autowired
    SecurityService securityService;
    
    
    @PostConstruct
    public void init(){
        EntityConfig view= new EntityConfig("institucion", institucionService, InstitucionDto.class);
        view.setSingularEntityTitle("Instituci&oacute;n");
        view.setPluralEntityTitle("Instituciones");
        view.setMultipartFormData(false);
        view.setVisibleSeeAllButton(false);
        view.setLabelPlusId(true);
        view.setDefaultOrder("nombre", "ASC");
        super.addControlMapping(view);
        
        MenuItem menuParent= new MenuItem("Instituci&oacute;n", 2);
        MenuItem menuItem= new MenuItem("institucion", "Gestionar Instituciones", 1);
        menuParent.addSubMenu(menuItem);
        menuComponent.addItemMenu(menuParent);
    }
    
    @Override
    public List<MenuItem> configureVisibilityMenu(List<MenuItem> menuData){
        return securityService.configureVisibilityMenu(menuData);
    }
    
}