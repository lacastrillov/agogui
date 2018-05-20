/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lacv.agogui.controllers.view;

import com.lacv.agogui.model.dtos.DocenteasignaturaCursoDto;
import com.lacv.agogui.model.mappers.DocenteasignaturaCursoMapper;
import com.lacv.agogui.services.DocenteasignaturaCursoService;
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
@RequestMapping(value="/vista/docenteasignaturaCurso")
public class DocenteasignaturaCursoViewController extends ExtEntityController {
    
    @Autowired
    DocenteasignaturaCursoService docenteasignaturaCursoService;
    
    @Autowired
    DocenteasignaturaCursoMapper docenteasignaturaCursoMapper;
    
    @Autowired
    SecurityService securityService;
    
    
    @PostConstruct
    public void init(){
        EntityConfig view= new EntityConfig("docenteasignaturaCurso", docenteasignaturaCursoService, DocenteasignaturaCursoDto.class);
        view.setSingularEntityTitle("Docente por asignatura por Curso");
        view.setPluralEntityTitle("Docentes por Asignaturas por Cursos");
        view.setMultipartFormData(false);
        view.setVisibleSeeAllButton(false);
        view.setDefaultOrder("id", "DESC");
        super.addControlMapping(view);
        
        MenuItem menuParent= new MenuItem("Docentes");
        MenuItem menuItem= new MenuItem("docenteasignaturaCurso", "Docentes por Asignaturas por Cursos", 3);
        menuParent.addSubMenu(menuItem);
        menuComponent.addItemMenu(menuParent);
    }
    
    @Override
    public List<MenuItem> configureVisibilityMenu(List<MenuItem> menuData){
        return securityService.configureVisibilityMenu(menuData);
    }
    
}