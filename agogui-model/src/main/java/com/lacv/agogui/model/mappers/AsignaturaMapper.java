/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lacv.agogui.model.mappers;

import com.lacv.jmagrexs.mapper.EntityMapper;
import com.lacv.jmagrexs.mapper.EntityMapperImpl;
import com.lacv.agogui.model.dtos.AsignaturaDto;
import com.lacv.agogui.model.entities.Asignatura;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author lcastrillo
 */
@Component("asignaturaMapper")
public class AsignaturaMapper extends EntityMapperImpl<Asignatura, AsignaturaDto> implements EntityMapper<Asignatura, AsignaturaDto> {
    
    @Autowired
    AreaMapper areaMapper;

    
    @Override
    public AsignaturaDto entityToDto(Asignatura entity) {
        AsignaturaDto dto= new AsignaturaDto();
        if(entity!=null){
            dto.setArea(areaMapper.entityToDto(entity.getArea()));
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
    public List<AsignaturaDto> listEntitiesToListDtos(List<Asignatura> entities){
        List<AsignaturaDto> dtos= new ArrayList<>();
        if(entities!=null){
            for(Asignatura entity: entities){
                dtos.add(entityToDto(entity));
            }
        }
        return dtos;
    }
    
}
