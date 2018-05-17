/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lacv.agogui.model.mappers;

import com.lacv.jmagrexs.mapper.EntityMapper;
import com.lacv.jmagrexs.mapper.EntityMapperImpl;
import com.lacv.agogui.model.dtos.SedeDto;
import com.lacv.agogui.model.entities.Sede;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author lcastrillo
 */
@Component("sedeMapper")
public class SedeMapper extends EntityMapperImpl<Sede, SedeDto> implements EntityMapper<Sede, SedeDto> {
    
    @Autowired
    InstitucionMapper institucionMapper;

    
    @Override
    public SedeDto entityToDto(Sede entity) {
        SedeDto dto= new SedeDto();
        if(entity!=null){
            dto.setCorreoElectronico(entity.getCorreoElectronico());
            dto.setDireccion(entity.getDireccion());
            dto.setId(entity.getId());
            dto.setInstitucion(institucionMapper.entityToDto(entity.getInstitucion()));
            dto.setNombre(entity.getNombre());
            dto.setTelefono(entity.getTelefono());
        }
        return dto;
    }
    
    /**
     *
     * @param entities
     * @return
     */
    @Override
    public List<SedeDto> listEntitiesToListDtos(List<Sede> entities){
        List<SedeDto> dtos= new ArrayList<>();
        if(entities!=null){
            for(Sede entity: entities){
                dtos.add(entityToDto(entity));
            }
        }
        return dtos;
    }
    
}
