/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lacv.agogui.model.dtos.config;

import com.lacv.jmagrexs.annotation.EntityCombobox;
import com.lacv.jmagrexs.annotation.Order;
import com.lacv.jmagrexs.annotation.TextField;
import com.lacv.jmagrexs.annotation.TypeFormField;
import com.lacv.jmagrexs.enums.FieldType;
import com.lacv.jmagrexs.modules.security.model.entities.User;
import java.util.List;

/**
 *
 * @author lacastrillov
 */
public class PortalConfigDto {
    
    @Order(1)
    @TextField("Nombre")
    private String name;
    
    @Order(2)
    @TextField("Lenguaje")
    @TypeFormField(value= FieldType.LIST, data = {"ES:Español","EN:Inglés","FR:Francés"})
    private String language;
    
    @Order(3)
    @TextField("Correo Corporativo")
    @TypeFormField(FieldType.EMAIL)
    private String corporateMail;
    
    @Order(4)
    @TextField("Banner")
    @TypeFormField(FieldType.IMAGE_FILE_UPLOAD)
    private String banner;
    
    @Order(5)
    @TextField("Oficina Principal")
    @TypeFormField(FieldType.GOOGLE_MAP)
    private String mainOffice;
    
    @Order(6)
    @TextField("Video Promocional")
    @TypeFormField(FieldType.VIDEO_YOUTUBE)
    private String promVideo;
    
    @Order(7)
    @TextField("Reseña")
    @TypeFormField(FieldType.HTML_EDITOR)
    private String review;
    
    @Order(8)
    @TextField("Estado CRON")
    @TypeFormField(value=FieldType.ON_OFF)
    private Boolean cronStatus;
    
    @Order(9)
    @TextField("Estado JOB")
    @TypeFormField(value=FieldType.ON_OFF)
    private Boolean jobStatus;
    
    @Order(10)
    @TextField("Usuario")
    @EntityCombobox(User.class)
    private Integer user;
    
    @TextField("Ubicaciones")
    private List<String> locations;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the language
     */
    public String getLanguage() {
        return language;
    }

    /**
     * @param language the language to set
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * 
     * @return corporateMail
     */
    public String getCorporateMail() {
        return corporateMail;
    }

    /**
     * 
     * @param corporateMail 
     */
    public void setCorporateMail(String corporateMail) {
        this.corporateMail = corporateMail;
    }

    /**
     * 
     * @return the banner
     */
    public String getBanner() {
        return banner;
    }

    /**
     * 
     * @param banner 
     */
    public void setBanner(String banner) {
        this.banner = banner;
    }

    /**
     * 
     * @return mainOffice
     */
    public String getMainOffice() {
        return mainOffice;
    }

    /**
     * 
     * @param mainOffice 
     */
    public void setMainOffice(String mainOffice) {
        this.mainOffice = mainOffice;
    }

    /**
     * 
     * @return promVideo
     */
    public String getPromVideo() {
        return promVideo;
    }

    /**
     * 
     * @param promVideo 
     */
    public void setPromVideo(String promVideo) {
        this.promVideo = promVideo;
    }

    /**
     * 
     * @return review
     */
    public String getReview() {
        return review;
    }

    /**
     * 
     * @param review 
     */
    public void setReview(String review) {
        this.review = review;
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

    /**
     * @return the cronStatus
     */
    public Boolean getCronStatus() {
        return cronStatus;
    }

    /**
     * @param cronStatus the cronStatus to set
     */
    public void setCronStatus(Boolean cronStatus) {
        this.cronStatus = cronStatus;
    }
    
    /**
     * @return the jobStatus
     */
    public Boolean getJobStatus() {
        return jobStatus;
    }

    /**
     * @param jobStatus the jobStatus to set
     */
    public void setJobStatus(Boolean jobStatus) {
        this.jobStatus = jobStatus;
    }

    /**
     * @return the user
     */
    public Integer getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(Integer user) {
        this.user = user;
    }
    
}
