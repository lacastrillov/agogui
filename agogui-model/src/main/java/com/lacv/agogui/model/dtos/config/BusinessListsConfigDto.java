/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lacv.agogui.model.dtos.config;

import com.lacv.jmagrexs.annotation.Order;
import com.lacv.jmagrexs.annotation.TextField;
import com.lacv.jmagrexs.annotation.TypeFormField;
import com.lacv.jmagrexs.enums.FieldType;
import java.util.Date;
import java.util.List;

/**
 *
 * @author e11001a
 */
public class BusinessListsConfigDto {
    
    @Order(1)
    @TextField("Versi&oacute;n")
    private String version;
    
    @Order(2)
    @TextField("Correos")
    @TypeFormField(FieldType.EMAIL)
    private List<String> mails;
    
    @Order(3)
    @TextField("Fechas")
    @TypeFormField(FieldType.DATETIME)
    private List<Date> dates;
    
    @Order(4)
    @TextField("Estados")
    @TypeFormField(value=FieldType.MULTI_SELECT, data={"Active","Incative","Locked","Deleted"})
    private List<String> states;
    
    @Order(5)
    @TextField("Tamaños de Archivos")
    @TypeFormField(FieldType.FILE_SIZE)
    private List<Long> fileSizes;
    
    @Order(6)
    @TextField("Colores")
    @TypeFormField(FieldType.COLOR)
    private List<String> colors;
    
    @Order(7)
    @TextField("Porcentajes")
    @TypeFormField(FieldType.PERCENTAJE)
    private List<Long> percentajes;
    
    @Order(8)
    @TextField("Imagenes")
    @TypeFormField(FieldType.IMAGE_FILE_UPLOAD)
    private List<String> images;
    
    @Order(9)
    @TextField("Ubicaciones")
    @TypeFormField(FieldType.GOOGLE_MAP)
    private List<String> locations;
    
    
    public BusinessListsConfigDto(){
        
    }

    /**
     * @return the version
     */
    public String getVersion() {
        return version;
    }

    /**
     * @param version the version to set
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * @return the mails
     */
    public List<String> getMails() {
        return mails;
    }

    /**
     * @param mails the mails to set
     */
    public void setMails(List<String> mails) {
        this.mails = mails;
    }

    /**
     * @return the dates
     */
    public List<Date> getDates() {
        return dates;
    }

    /**
     * @param dates the dates to set
     */
    public void setDates(List<Date> dates) {
        this.dates = dates;
    }

    /**
     * @return the fileSizes
     */
    public List<Long> getFileSizes() {
        return fileSizes;
    }

    /**
     * @param fileSizes the fileSizes to set
     */
    public void setFileSizes(List<Long> fileSizes) {
        this.fileSizes = fileSizes;
    }

    /**
     * @return the states
     */
    public List<String> getStates() {
        return states;
    }

    /**
     * @param states the states to set
     */
    public void setStates(List<String> states) {
        this.states = states;
    }

    /**
     * @return the colors
     */
    public List<String> getColors() {
        return colors;
    }

    /**
     * @param colors the colors to set
     */
    public void setColors(List<String> colors) {
        this.colors = colors;
    }

    /**
     * @return the percentajes
     */
    public List<Long> getPercentajes() {
        return percentajes;
    }

    /**
     * @param percentajes the percentajes to set
     */
    public void setPercentajes(List<Long> percentajes) {
        this.percentajes = percentajes;
    }

    /**
     * @return the images
     */
    public List<String> getImages() {
        return images;
    }

    /**
     * @param images the images to set
     */
    public void setImages(List<String> images) {
        this.images = images;
    }

    /**
     * @return the locations
     */
    public List<String> getLocations() {
        return locations;
    }

    /**
     * @param locations the locations to set
     */
    public void setLocations(List<String> locations) {
        this.locations = locations;
    }
    
}
