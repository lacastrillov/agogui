/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lacv.agogui.model.mappers;

import com.lacv.jmagrexs.mapper.EntityMapper;
import com.lacv.jmagrexs.mapper.EntityMapperImpl;
import com.lacv.agogui.model.dtos.EvaluacionDto;
import com.lacv.agogui.model.entities.Evaluacion;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author lcastrillo
 */
@Component("evaluacionMapper")
public class EvaluacionMapper extends EntityMapperImpl<Evaluacion, EvaluacionDto> implements EntityMapper<Evaluacion, EvaluacionDto> {
    
    @Autowired
    AsignaturaMapper asignaturaMapper;
    
    @Autowired
    CursoMapper cursoMapper;
    
    @Autowired
    DocenteMapper docenteMapper;
    
    @Autowired
    PeriodoMapper periodoMapper;

    
    @Override
    public EvaluacionDto entityToDto(Evaluacion entity) {
        EvaluacionDto dto= new EvaluacionDto();
        if(entity!=null){
            dto.setAsignatura(asignaturaMapper.entityToDto(entity.getAsignatura()));
            dto.setCurso(cursoMapper.entityToDto(entity.getCurso()));
            dto.setDescripcion(entity.getDescripcion());
            dto.setDocente(docenteMapper.entityToDto(entity.getDocente()));
            dto.setFecha(entity.getFecha());
            dto.setId(entity.getId());
            dto.setNumero(entity.getNumero());
            dto.setPeriodo(periodoMapper.entityToDto(entity.getPeriodo()));
            dto.setPorcentaje(entity.getPorcentaje());
            dto.setTipoCalificacionLogros(entity.getTipoCalificacionLogros());
            dto.setTitulo(entity.getTitulo());
        }
        return dto;
    }
    
    /**
     *
     * @param entities
     * @return
     */
    @Override
    public List<EvaluacionDto> listEntitiesToListDtos(List<Evaluacion> entities){
        List<EvaluacionDto> dtos= new ArrayList<>();
        if(entities!=null){
            for(Evaluacion entity: entities){
                dtos.add(entityToDto(entity));
            }
        }
        return dtos;
    }
    
}
