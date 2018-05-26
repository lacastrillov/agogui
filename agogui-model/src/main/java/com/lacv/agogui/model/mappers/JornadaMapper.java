/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lacv.agogui.model.mappers;

import com.lacv.jmagrexs.mapper.EntityMapper;
import com.lacv.jmagrexs.mapper.EntityMapperImpl;
import com.lacv.agogui.model.dtos.JornadaDto;
import com.lacv.agogui.model.entities.Jornada;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author lcastrillo
 */
@Component("jornadaMapper")
public class JornadaMapper extends EntityMapperImpl<Jornada, JornadaDto> implements EntityMapper<Jornada, JornadaDto> {
    
    @Autowired
    InstitucionMapper institucionMapper;

    
    @Override
    public JornadaDto entityToDto(Jornada entity) {
        JornadaDto dto= new JornadaDto();
        if(entity!=null){
            dto.setId(entity.getId());
            dto.setInstitucion(institucionMapper.entityToDto(entity.getInstitucion()));
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
    public List<JornadaDto> listEntitiesToListDtos(List<Jornada> entities){
        List<JornadaDto> dtos= new ArrayList<>();
        if(entities!=null){
            for(Jornada entity: entities){
                dtos.add(entityToDto(entity));
            }
        }
        return dtos;
    }
    
    @Override
    public Jornada dtoToEntity(JornadaDto dto) {
        Jornada entity= new Jornada();
        if(dto!=null){
            entity.setId(dto.getId());
            entity.setInstitucion(institucionMapper.dtoToEntity(dto.getInstitucion()));
            entity.setNombre(dto.getNombre());
        }
        return entity;
    }
    
    /**
     *
     * @return
     */
    @Override
    public List<Jornada> listDtosToListEntities(List<JornadaDto> dtos){
        List<Jornada> entities= new ArrayList<>();
        if(entities!=null){
            for(JornadaDto dto: dtos){
                entities.add(dtoToEntity(dto));
            }
        }
        return entities;
    }

}
