/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lacv.agogui.controllers.view;

import com.lacv.agogui.model.dtos.EvaluacionDto;
import com.lacv.agogui.model.mappers.EvaluacionMapper;
import com.lacv.agogui.services.EvaluacionService;
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
@RequestMapping(value="/vista/evaluacion")
public class EvaluacionViewController extends ExtEntityController {
    
    @Autowired
    EvaluacionService evaluacionService;
    
    @Autowired
    EvaluacionMapper evaluacionMapper;
    
    @Autowired
    SecurityService securityService;
    
    
    @PostConstruct
    public void init(){
        EntityConfig view= new EntityConfig("evaluacion", evaluacionService, EvaluacionDto.class);
        view.setSingularEntityTitle("Evaluaci&oacute;n");
        view.setPluralEntityTitle("Evaluaciones");
        view.setMultipartFormData(false);
        view.setVisibleSeeAllButton(false);
        view.setDefaultOrder("fecha", "DESC");
        super.addControlMapping(view);
        
        MenuItem menuParent= new MenuItem("Docentes");
        MenuItem menuItem= new MenuItem("evaluacion", "Gestionar Evaluaciones", 4);
        menuParent.addSubMenu(menuItem);
        menuComponent.addItemMenu(menuParent);
    }
    
    @Override
    public List<MenuItem> configureVisibilityMenu(List<MenuItem> menuData){
        return securityService.configureVisibilityMenu(menuData);
    }
    
}