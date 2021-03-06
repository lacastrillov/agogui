/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lacv.agogui.model.mappers;

import com.lacv.jmagrexs.mapper.EntityMapper;
import com.lacv.jmagrexs.mapper.EntityMapperImpl;
import com.lacv.agogui.model.dtos.NotaEvaluacionDto;
import com.lacv.agogui.model.entities.NotaEvaluacion;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author lcastrillo
 */
@Component("notaEvaluacionMapper")
public class NotaEvaluacionMapper extends EntityMapperImpl<NotaEvaluacion, NotaEvaluacionDto> implements EntityMapper<NotaEvaluacion, NotaEvaluacionDto> {
    
    @Autowired
    AsignaturaMapper asignaturaMapper;
    
    @Autowired
    CursoMapper cursoMapper;
    
    @Autowired
    EstudianteMapper estudianteMapper;
    
    @Autowired
    EvaluacionMapper evaluacionMapper;

    
    @Override
    public NotaEvaluacionDto entityToDto(NotaEvaluacion entity) {
        NotaEvaluacionDto dto= new NotaEvaluacionDto();
        if(entity!=null){
            dto.setAsignatura(asignaturaMapper.entityToDto(entity.getAsignatura()));
            dto.setCurso(cursoMapper.entityToDto(entity.getCurso()));
            dto.setEstudiante(estudianteMapper.entityToDto(entity.getEstudiante()));
            dto.setEvaluacion(evaluacionMapper.entityToDto(entity.getEvaluacion()));
            dto.setFormato(entity.getFormato());
            dto.setId(entity.getId());
            dto.setNotaNumero(entity.getNotaNumero());
            dto.setNotaTexto(entity.getNotaTexto());
        }
        return dto;
    }
    
    /**
     *
     * @param entities
     * @return
     */
    @Override
    public List<NotaEvaluacionDto> listEntitiesToListDtos(List<NotaEvaluacion> entities){
        List<NotaEvaluacionDto> dtos= new ArrayList<>();
        if(entities!=null){
            for(NotaEvaluacion entity: entities){
                dtos.add(entityToDto(entity));
            }
        }
        return dtos;
    }
    
    @Override
    public NotaEvaluacion dtoToEntity(NotaEvaluacionDto dto) {
        NotaEvaluacion entity= new NotaEvaluacion();
        if(dto!=null){
            entity.setAsignatura(asignaturaMapper.dtoToEntity(dto.getAsignatura()));
            entity.setCurso(cursoMapper.dtoToEntity(dto.getCurso()));
            entity.setEstudiante(estudianteMapper.dtoToEntity(dto.getEstudiante()));
            entity.setEvaluacion(evaluacionMapper.dtoToEntity(dto.getEvaluacion()));
            entity.setFormato(dto.getFormato());
            entity.setId(dto.getId());
            entity.setNotaNumero(dto.getNotaNumero());
            entity.setNotaTexto(dto.getNotaTexto());
        }
        return entity;
    }
    
    /**
     *
     * @return
     */
    @Override
    public List<NotaEvaluacion> listDtosToListEntities(List<NotaEvaluacionDto> dtos){
        List<NotaEvaluacion> entities= new ArrayList<>();
        if(entities!=null){
            for(NotaEvaluacionDto dto: dtos){
                entities.add(dtoToEntity(dto));
            }
        }
        return entities;
    }

}
