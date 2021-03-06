/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lacv.agogui.controllers.view;

import com.lacv.agogui.model.dtos.DocenteDto;
import com.lacv.agogui.model.entities.DocenteAsignatura;
import com.lacv.agogui.model.entities.DocenteasignaturaCurso;
import com.lacv.agogui.model.mappers.DocenteMapper;
import com.lacv.agogui.services.DocenteService;
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
@RequestMapping(value="/vista/docente")
public class DocenteViewController extends ExtEntityController {
    
    @Autowired
    DocenteService docenteService;
    
    @Autowired
    DocenteMapper docenteMapper;
    
    @Autowired
    SecurityService securityService;
    
    
    @PostConstruct
    public void init(){
        EntityConfig view= new EntityConfig("docente", docenteService, DocenteDto.class);
        view.setSingularEntityTitle("Docente");
        view.setPluralEntityTitle("Docentes");
        view.setMultipartFormData(false);
        view.setVisibleSeeAllButton(false);
        view.setDefaultOrder("nombre", "ASC");
        view.setNumColumnsForm(2);
        
        view.addChildExtView("docenteAsignatura", DocenteAsignatura.class, EntityConfig.TCV_1_TO_N);
        view.addChildExtView("docenteasignaturaCurso", DocenteasignaturaCurso.class, EntityConfig.TCV_1_TO_N);
        
        super.addControlMapping(view);
        
        MenuItem menuParent= new MenuItem("Docentes", 4);
        MenuItem menuItem= new MenuItem("docente", "Gestionar Docentes", 1);
        menuParent.addSubMenu(menuItem);
        menuComponent.addItemMenu(menuParent);
    }
    
    @Override
    public List<MenuItem> configureVisibilityMenu(List<MenuItem> menuData){
        return securityService.configureVisibilityMenu(menuData);
    }
    
}