/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lacv.agogui.model.mappers;

import com.lacv.jmagrexs.mapper.EntityMapper;
import com.lacv.jmagrexs.mapper.EntityMapperImpl;
import com.lacv.agogui.model.dtos.InstitucionUserDto;
import com.lacv.agogui.model.entities.InstitucionUser;
import com.lacv.jmagrexs.modules.security.model.mappers.UserMapper;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author lcastrillo
 */
@Component("institucionUserMapper")
public class InstitucionUserMapper extends EntityMapperImpl<InstitucionUser, InstitucionUserDto> implements EntityMapper<InstitucionUser, InstitucionUserDto> {
    
    @Autowired
    InstitucionMapper institucionMapper;
    
    @Autowired
    UserMapper userMapper;

    
    @Override
    public InstitucionUserDto entityToDto(InstitucionUser entity) {
        InstitucionUserDto dto= new InstitucionUserDto();
        if(entity!=null){
            dto.setId(entity.getId());
            dto.setInstitucion(institucionMapper.entityToDto(entity.getInstitucion()));
            dto.setUser(userMapper.entityToDto(entity.getUser()));
        }
        return dto;
    }
    
    /**
     *
     * @param entities
     * @return
     */
    @Override
    public List<InstitucionUserDto> listEntitiesToListDtos(List<InstitucionUser> entities){
        List<InstitucionUserDto> dtos= new ArrayList<>();
        if(entities!=null){
            for(InstitucionUser entity: entities){
                dtos.add(entityToDto(entity));
            }
        }
        return dtos;
    }
    
    @Override
    public InstitucionUser dtoToEntity(InstitucionUserDto dto) {
        InstitucionUser entity= new InstitucionUser();
        if(dto!=null){
            entity.setId(dto.getId());
            entity.setInstitucion(institucionMapper.dtoToEntity(dto.getInstitucion()));
            entity.setUser(userMapper.dtoToEntity(dto.getUser()));
        }
        return entity;
    }
    
    /**
     *
     * @return
     */
    @Override
    public List<InstitucionUser> listDtosToListEntities(List<InstitucionUserDto> dtos){
        List<InstitucionUser> entities= new ArrayList<>();
        if(entities!=null){
            for(InstitucionUserDto dto: dtos){
                entities.add(dtoToEntity(dto));
            }
        }
        return entities;
    }

}
