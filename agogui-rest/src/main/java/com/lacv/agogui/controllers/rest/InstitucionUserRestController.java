/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lacv.agogui.controllers.rest;


import com.lacv.agogui.model.mappers.InstitucionUserMapper;
import com.lacv.agogui.services.InstitucionUserService;
import com.lacv.jmagrexs.controller.rest.RestEntityController;
import java.io.InputStream;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author lcastrillo
 */
@Controller
@RequestMapping(value="/rest/institucionUser")
public class InstitucionUserRestController extends RestEntityController {
    
    @Autowired
    InstitucionUserService institucionUserService;
    
    @Autowired
    InstitucionUserMapper institucionUserMapper;
    
    
    @PostConstruct
    public void init(){
        super.addControlMapping("institucionUser", institucionUserService, institucionUserMapper);
    }
    
    @Override
    public String saveFilePart(int slice, String fieldName, String fileName, String fileType, int fileSize, InputStream is, Object idParent){
        return "Almacenamiento de archivo no implementado!!";
    }    
}