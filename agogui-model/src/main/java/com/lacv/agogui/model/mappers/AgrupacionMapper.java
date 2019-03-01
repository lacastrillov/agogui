/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lacv.agogui.model.mappers;

import com.lacv.jmagrexs.mapper.EntityMapper;
import com.lacv.jmagrexs.mapper.EntityMapperImpl;
import com.lacv.agogui.model.dtos.AgrupacionDto;
import com.lacv.agogui.model.entities.Agrupacion;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import com.lacv.jmagrexs.util.Util;

/**
 *
 * @author lcastrillo
 */
@Component("agrupacionMapper")
public class AgrupacionMapper extends EntityMapperImpl<Agrupacion, AgrupacionDto> implements EntityMapper<Agrupacion, AgrupacionDto> {
    
    @Autowired
    AsignaturaMapper asignaturaMapper;
    
    @Autowired
    DocenteMapper docenteMapper;
    
    @Autowired
    EstudianteMapper estudianteMapper;

    
    @Override
    public AgrupacionDto entityToDto(Agrupacion entity) {
        AgrupacionDto dto= new AgrupacionDto();
        if(entity!=null){
            dto.setAnio(entity.getAnio());
            dto.setAsignatura(asignaturaMapper.entityToDto(entity.getAsignatura()));
            dto.setDocente(docenteMapper.entityToDto(entity.getDocente()));
            dto.setEstado(entity.getEstado());
            dto.setEstudiante(estudianteMapper.entityToDto(entity.getEstudiante()));
            dto.setFechaGrupo(entity.getFechaGrupo());
            dto.setId(Util.encodeObject(entity.getId()));
            dto.setNombreRelacion(entity.getNombreRelacion());
        }
        return dto;
    }
    
    /**
     *
     * @param entities
     * @return
     */
    @Override
    public List<AgrupacionDto> listEntitiesToListDtos(List<Agrupacion> entities){
        List<AgrupacionDto> dtos= new ArrayList<>();
        if(entities!=null){
            for(Agrupacion entity: entities){
                dtos.add(entityToDto(entity));
            }
        }
        return dtos;
    }
    
    @Override
    public Agrupacion dtoToEntity(AgrupacionDto dto) {
        Agrupacion entity= new Agrupacion();
        if(dto!=null){
            entity.setAnio(dto.getAnio());
            entity.setAsignatura(asignaturaMapper.dtoToEntity(dto.getAsignatura()));
            entity.setDocente(docenteMapper.dtoToEntity(dto.getDocente()));
            entity.setEstado(dto.getEstado());
            entity.setEstudiante(estudianteMapper.dtoToEntity(dto.getEstudiante()));
            entity.setFechaGrupo(dto.getFechaGrupo());
            entity.setId(Util.decodeObject(dto.getId(),com.lacv.agogui.model.entities.AgrupacionPK.class));
            entity.setNombreRelacion(dto.getNombreRelacion());
        }
        return entity;
    }
    
    /**
     *
     * @return
     */
    @Override
    public List<Agrupacion> listDtosToListEntities(List<AgrupacionDto> dtos){
        List<Agrupacion> entities= new ArrayList<>();
        if(entities!=null){
            for(AgrupacionDto dto: dtos){
                entities.add(dtoToEntity(dto));
            }
        }
        return entities;
    }

}
