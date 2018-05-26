/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lacv.agogui.model.mappers;

import com.lacv.jmagrexs.mapper.EntityMapper;
import com.lacv.jmagrexs.mapper.EntityMapperImpl;
import com.lacv.agogui.model.dtos.NotaFinalDto;
import com.lacv.agogui.model.entities.NotaFinal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author lcastrillo
 */
@Component("notaFinalMapper")
public class NotaFinalMapper extends EntityMapperImpl<NotaFinal, NotaFinalDto> implements EntityMapper<NotaFinal, NotaFinalDto> {
    
    @Autowired
    AsignaturaMapper asignaturaMapper;
    
    @Autowired
    CursoMapper cursoMapper;
    
    @Autowired
    EstudianteMapper estudianteMapper;

    
    @Override
    public NotaFinalDto entityToDto(NotaFinal entity) {
        NotaFinalDto dto= new NotaFinalDto();
        if(entity!=null){
            dto.setAsignatura(asignaturaMapper.entityToDto(entity.getAsignatura()));
            dto.setCurso(cursoMapper.entityToDto(entity.getCurso()));
            dto.setDesempenio(entity.getDesempenio());
            dto.setEstudiante(estudianteMapper.entityToDto(entity.getEstudiante()));
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
    public List<NotaFinalDto> listEntitiesToListDtos(List<NotaFinal> entities){
        List<NotaFinalDto> dtos= new ArrayList<>();
        if(entities!=null){
            for(NotaFinal entity: entities){
                dtos.add(entityToDto(entity));
            }
        }
        return dtos;
    }
    
    @Override
    public NotaFinal dtoToEntity(NotaFinalDto dto) {
        NotaFinal entity= new NotaFinal();
        if(dto!=null){
            entity.setAsignatura(asignaturaMapper.dtoToEntity(dto.getAsignatura()));
            entity.setCurso(cursoMapper.dtoToEntity(dto.getCurso()));
            entity.setDesempenio(dto.getDesempenio());
            entity.setEstudiante(estudianteMapper.dtoToEntity(dto.getEstudiante()));
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
    public List<NotaFinal> listDtosToListEntities(List<NotaFinalDto> dtos){
        List<NotaFinal> entities= new ArrayList<>();
        if(entities!=null){
            for(NotaFinalDto dto: dtos){
                entities.add(dtoToEntity(dto));
            }
        }
        return entities;
    }

}
