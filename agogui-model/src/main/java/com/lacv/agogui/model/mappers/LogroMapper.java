/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lacv.agogui.model.mappers;

import com.lacv.jmagrexs.mapper.EntityMapper;
import com.lacv.jmagrexs.mapper.EntityMapperImpl;
import com.lacv.agogui.model.dtos.LogroDto;
import com.lacv.agogui.model.entities.Logro;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author lcastrillo
 */
@Component("logroMapper")
public class LogroMapper extends EntityMapperImpl<Logro, LogroDto> implements EntityMapper<Logro, LogroDto> {
    
    @Autowired
    CompetenciaMapper competenciaMapper;
    
    @Autowired
    PeriodoMapper periodoMapper;
    
    @Autowired
    TemaMapper temaMapper;

    
    @Override
    public LogroDto entityToDto(Logro entity) {
        LogroDto dto= new LogroDto();
        if(entity!=null){
            dto.setCompetencia(competenciaMapper.entityToDto(entity.getCompetencia()));
            dto.setDescripcion(entity.getDescripcion());
            dto.setId(entity.getId());
            dto.setPeriodo(periodoMapper.entityToDto(entity.getPeriodo()));
            dto.setTema(temaMapper.entityToDto(entity.getTema()));
        }
        return dto;
    }
    
    /**
     *
     * @param entities
     * @return
     */
    @Override
    public List<LogroDto> listEntitiesToListDtos(List<Logro> entities){
        List<LogroDto> dtos= new ArrayList<>();
        if(entities!=null){
            for(Logro entity: entities){
                dtos.add(entityToDto(entity));
            }
        }
        return dtos;
    }
    
}
