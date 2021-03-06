/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lacv.agogui.model.dtos.process;

import com.lacv.jmagrexs.annotation.EntityCombobox;
import com.lacv.jmagrexs.modules.security.model.entities.Authorization;

/**
 *
 * @author grupot
 */
public class AutorizacionPDto {
    
    private String nombre;
    
    @EntityCombobox(Authorization.class)
    private Integer authorization;
    
    
    public AutorizacionPDto(){
    }
    
    public AutorizacionPDto(String nombre){
        this.nombre= nombre;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the authorization
     */
    public Integer getAuthorization() {
        return authorization;
    }

    /**
     * @param authorization the authorization to set
     */
    public void setAuthorization(Integer authorization) {
        this.authorization = authorization;
    }
    
    
    
}
