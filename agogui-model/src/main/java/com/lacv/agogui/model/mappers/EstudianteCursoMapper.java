/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lacv.agogui.model.mappers;

import com.lacv.jmagrexs.mapper.EntityMapper;
import com.lacv.jmagrexs.mapper.EntityMapperImpl;
import com.lacv.agogui.model.dtos.EstudianteCursoDto;
import com.lacv.agogui.model.entities.EstudianteCurso;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author lcastrillo
 */
@Component("estudianteCursoMapper")
public class EstudianteCursoMapper extends EntityMapperImpl<EstudianteCurso, EstudianteCursoDto> implements EntityMapper<EstudianteCurso, EstudianteCursoDto> {
    
    @Autowired
    CursoMapper cursoMapper;
    
    @Autowired
    EstudianteMapper estudianteMapper;

    
    @Override
    public EstudianteCursoDto entityToDto(EstudianteCurso entity) {
        EstudianteCursoDto dto= new EstudianteCursoDto();
        if(entity!=null){
            dto.setCurso(cursoMapper.entityToDto(entity.getCurso()));
            dto.setEstudiante(estudianteMapper.entityToDto(entity.getEstudiante()));
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
    public List<EstudianteCursoDto> listEntitiesToListDtos(List<EstudianteCurso> entities){
        List<EstudianteCursoDto> dtos= new ArrayList<>();
        if(entities!=null){
            for(EstudianteCurso entity: entities){
                dtos.add(entityToDto(entity));
            }
        }
        return dtos;
    }
    
}
