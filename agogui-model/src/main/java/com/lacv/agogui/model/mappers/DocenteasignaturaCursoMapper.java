/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lacv.agogui.model.mappers;

import com.lacv.jmagrexs.mapper.EntityMapper;
import com.lacv.jmagrexs.mapper.EntityMapperImpl;
import com.lacv.agogui.model.dtos.DocenteasignaturaCursoDto;
import com.lacv.agogui.model.entities.DocenteasignaturaCurso;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author lcastrillo
 */
@Component("docenteasignaturaCursoMapper")
public class DocenteasignaturaCursoMapper extends EntityMapperImpl<DocenteasignaturaCurso, DocenteasignaturaCursoDto> implements EntityMapper<DocenteasignaturaCurso, DocenteasignaturaCursoDto> {
    
    @Autowired
    AsignaturaMapper asignaturaMapper;
    
    @Autowired
    CursoMapper cursoMapper;
    
    @Autowired
    DocenteMapper docenteMapper;

    
    @Override
    public DocenteasignaturaCursoDto entityToDto(DocenteasignaturaCurso entity) {
        DocenteasignaturaCursoDto dto= new DocenteasignaturaCursoDto();
        if(entity!=null){
            dto.setAsignatura(asignaturaMapper.entityToDto(entity.getAsignatura()));
            dto.setCurso(cursoMapper.entityToDto(entity.getCurso()));
            dto.setDocente(docenteMapper.entityToDto(entity.getDocente()));
            dto.setId(entity.getId());
            dto.setIntensidadHoraria(entity.getIntensidadHoraria());
        }
        return dto;
    }
    
    /**
     *
     * @param entities
     * @return
     */
    @Override
    public List<DocenteasignaturaCursoDto> listEntitiesToListDtos(List<DocenteasignaturaCurso> entities){
        List<DocenteasignaturaCursoDto> dtos= new ArrayList<>();
        if(entities!=null){
            for(DocenteasignaturaCurso entity: entities){
                dtos.add(entityToDto(entity));
            }
        }
        return dtos;
    }
    
    @Override
    public DocenteasignaturaCurso dtoToEntity(DocenteasignaturaCursoDto dto) {
        DocenteasignaturaCurso entity= new DocenteasignaturaCurso();
        if(dto!=null){
            entity.setAsignatura(asignaturaMapper.dtoToEntity(dto.getAsignatura()));
            entity.setCurso(cursoMapper.dtoToEntity(dto.getCurso()));
            entity.setDocente(docenteMapper.dtoToEntity(dto.getDocente()));
            entity.setId(dto.getId());
            entity.setIntensidadHoraria(dto.getIntensidadHoraria());
        }
        return entity;
    }
    
    /**
     *
     * @return
     */
    @Override
    public List<DocenteasignaturaCurso> listDtosToListEntities(List<DocenteasignaturaCursoDto> dtos){
        List<DocenteasignaturaCurso> entities= new ArrayList<>();
        if(entities!=null){
            for(DocenteasignaturaCursoDto dto: dtos){
                entities.add(dtoToEntity(dto));
            }
        }
        return entities;
    }

}
