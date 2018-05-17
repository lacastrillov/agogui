/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lacv.agogui.model.mappers;

import com.lacv.jmagrexs.mapper.EntityMapper;
import com.lacv.jmagrexs.mapper.EntityMapperImpl;
import com.lacv.agogui.model.dtos.CursoDto;
import com.lacv.agogui.model.entities.Curso;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author lcastrillo
 */
@Component("cursoMapper")
public class CursoMapper extends EntityMapperImpl<Curso, CursoDto> implements EntityMapper<Curso, CursoDto> {
    
    @Autowired
    GradoMapper gradoMapper;
    
    @Autowired
    JornadaMapper jornadaMapper;

    
    @Override
    public CursoDto entityToDto(Curso entity) {
        CursoDto dto= new CursoDto();
        if(entity!=null){
            dto.setActivo(entity.getActivo());
            dto.setAnioLectivo(entity.getAnioLectivo());
            dto.setFechaCreacion(entity.getFechaCreacion());
            dto.setGrado(gradoMapper.entityToDto(entity.getGrado()));
            dto.setId(entity.getId());
            dto.setJornada(jornadaMapper.entityToDto(entity.getJornada()));
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
    public List<CursoDto> listEntitiesToListDtos(List<Curso> entities){
        List<CursoDto> dtos= new ArrayList<>();
        if(entities!=null){
            for(Curso entity: entities){
                dtos.add(entityToDto(entity));
            }
        }
        return dtos;
    }
    
}
