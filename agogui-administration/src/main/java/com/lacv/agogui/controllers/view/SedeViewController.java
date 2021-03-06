/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lacv.agogui.controllers.view;

import com.lacv.agogui.model.dtos.SedeDto;
import com.lacv.agogui.model.mappers.SedeMapper;
import com.lacv.agogui.services.SedeService;
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
@RequestMapping(value="/vista/sede")
public class SedeViewController extends ExtEntityController {
    
    @Autowired
    SedeService sedeService;
    
    @Autowired
    SedeMapper sedeMapper;
    
    @Autowired
    SecurityService securityService;
    
    
    @PostConstruct
    public void init(){
        EntityConfig view= new EntityConfig("sede", sedeService, SedeDto.class);
        view.setSingularEntityTitle("Sede");
        view.setPluralEntityTitle("Sedes");
        view.setMultipartFormData(false);
        view.setVisibleSeeAllButton(false);
        view.setDefaultOrder("nombre", "ASC");
        super.addControlMapping(view);
        
        MenuItem menuParent= new MenuItem("Instituci&oacute;n");
        MenuItem menuItem= new MenuItem("sede", "Gestionar Sedes", 2);
        menuParent.addSubMenu(menuItem);
        menuComponent.addItemMenu(menuParent);
    }
    
    @Override
    public List<MenuItem> configureVisibilityMenu(List<MenuItem> menuData){
        return securityService.configureVisibilityMenu(menuData);
    }
    
}