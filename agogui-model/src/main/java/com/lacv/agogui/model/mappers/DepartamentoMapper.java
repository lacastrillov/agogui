/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lacv.agogui.model.mappers;

import com.lacv.jmagrexs.mapper.EntityMapper;
import com.lacv.jmagrexs.mapper.EntityMapperImpl;
import com.lacv.agogui.model.dtos.DepartamentoDto;
import com.lacv.agogui.model.entities.Departamento;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author lcastrillo
 */
@Component("departamentoMapper")
public class DepartamentoMapper extends EntityMapperImpl<Departamento, DepartamentoDto> implements EntityMapper<Departamento, DepartamentoDto> {
    
    @Autowired
    PaisMapper paisMapper;

    
    @Override
    public DepartamentoDto entityToDto(Departamento entity) {
        DepartamentoDto dto= new DepartamentoDto();
        if(entity!=null){
            dto.setId(entity.getId());
            dto.setNombre(entity.getNombre());
            dto.setPais(paisMapper.entityToDto(entity.getPais()));
        }
        return dto;
    }
    
    /**
     *
     * @param entities
     * @return
     */
    @Override
    public List<DepartamentoDto> listEntitiesToListDtos(List<Departamento> entities){
        List<DepartamentoDto> dtos= new ArrayList<>();
        if(entities!=null){
            for(Departamento entity: entities){
                dtos.add(entityToDto(entity));
            }
        }
        return dtos;
    }
    
    @Override
    public Departamento dtoToEntity(DepartamentoDto dto) {
        Departamento entity= new Departamento();
        if(dto!=null){
            entity.setId(dto.getId());
            entity.setNombre(dto.getNombre());
            entity.setPais(paisMapper.dtoToEntity(dto.getPais()));
        }
        return entity;
    }
    
    /**
     *
     * @return
     */
    @Override
    public List<Departamento> listDtosToListEntities(List<DepartamentoDto> dtos){
        List<Departamento> entities= new ArrayList<>();
        if(entities!=null){
            for(DepartamentoDto dto: dtos){
                entities.add(dtoToEntity(dto));
            }
        }
        return entities;
    }

}
