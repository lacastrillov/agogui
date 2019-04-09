/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lacv.agogui.controllers.rest.config;


import com.lacv.agogui.model.dtos.config.PortalConfigDto;
import com.lacv.agogui.services.config.BusinessListsConfigService;
import com.lacv.agogui.services.config.ContactConfigService;
import com.lacv.agogui.services.config.PortalConfigService;
import com.lacv.jmagrexs.controller.rest.RestConfigurationController;
import com.lacv.jmagrexs.modules.fileexplorer.model.entities.WebFile;
import com.lacv.jmagrexs.modules.fileexplorer.services.WebFileService;
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
@RequestMapping(value="/rest/generalConfig")
public class GeneralConfigController extends RestConfigurationController {
    
    @Autowired
    PortalConfigService portalConfigService;
    
    @Autowired
    ContactConfigService contactConfigService;
    
    @Autowired
    BusinessListsConfigService businessListsConfigService;
    
    @Autowired
    WebFileService webFileService;
    
    
    @PostConstruct
    public void init(){
        super.addControlConfigurationObject("portalConfig", portalConfigService);
        super.addControlConfigurationObject("contactConfig", contactConfigService);
        super.addControlConfigurationObject("businessListsConfig", businessListsConfigService);
    }
    
    public String portalConfigFiles(PortalConfigDto portalConfig, String fieldName, String fileName, String fileType, int fileSize, InputStream is){
        String path= "imagenes/generalConfig/";
        WebFile parentWebFile= webFileService.findByPath(path);
        
        try {
            String imageName=fileName;
            if(fieldName.equals("banner")){
                imageName= "banner_" +fileName.replaceAll(" ", "_");
            }
            WebFile webFile= webFileService.createByFileData(parentWebFile, 0, imageName, fileType, fileSize, is);
            
            return webFile.getLocation();
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }
    
}
