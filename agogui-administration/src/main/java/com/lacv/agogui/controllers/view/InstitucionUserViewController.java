/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lacv.agogui.controllers.view;

import com.lacv.agogui.model.dtos.InstitucionUserDto;
import com.lacv.agogui.model.mappers.InstitucionUserMapper;
import com.lacv.agogui.services.InstitucionUserService;
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
@RequestMapping(value="/vista/institucionUser")
public class InstitucionUserViewController extends ExtEntityController {
    
    @Autowired
    InstitucionUserService institucionUserService;
    
    @Autowired
    InstitucionUserMapper institucionUserMapper;
    
    @Autowired
    SecurityService securityService;
    
    
    @PostConstruct
    public void init(){
        EntityConfig view= new EntityConfig("institucionUser", institucionUserService, InstitucionUserDto.class);
        view.setSingularEntityTitle("Usuario de Instituci&oacute;n");
        view.setPluralEntityTitle("Usuarios de Instituci&oacute;n");
        view.setMultipartFormData(false);
        view.setVisibleSeeAllButton(false);
        view.setDefaultOrder("id", "DESC");
        super.addControlMapping(view);
        
        MenuItem menuParent= new MenuItem("Instituci&oacute;n");
        MenuItem menuItem= new MenuItem("institucionUser", "Gestionar Usuarios de Instituci&oacute;n", 7);
        menuParent.addSubMenu(menuItem);
        menuComponent.addItemMenu(menuParent);
    }
    
    @Override
    public List<MenuItem> configureVisibilityMenu(List<MenuItem> menuData){
        return securityService.configureVisibilityMenu(menuData);
    }
    
}