/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lacv.agogui.model.mappers;

import com.lacv.jmagrexs.mapper.EntityMapper;
import com.lacv.jmagrexs.mapper.EntityMapperImpl;
import com.lacv.agogui.model.dtos.PeriodoDto;
import com.lacv.agogui.model.entities.Periodo;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author lcastrillo
 */
@Component("periodoMapper")
public class PeriodoMapper extends EntityMapperImpl<Periodo, PeriodoDto> implements EntityMapper<Periodo, PeriodoDto> {
    
    @Autowired
    GradoMapper gradoMapper;

    
    @Override
    public PeriodoDto entityToDto(Periodo entity) {
        PeriodoDto dto= new PeriodoDto();
        if(entity!=null){
            dto.setAlias(entity.getAlias());
            dto.setGrado(gradoMapper.entityToDto(entity.getGrado()));
            dto.setId(entity.getId());
            dto.setNumero(entity.getNumero());
        }
        return dto;
    }
    
    /**
     *
     * @param entities
     * @return
     */
    @Override
    public List<PeriodoDto> listEntitiesToListDtos(List<Periodo> entities){
        List<PeriodoDto> dtos= new ArrayList<>();
        if(entities!=null){
            for(Periodo entity: entities){
                dtos.add(entityToDto(entity));
            }
        }
        return dtos;
    }
    
}
