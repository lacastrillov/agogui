package com.lacv.agogui.controllers.portal;

import com.lacv.jmagrexs.modules.fileexplorer.controllers.rest.WebFileRestController;
import com.lacv.jmagrexs.modules.security.services.bussiness.SecurityService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequestMapping(value = "/")
public class HomeController {
    
    @Autowired
    SecurityService securityService;
    
    @Autowired
    WebFileRestController webFileRestController;
    
    
    @RequestMapping(value = "/", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView getIndex(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("index");
        

        return mav;
    }
    
    @RequestMapping(value = "/contactenos", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView getContactenos(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("contactenos");
        

        return mav;
    }
    
    @RequestMapping(value = "/recursos/**/{fileName:.+}", method = {RequestMethod.GET})
    public void download(@PathVariable String fileName, HttpServletRequest request, HttpServletResponse response) {
        webFileRestController.download(fileName, request, response);
    }
    
    @RequestMapping(value = "/uf/**/{fileName:.+}", method = {RequestMethod.GET})
    public void sessionDownload(@PathVariable String fileName, HttpServletRequest request, HttpServletResponse response) {
        webFileRestController.download(fileName, request, response);
    }
    
    @RequestMapping(value = "/uf/**/{fileName}/", method = {RequestMethod.GET})
    public void sessionDownloadPath(@PathVariable String fileName, HttpServletRequest request, HttpServletResponse response) {
        webFileRestController.download(fileName, request, response);
    }
    
    
}
