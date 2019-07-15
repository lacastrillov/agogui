/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lacv.agogui.controllers.rest;


import com.lacv.agogui.model.mappers.DocenteasignaturaCursoMapper;
import com.lacv.agogui.services.DocenteasignaturaCursoService;
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
@RequestMapping(value="/rest/docenteasignaturaCurso")
public class DocenteasignaturaCursoRestController extends RestEntityController {
    
    @Autowired
    DocenteasignaturaCursoService docenteasignaturaCursoService;
    
    @Autowired
    DocenteasignaturaCursoMapper docenteasignaturaCursoMapper;
    
    
    @PostConstruct
    public void init(){
        super.addControlMapping("docenteasignaturaCurso", docenteasignaturaCursoService, docenteasignaturaCursoMapper);
    }
    
    @Override
    public String saveFilePart(int slice, String fieldName, String fileName, String fileType, int fileSize, InputStream is, Object idParent, Boolean sessionUpload){
        return "Almacenamiento de archivo no implementado!!";
    }    
}