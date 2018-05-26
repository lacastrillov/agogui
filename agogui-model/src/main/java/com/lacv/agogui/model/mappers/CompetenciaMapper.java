/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lacv.agogui.model.mappers;

import com.lacv.jmagrexs.mapper.EntityMapper;
import com.lacv.jmagrexs.mapper.EntityMapperImpl;
import com.lacv.agogui.model.dtos.CompetenciaDto;
import com.lacv.agogui.model.entities.Competencia;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author lcastrillo
 */
@Component("competenciaMapper")
public class CompetenciaMapper extends EntityMapperImpl<Competencia, CompetenciaDto> implements EntityMapper<Competencia, CompetenciaDto> {

    
    @Override
    public CompetenciaDto entityToDto(Competencia entity) {
        CompetenciaDto dto= new CompetenciaDto();
        if(entity!=null){
            dto.setId(entity.getId());
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
    public List<CompetenciaDto> listEntitiesToListDtos(List<Competencia> entities){
        List<CompetenciaDto> dtos= new ArrayList<>();
        if(entities!=null){
            for(Competencia entity: entities){
                dtos.add(entityToDto(entity));
            }
        }
        return dtos;
    }
    
    @Override
    public Competencia dtoToEntity(CompetenciaDto dto) {
        Competencia entity= new Competencia();
        if(dto!=null){
            entity.setId(dto.getId());
            entity.setTitulo(dto.getTitulo());
        }
        return entity;
    }
    
    /**
     *
     * @return
     */
    @Override
    public List<Competencia> listDtosToListEntities(List<CompetenciaDto> dtos){
        List<Competencia> entities= new ArrayList<>();
        if(entities!=null){
            for(CompetenciaDto dto: dtos){
                entities.add(dtoToEntity(dto));
            }
        }
        return entities;
    }

}
