/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lacv.agogui.controllers.rest;


import com.lacv.agogui.model.mappers.JornadaMapper;
import com.lacv.agogui.services.JornadaService;
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
@RequestMapping(value="/rest/jornada")
public class JornadaRestController extends RestEntityController {
    
    @Autowired
    JornadaService jornadaService;
    
    @Autowired
    JornadaMapper jornadaMapper;
    
    
    @PostConstruct
    public void init(){
        super.addControlMapping("jornada", jornadaService, jornadaMapper);
    }
    
    @Override
    public String saveFilePart(int slice, String fieldName, String fileName, String fileType, int fileSize, InputStream is, Object idParent, Boolean sessionUpload){
        return "Almacenamiento de archivo no implementado!!";
    }    
}