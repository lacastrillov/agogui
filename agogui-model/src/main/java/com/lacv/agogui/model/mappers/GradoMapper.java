/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lacv.agogui.model.mappers;

import com.lacv.jmagrexs.mapper.EntityMapper;
import com.lacv.jmagrexs.mapper.EntityMapperImpl;
import com.lacv.agogui.model.dtos.GradoDto;
import com.lacv.agogui.model.entities.Grado;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author lcastrillo
 */
@Component("gradoMapper")
public class GradoMapper extends EntityMapperImpl<Grado, GradoDto> implements EntityMapper<Grado, GradoDto> {
    
    @Autowired
    InstitucionMapper institucionMapper;

    
    @Override
    public GradoDto entityToDto(Grado entity) {
        GradoDto dto= new GradoDto();
        if(entity!=null){
            dto.setAlias(entity.getAlias());
            dto.setId(entity.getId());
            dto.setInstitucion(institucionMapper.entityToDto(entity.getInstitucion()));
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
    public List<GradoDto> listEntitiesToListDtos(List<Grado> entities){
        List<GradoDto> dtos= new ArrayList<>();
        if(entities!=null){
            for(Grado entity: entities){
                dtos.add(entityToDto(entity));
            }
        }
        return dtos;
    }
    
}
