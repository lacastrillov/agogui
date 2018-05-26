/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lacv.agogui.model.mappers;

import com.lacv.jmagrexs.mapper.EntityMapper;
import com.lacv.jmagrexs.mapper.EntityMapperImpl;
import com.lacv.agogui.model.dtos.DocenteAsignaturaDto;
import com.lacv.agogui.model.entities.DocenteAsignatura;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author lcastrillo
 */
@Component("docenteAsignaturaMapper")
public class DocenteAsignaturaMapper extends EntityMapperImpl<DocenteAsignatura, DocenteAsignaturaDto> implements EntityMapper<DocenteAsignatura, DocenteAsignaturaDto> {
    
    @Autowired
    AsignaturaMapper asignaturaMapper;
    
    @Autowired
    DocenteMapper docenteMapper;

    
    @Override
    public DocenteAsignaturaDto entityToDto(DocenteAsignatura entity) {
        DocenteAsignaturaDto dto= new DocenteAsignaturaDto();
        if(entity!=null){
            dto.setAsignatura(asignaturaMapper.entityToDto(entity.getAsignatura()));
            dto.setDocente(docenteMapper.entityToDto(entity.getDocente()));
            dto.setHabilitado(entity.getHabilitado());
            dto.setId(entity.getId());
        }
        return dto;
    }
    
    /**
     *
     * @param entities
     * @return
     */
    @Override
    public List<DocenteAsignaturaDto> listEntitiesToListDtos(List<DocenteAsignatura> entities){
        List<DocenteAsignaturaDto> dtos= new ArrayList<>();
        if(entities!=null){
            for(DocenteAsignatura entity: entities){
                dtos.add(entityToDto(entity));
            }
        }
        return dtos;
    }
    
    @Override
    public DocenteAsignatura dtoToEntity(DocenteAsignaturaDto dto) {
        DocenteAsignatura entity= new DocenteAsignatura();
        if(dto!=null){
            entity.setAsignatura(asignaturaMapper.dtoToEntity(dto.getAsignatura()));
            entity.setDocente(docenteMapper.dtoToEntity(dto.getDocente()));
            entity.setHabilitado(dto.getHabilitado());
            entity.setId(dto.getId());
        }
        return entity;
    }
    
    /**
     *
     * @return
     */
    @Override
    public List<DocenteAsignatura> listDtosToListEntities(List<DocenteAsignaturaDto> dtos){
        List<DocenteAsignatura> entities= new ArrayList<>();
        if(entities!=null){
            for(DocenteAsignaturaDto dto: dtos){
                entities.add(dtoToEntity(dto));
            }
        }
        return entities;
    }

}
