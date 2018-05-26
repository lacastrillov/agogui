/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lacv.agogui.model.mappers;

import com.lacv.jmagrexs.mapper.EntityMapper;
import com.lacv.jmagrexs.mapper.EntityMapperImpl;
import com.lacv.agogui.model.dtos.PaisDto;
import com.lacv.agogui.model.entities.Pais;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author lcastrillo
 */
@Component("paisMapper")
public class PaisMapper extends EntityMapperImpl<Pais, PaisDto> implements EntityMapper<Pais, PaisDto> {

    
    @Override
    public PaisDto entityToDto(Pais entity) {
        PaisDto dto= new PaisDto();
        if(entity!=null){
            dto.setId(entity.getId());
            dto.setNombre(entity.getNombre());
        }
        return dto;
    }
    
    /**
     *
     * @param entities
     * @return
     */
    @Override
    public List<PaisDto> listEntitiesToListDtos(List<Pais> entities){
        List<PaisDto> dtos= new ArrayList<>();
        if(entities!=null){
            for(Pais entity: entities){
                dtos.add(entityToDto(entity));
            }
        }
        return dtos;
    }
    
    @Override
    public Pais dtoToEntity(PaisDto dto) {
        Pais entity= new Pais();
        if(dto!=null){
            entity.setId(dto.getId());
            entity.setNombre(dto.getNombre());
        }
        return entity;
    }
    
    /**
     *
     * @return
     */
    @Override
    public List<Pais> listDtosToListEntities(List<PaisDto> dtos){
        List<Pais> entities= new ArrayList<>();
        if(entities!=null){
            for(PaisDto dto: dtos){
                entities.add(dtoToEntity(dto));
            }
        }
        return entities;
    }

}
