/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lacv.agogui.controllers.view;

import com.lacv.agogui.model.dtos.TemaDto;
import com.lacv.agogui.model.mappers.TemaMapper;
import com.lacv.agogui.services.TemaService;
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
@RequestMapping(value="/vista/tema")
public class TemaViewController extends ExtEntityController {
    
    @Autowired
    TemaService temaService;
    
    @Autowired
    TemaMapper temaMapper;
    
    @Autowired
    SecurityService securityService;
    
    
    @PostConstruct
    public void init(){
        EntityConfig view= new EntityConfig("tema", temaService, TemaDto.class);
        view.setSingularEntityTitle("Tema");
        view.setPluralEntityTitle("Temas");
        view.setMultipartFormData(false);
        view.setVisibleSeeAllButton(false);
        view.setDefaultOrder("titulo", "ASC");
        super.addControlMapping(view);
        
        MenuItem menuParent= new MenuItem("Asignaturas");
        MenuItem menuItem= new MenuItem("tema", "Gestionar Temas", 2);
        menuParent.addSubMenu(menuItem);
        menuComponent.addItemMenu(menuParent);
    }
    
    @Override
    public List<MenuItem> configureVisibilityMenu(List<MenuItem> menuData){
        return securityService.configureVisibilityMenu(menuData);
    }
    
}