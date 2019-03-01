/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lacv.agogui.controllers.view;

import com.lacv.agogui.model.dtos.AreaDto;
import com.lacv.agogui.model.entities.Asignatura;
import com.lacv.agogui.model.mappers.AreaMapper;
import com.lacv.agogui.services.AreaService;
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
@RequestMapping(value="/vista/area")
public class AreaViewController extends ExtEntityController {
    
    @Autowired
    AreaService areaService;
    
    @Autowired
    AreaMapper areaMapper;
    
    @Autowired
    SecurityService securityService;
    
    
    @PostConstruct
    public void init(){
        EntityConfig view= new EntityConfig("area", areaService, AreaDto.class);
        view.setSingularEntityTitle("Area");
        view.setPluralEntityTitle("Areas");
        view.setMultipartFormData(false);
        view.setVisibleSeeAllButton(false);
        view.setDefaultOrder("nombre", "ASC");
        
        view.addChildExtView("asignatura", Asignatura.class, EntityConfig.TCV_1_TO_N);
        
        super.addControlMapping(view);
        
        MenuItem menuParent= new MenuItem("Asignaturas");
        MenuItem menuItem= new MenuItem("area", "Gestionar Areas", 1);
        menuParent.addSubMenu(menuItem);
        menuComponent.addItemMenu(menuParent);
    }
    
    @Override
    public List<MenuItem> configureVisibilityMenu(List<MenuItem> menuData){
        return securityService.configureVisibilityMenu(menuData);
    }
    
}