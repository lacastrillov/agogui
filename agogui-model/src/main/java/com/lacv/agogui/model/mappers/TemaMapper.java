/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lacv.agogui.model.mappers;

import com.lacv.jmagrexs.mapper.EntityMapper;
import com.lacv.jmagrexs.mapper.EntityMapperImpl;
import com.lacv.agogui.model.dtos.TemaDto;
import com.lacv.agogui.model.entities.Tema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author lcastrillo
 */
@Component("temaMapper")
public class TemaMapper extends EntityMapperImpl<Tema, TemaDto> implements EntityMapper<Tema, TemaDto> {
    
    @Autowired
    AsignaturaMapper asignaturaMapper;

    
    @Override
    public TemaDto entityToDto(Tema entity) {
        TemaDto dto= new TemaDto();
        if(entity!=null){
            dto.setAsignatura(asignaturaMapper.entityToDto(entity.getAsignatura()));
            dto.setId(entity.getId());
            dto.setTitulo(entity.getTitulo());
        }
        return dto;
    }
    
    /**
     *
     * @param entities
     * @return
     */
    @Override
    public List<TemaDto> listEntitiesToListDtos(List<Tema> entities){
        List<TemaDto> dtos= new ArrayList<>();
        if(entities!=null){
            for(Tema entity: entities){
                dtos.add(entityToDto(entity));
            }
        }
        return dtos;
    }
    
    @Override
    public Tema dtoToEntity(TemaDto dto) {
        Tema entity= new Tema();
        if(dto!=null){
            entity.setAsignatura(asignaturaMapper.dtoToEntity(dto.getAsignatura()));
            entity.setId(dto.getId());
            entity.setTitulo(dto.getTitulo());
        }
        return entity;
    }
    
    /**
     *
     * @return
     */
    @Override
    public List<Tema> listDtosToListEntities(List<TemaDto> dtos){
        List<Tema> entities= new ArrayList<>();
        if(entities!=null){
            for(TemaDto dto: dtos){
                entities.add(dtoToEntity(dto));
            }
        }
        return entities;
    }

}
