/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lacv.agogui.controllers.view;

import com.lacv.agogui.model.dtos.NotaEvaluacionDto;
import com.lacv.agogui.model.mappers.NotaEvaluacionMapper;
import com.lacv.agogui.services.NotaEvaluacionService;
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
@RequestMapping(value="/vista/notaEvaluacion")
public class NotaEvaluacionViewController extends ExtEntityController {
    
    @Autowired
    NotaEvaluacionService notaEvaluacionService;
    
    @Autowired
    NotaEvaluacionMapper notaEvaluacionMapper;
    
    @Autowired
    SecurityService securityService;
    
    
    @PostConstruct
    public void init(){
        EntityConfig view= new EntityConfig("notaEvaluacion", notaEvaluacionService, NotaEvaluacionDto.class);
        view.setSingularEntityTitle("Nota Evaluaci&oacute;n");
        view.setPluralEntityTitle("Notas Evaluaciones");
        view.setMultipartFormData(false);
        view.setVisibleSeeAllButton(false);
        view.setDefaultOrder("id", "DESC");
        super.addControlMapping(view);
        
        MenuItem menuParent= new MenuItem("Estudiantes");
        MenuItem menuItem= new MenuItem("notaEvaluacion", "Gestionar Notas Evaluaciones", 2);
        menuParent.addSubMenu(menuItem);
        menuComponent.addItemMenu(menuParent);
    }
    
    @Override
    public List<MenuItem> configureVisibilityMenu(List<MenuItem> menuData){
        return securityService.configureVisibilityMenu(menuData);
    }
    
}