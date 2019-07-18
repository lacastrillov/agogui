/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lacv.agogui.controllers.rest;


import com.lacv.agogui.model.entities.Estudiante;
import com.lacv.agogui.model.mappers.EstudianteMapper;
import com.lacv.agogui.services.EstudianteService;
import com.lacv.jmagrexs.controller.rest.RestEntityController;
import com.lacv.jmagrexs.modules.fileexplorer.model.entities.WebFile;
import com.lacv.jmagrexs.modules.fileexplorer.services.WebFileService;
import com.lacv.jmagrexs.modules.security.services.bussiness.SecurityService;
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
    
    @Autowired
    SecurityService securityService;
    
    @Autowired
    WebFileService webFileService;
    
    
    @PostConstruct
    public void init(){
        super.addControlMapping("estudiante", estudianteService, estudianteMapper);
    }
    
    @Override
    public String saveFilePart(int slice, String fieldName, String fileName, String fileType, int fileSize, InputStream is, Object idParent, Boolean sessionUpload) {
        String path= "imagenes/estudiante/";
        WebFile parentWebFile= webFileService.createDirectoriesIfMissing(path, null);
        
        try {
            Integer userId= (sessionUpload!=null && sessionUpload)? securityService.getCurrentUser().getId():null;
            String imageName= idParent + "_" +fileName.replaceAll(" ", "_");
            WebFile webFile= webFileService.createByFileData(parentWebFile, slice, imageName, fileType, fileSize, is, userId);
            
            Estudiante estudiante = estudianteService.loadById(idParent);
            estudiante.setFoto(webFile.getLocation());
            estudianteService.update(estudiante);
            
            return "Archivo " + imageName + " almacenado correctamente";
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }
    
    @Override
    public String saveResizedImage(String fieldName, String fileName, String fileType, int width, int height, int fileSize, InputStream is, Object idParent, Boolean sessionUpload){
        String path= "imagenes/estudiante/";
        WebFile parentWebFile= webFileService.createDirectoriesIfMissing(path, null);
        
        try {
            Integer userId= (sessionUpload!=null && sessionUpload)? securityService.getCurrentUser().getId():null;
            String imageName= idParent + "_" + width + "x" + height + "_" +fileName.replaceAll(" ", "_");
            webFileService.createByFileData(parentWebFile, 0, imageName, fileType, fileSize, is, userId);
            
            return "Archivo " + imageName + " almacenado correctamente";
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }
    
    
}