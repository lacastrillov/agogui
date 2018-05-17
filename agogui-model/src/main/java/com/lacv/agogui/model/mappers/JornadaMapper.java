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
    SedeMapper sedeMapper;

    
    @Override
    public JornadaDto entityToDto(Jornada entity) {
        JornadaDto dto= new JornadaDto();
        if(entity!=null){
            dto.setId(entity.getId());
            dto.setNombre(entity.getNombre());
            dto.setSede(sedeMapper.entityToDto(entity.getSede()));
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
    
}
