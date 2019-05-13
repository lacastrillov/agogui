/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lacv.agogui.controllers.rest.process;


import com.lacv.agogui.model.dtos.process.ChangeUserStatusPDto;
import com.lacv.agogui.services.EstudianteService;
import com.lacv.jmagrexs.annotation.DoProcess;
import com.lacv.jmagrexs.controller.rest.RestProcessController;
import com.lacv.jmagrexs.dao.Parameters;
import com.lacv.jmagrexs.modules.common.model.dtos.BasicResultDto;
import com.lacv.jmagrexs.modules.common.model.entities.LogProcess;
import com.lacv.jmagrexs.modules.common.services.LogProcessService;
import com.lacv.jmagrexs.modules.security.model.entities.User;
import com.lacv.jmagrexs.modules.security.services.bussiness.SecurityService;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author lcastrillo
 */
@Controller
@RequestMapping(value="/rest/processStudent")
public class StudentProcessRestController extends RestProcessController {
    
    @Autowired
    EstudianteService estudianteService;
    
    @Autowired
    LogProcessService logProcessService;
    
    @Autowired
    SecurityService securityService;
    
    
    @PostConstruct
    public void init(){
        super.addControlProcess("processStudent", LogProcess.class, logProcessService);
    }
    
    @Override
    public String getClientId(){
        User user= securityService.getCurrentUser();
        return user.getUsername();
    }
    
    @DoProcess
    public BasicResultDto changeUserStatus(ChangeUserStatusPDto changeUserStatusPDto){
        BasicResultDto result= new BasicResultDto();
        
        try{
            String[] textIds= changeUserStatusPDto.getIds().split(",");
            Integer[] ids= new Integer[textIds.length];
            for(int i=0; i<textIds.length; i++){
                ids[i]=new Integer(textIds[i]);
            }
            Parameters p= new Parameters();
            p.whereIn("id", ids);
            p.updateValue("estado", changeUserStatusPDto.getStatus());
            int total= estudianteService.updateByParameters(p);

            result.setSuccess(true);
            result.setMessage("Se se asigno correctamente el estado "+changeUserStatusPDto.getStatus()+" a "+total+" estudiantes.");
        }catch(Exception e){
            LOGGER.error("ERROR changeUserStatus ", e);
            result.setSuccess(false);
            result.setMessage("ERROR. No se ejecuto la operacion.");
        }
        result.setUsername(getClientId());
        
        return result;
    }
    
}
