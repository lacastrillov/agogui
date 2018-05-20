/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lacv.agogui.controllers.view;

import com.lacv.agogui.model.dtos.EstudianteCursoDto;
import com.lacv.agogui.model.mappers.EstudianteCursoMapper;
import com.lacv.agogui.services.EstudianteCursoService;
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
@RequestMapping(value="/vista/estudianteCurso")
public class EstudianteCursoViewController extends ExtEntityController {
    
    @Autowired
    EstudianteCursoService estudianteCursoService;
    
    @Autowired
    EstudianteCursoMapper estudianteCursoMapper;
    
    @Autowired
    SecurityService securityService;
    
    
    @PostConstruct
    public void init(){
        EntityConfig view= new EntityConfig("estudianteCurso", estudianteCursoService, EstudianteCursoDto.class);
        view.setSingularEntityTitle("Estudiante por Curso");
        view.setPluralEntityTitle("Estudiantes por Cursos");
        view.setMultipartFormData(false);
        view.setVisibleSeeAllButton(false);
        view.setDefaultOrder("id", "DESC");
        super.addControlMapping(view);
        
        MenuItem menuParent= new MenuItem("Estudiantes");
        MenuItem menuItem= new MenuItem("estudianteCurso", "Gestionar Estudiantes por Cursos", 2);
        menuParent.addSubMenu(menuItem);
        menuComponent.addItemMenu(menuParent);
    }
    
    @Override
    public List<MenuItem> configureVisibilityMenu(List<MenuItem> menuData){
        return securityService.configureVisibilityMenu(menuData);
    }
    
}