package com.lacv.agogui.controllers.portal;

import com.lacv.jmagrexs.modules.security.services.bussiness.SecurityService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
@RequestMapping(value = "/expediente")
public class ExpedienteController {
    
    @Autowired
    SecurityService securityService;
    
    
    
    @RequestMapping(value = "/estudiante", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView getExpediente(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("expediente");
        

        return mav;
    }
    
}
