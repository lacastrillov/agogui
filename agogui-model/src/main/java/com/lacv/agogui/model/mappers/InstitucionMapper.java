/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lacv.agogui.model.mappers;

import com.lacv.jmagrexs.mapper.EntityMapper;
import com.lacv.jmagrexs.mapper.EntityMapperImpl;
import com.lacv.agogui.model.dtos.InstitucionDto;
import com.lacv.agogui.model.entities.Institucion;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author lcastrillo
 */
@Component("institucionMapper")
public class InstitucionMapper extends EntityMapperImpl<Institucion, InstitucionDto> implements EntityMapper<Institucion, InstitucionDto> {
    
    @Autowired
    CiudadOMunicipioMapper ciudadOMunicipioMapper;
    
    @Autowired
    DepartamentoMapper departamentoMapper;
    
    @Autowired
    PaisMapper paisMapper;

    
    @Override
    public InstitucionDto entityToDto(Institucion entity) {
        InstitucionDto dto= new InstitucionDto();
        if(entity!=null){
            dto.setCiudadOMunicipio(ciudadOMunicipioMapper.entityToDto(entity.getCiudadOMunicipio()));
            dto.setCorreoElectronico(entity.getCorreoElectronico());
            dto.setDepartamento(departamentoMapper.entityToDto(entity.getDepartamento()));
            dto.setEstado(entity.getEstado());
            dto.setFechaCreacion(entity.getFechaCreacion());
            dto.setId(entity.getId());
            dto.setNivel(entity.getNivel());
            dto.setNombre(entity.getNombre());
            dto.setPais(paisMapper.entityToDto(entity.getPais()));
            dto.setRazonSocial(entity.getRazonSocial());
            dto.setTelefono(entity.getTelefono());
        }
        return dto;
    }
    
    /**
     *
     * @param entities
     * @return
     */
    @Override
    public List<InstitucionDto> listEntitiesToListDtos(List<Institucion> entities){
        List<InstitucionDto> dtos= new ArrayList<>();
        if(entities!=null){
            for(Institucion entity: entities){
                dtos.add(entityToDto(entity));
            }
        }
        return dtos;
    }
    
    @Override
    public Institucion dtoToEntity(InstitucionDto dto) {
        Institucion entity= new Institucion();
        if(dto!=null){
            entity.setCiudadOMunicipio(ciudadOMunicipioMapper.dtoToEntity(dto.getCiudadOMunicipio()));
            entity.setCorreoElectronico(dto.getCorreoElectronico());
            entity.setDepartamento(departamentoMapper.dtoToEntity(dto.getDepartamento()));
            entity.setEstado(dto.getEstado());
            entity.setFechaCreacion(dto.getFechaCreacion());
            entity.setId(dto.getId());
            entity.setNivel(dto.getNivel());
            entity.setNombre(dto.getNombre());
            entity.setPais(paisMapper.dtoToEntity(dto.getPais()));
            entity.setRazonSocial(dto.getRazonSocial());
            entity.setTelefono(dto.getTelefono());
        }
        return entity;
    }
    
    /**
     *
     * @return
     */
    @Override
    public List<Institucion> listDtosToListEntities(List<InstitucionDto> dtos){
        List<Institucion> entities= new ArrayList<>();
        if(entities!=null){
            for(InstitucionDto dto: dtos){
                entities.add(dtoToEntity(dto));
            }
        }
        return entities;
    }

}
