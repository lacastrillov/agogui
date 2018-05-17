/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lacv.agogui.model.mappers;

import com.lacv.jmagrexs.mapper.EntityMapper;
import com.lacv.jmagrexs.mapper.EntityMapperImpl;
import com.lacv.agogui.model.dtos.NotaPeriodoDto;
import com.lacv.agogui.model.entities.NotaPeriodo;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author lcastrillo
 */
@Component("notaPeriodoMapper")
public class NotaPeriodoMapper extends EntityMapperImpl<NotaPeriodo, NotaPeriodoDto> implements EntityMapper<NotaPeriodo, NotaPeriodoDto> {
    
    @Autowired
    AsignaturaMapper asignaturaMapper;
    
    @Autowired
    CursoMapper cursoMapper;
    
    @Autowired
    EstudianteMapper estudianteMapper;
    
    @Autowired
    PeriodoMapper periodoMapper;

    
    @Override
    public NotaPeriodoDto entityToDto(NotaPeriodo entity) {
        NotaPeriodoDto dto= new NotaPeriodoDto();
        if(entity!=null){
            dto.setAsignatura(asignaturaMapper.entityToDto(entity.getAsignatura()));
            dto.setCurso(cursoMapper.entityToDto(entity.getCurso()));
            dto.setDesempenio(entity.getDesempenio());
            dto.setEstudiante(estudianteMapper.entityToDto(entity.getEstudiante()));
            dto.setFormato(entity.getFormato());
            dto.setId(entity.getId());
            dto.setNotaNumero(entity.getNotaNumero());
            dto.setNotaTexto(entity.getNotaTexto());
            dto.setPeriodo(periodoMapper.entityToDto(entity.getPeriodo()));
        }
        return dto;
    }
    
    /**
     *
     * @param entities
     * @return
     */
    @Override
    public List<NotaPeriodoDto> listEntitiesToListDtos(List<NotaPeriodo> entities){
        List<NotaPeriodoDto> dtos= new ArrayList<>();
        if(entities!=null){
            for(NotaPeriodo entity: entities){
                dtos.add(entityToDto(entity));
            }
        }
        return dtos;
    }
    
}
