/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lacv.agogui.controllers.rest;


import com.lacv.agogui.model.mappers.EstudianteMapper;
import com.lacv.agogui.services.EstudianteService;
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
@RequestMapping(value="/rest/estudiante")
public class EstudianteRestController extends RestEntityController {
    
    @Autowired
    EstudianteService estudianteService;
    
    @Autowired
    EstudianteMapper estudianteMapper;
    
    
    @PostConstruct
    public void init(){
        super.addControlMapping("estudiante", estudianteService, estudianteMapper);
    }
    
    @Override
    public String saveFilePart(int slice, String fieldName, String fileName, String fileType, int fileSize, InputStream is, Object idParent){
        return "Almacenamiento de archivo no implementado!!";
    }    
}