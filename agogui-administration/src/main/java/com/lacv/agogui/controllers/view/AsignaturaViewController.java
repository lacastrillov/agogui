/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lacv.agogui.controllers.view;

import com.lacv.agogui.model.dtos.AsignaturaDto;
import com.lacv.agogui.model.mappers.AsignaturaMapper;
import com.lacv.agogui.services.AsignaturaService;
import com.lacv.jmagrexs.controller.view.ExtEntityController;
import com.lacv.jmagrexs.dto.MenuItem;
import com.lacv.jmagrexs.dto.config.EntityConfig;
import com.lacv.jmagrexs.modules.security.services.SecurityService;
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
@RequestMapping(value="/vista/asignatura")
public class AsignaturaViewController extends ExtEntityController {
    
    @Autowired
    AsignaturaService asignaturaService;
    
    @Autowired
    AsignaturaMapper asignaturaMapper;
    
    @Autowired
    SecurityService securityService;
    
    
    @PostConstruct
    public void init(){
        EntityConfig view= new EntityConfig("asignatura", asignaturaService, AsignaturaDto.class);
        view.setSingularEntityTitle("Asignatura");
        view.setPluralEntityTitle("Asignaturas");
        view.setMultipartFormData(false);
        view.setVisibleSeeAllButton(false);
        view.setDefaultOrder("id", "DESC");
        super.addControlMapping(view);
        
        MenuItem menuParent= new MenuItem("Entidades", 1);
        MenuItem menuItem= new MenuItem("asignatura", "Gestionar Asignaturas", 1);
        menuParent.addSubMenu(menuItem);
        menuComponent.addItemMenu(menuParent);
    }
    
    @Override
    public List<MenuItem> configureVisibilityMenu(List<MenuItem> menuData){
        return securityService.configureVisibilityMenu(menuData);
    }
    
}