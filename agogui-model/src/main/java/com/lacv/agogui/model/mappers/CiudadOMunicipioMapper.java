/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lacv.agogui.model.mappers;

import com.lacv.jmagrexs.mapper.EntityMapper;
import com.lacv.jmagrexs.mapper.EntityMapperImpl;
import com.lacv.agogui.model.dtos.CiudadOMunicipioDto;
import com.lacv.agogui.model.entities.CiudadOMunicipio;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author lcastrillo
 */
@Component("ciudadOMunicipioMapper")
public class CiudadOMunicipioMapper extends EntityMapperImpl<CiudadOMunicipio, CiudadOMunicipioDto> implements EntityMapper<CiudadOMunicipio, CiudadOMunicipioDto> {
    
    @Autowired
    DepartamentoMapper departamentoMapper;

    
    @Override
    public CiudadOMunicipioDto entityToDto(CiudadOMunicipio entity) {
        CiudadOMunicipioDto dto= new CiudadOMunicipioDto();
        if(entity!=null){
            dto.setDepartamento(departamentoMapper.entityToDto(entity.getDepartamento()));
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
    public List<CiudadOMunicipioDto> listEntitiesToListDtos(List<CiudadOMunicipio> entities){
        List<CiudadOMunicipioDto> dtos= new ArrayList<>();
        if(entities!=null){
            for(CiudadOMunicipio entity: entities){
                dtos.add(entityToDto(entity));
            }
        }
        return dtos;
    }
    
}
