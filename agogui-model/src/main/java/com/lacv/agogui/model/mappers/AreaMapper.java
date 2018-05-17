/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lacv.agogui.model.mappers;

import com.lacv.jmagrexs.mapper.EntityMapper;
import com.lacv.jmagrexs.mapper.EntityMapperImpl;
import com.lacv.agogui.model.dtos.AreaDto;
import com.lacv.agogui.model.entities.Area;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author lcastrillo
 */
@Component("areaMapper")
public class AreaMapper extends EntityMapperImpl<Area, AreaDto> implements EntityMapper<Area, AreaDto> {
    
    @Autowired
    InstitucionMapper institucionMapper;

    
    @Override
    public AreaDto entityToDto(Area entity) {
        AreaDto dto= new AreaDto();
        if(entity!=null){
            dto.setDescripcion(entity.getDescripcion());
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
    public List<AreaDto> listEntitiesToListDtos(List<Area> entities){
        List<AreaDto> dtos= new ArrayList<>();
        if(entities!=null){
            for(Area entity: entities){
                dtos.add(entityToDto(entity));
            }
        }
        return dtos;
    }
    
}
