/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lacv.agogui.controllers.view;

import com.lacv.agogui.model.dtos.DepartamentoDto;
import com.lacv.agogui.model.mappers.DepartamentoMapper;
import com.lacv.agogui.services.DepartamentoService;
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
@RequestMapping(value="/vista/departamento")
public class DepartamentoViewController extends ExtEntityController {
    
    @Autowired
    DepartamentoService departamentoService;
    
    @Autowired
    DepartamentoMapper departamentoMapper;
    
    @Autowired
    SecurityService securityService;
    
    
    @PostConstruct
    public void init(){
        EntityConfig view= new EntityConfig("departamento", departamentoService, DepartamentoDto.class);
        view.setSingularEntityTitle("Departamento");
        view.setPluralEntityTitle("Departamentos");
        view.setMultipartFormData(false);
        view.setVisibleSeeAllButton(false);
        view.setDefaultOrder("id", "DESC");
        super.addControlMapping(view);
        
        MenuItem menuParent= new MenuItem("Entidades", 1);
        MenuItem menuItem= new MenuItem("departamento", "Gestionar Departamentos", 1);
        menuParent.addSubMenu(menuItem);
        menuComponent.addItemMenu(menuParent);
    }
    
    @Override
    public List<MenuItem> configureVisibilityMenu(List<MenuItem> menuData){
        return securityService.configureVisibilityMenu(menuData);
    }
    
}