/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lacv.agogui.controllers.view;

import com.lacv.agogui.model.dtos.NotaPeriodoDto;
import com.lacv.agogui.model.mappers.NotaPeriodoMapper;
import com.lacv.agogui.services.NotaPeriodoService;
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
@RequestMapping(value="/vista/notaPeriodo")
public class NotaPeriodoViewController extends ExtEntityController {
    
    @Autowired
    NotaPeriodoService notaPeriodoService;
    
    @Autowired
    NotaPeriodoMapper notaPeriodoMapper;
    
    @Autowired
    SecurityService securityService;
    
    
    @PostConstruct
    public void init(){
        EntityConfig view= new EntityConfig("notaPeriodo", notaPeriodoService, NotaPeriodoDto.class);
        view.setSingularEntityTitle("Nota Periodo");
        view.setPluralEntityTitle("Notas Periodos");
        view.setMultipartFormData(false);
        view.setVisibleSeeAllButton(false);
        view.setDefaultOrder("id", "DESC");
        super.addControlMapping(view);
        
        MenuItem menuParent= new MenuItem("Estudiantes");
        MenuItem menuItem= new MenuItem("notaPeriodo", "Gestionar Notas Periodos", 4);
        menuParent.addSubMenu(menuItem);
        menuComponent.addItemMenu(menuParent);
    }
    
    @Override
    public List<MenuItem> configureVisibilityMenu(List<MenuItem> menuData){
        return securityService.configureVisibilityMenu(menuData);
    }
    
}