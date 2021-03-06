/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lacv.agogui.controllers.view;

import com.lacv.agogui.model.dtos.EstudianteDto;
import com.lacv.agogui.model.dtos.process.ChangeUserStatusPDto;
import com.lacv.agogui.model.mappers.EstudianteMapper;
import com.lacv.agogui.services.EstudianteService;
import com.lacv.jmagrexs.controller.view.ExtEntityController;
import com.lacv.jmagrexs.dto.MenuItem;
import com.lacv.jmagrexs.dto.ProcessGlobalAction;
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
@RequestMapping(value="/vista/estudiante")
public class EstudianteViewController extends ExtEntityController {
    
    @Autowired
    EstudianteService estudianteService;
    
    @Autowired
    EstudianteMapper estudianteMapper;
    
    @Autowired
    SecurityService securityService;
    
    
    @PostConstruct
    public void init(){
        EntityConfig view= new EntityConfig("estudiante", estudianteService, EstudianteDto.class);
        view.setSingularEntityTitle("Estudiante");
        view.setPluralEntityTitle("Estudiantes");
        view.setMultipartFormData(true);
        view.setVisibleSeeAllButton(true);
        view.setDefaultOrder("nombre", "ASC");
        view.setNumColumnsForm(2);
        
        ProcessGlobalAction changeUserStatus= new ProcessGlobalAction();
        changeUserStatus.setMainProcessRef("processStudent");
        changeUserStatus.setProcessName("changeUserStatus");
        changeUserStatus.setProcessTitle("Cambiar Estado Estudiante");
        changeUserStatus.setDtoClass(ChangeUserStatusPDto.class);
        changeUserStatus.setIconUrl("/img/process_icons/settings.png");
        view.addProcessGlobalActions(changeUserStatus);
        
        super.addControlMapping(view);
        
        MenuItem menuParent= new MenuItem("Estudiantes", 5);
        MenuItem menuItem= new MenuItem("estudiante", "Gestionar Estudiantes", 1);
        menuParent.addSubMenu(menuItem);
        menuComponent.addItemMenu(menuParent);
    }
    
    @Override
    public List<MenuItem> configureVisibilityMenu(List<MenuItem> menuData){
        return securityService.configureVisibilityMenu(menuData);
    }
    
}