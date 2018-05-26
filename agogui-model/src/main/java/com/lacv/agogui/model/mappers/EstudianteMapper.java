/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lacv.agogui.model.mappers;

import com.lacv.jmagrexs.mapper.EntityMapper;
import com.lacv.jmagrexs.mapper.EntityMapperImpl;
import com.lacv.agogui.model.dtos.EstudianteDto;
import com.lacv.agogui.model.entities.Estudiante;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author lcastrillo
 */
@Component("estudianteMapper")
public class EstudianteMapper extends EntityMapperImpl<Estudiante, EstudianteDto> implements EntityMapper<Estudiante, EstudianteDto> {
    
    @Autowired
    CiudadOMunicipioMapper ciudadOMunicipioMapper;
    
    @Autowired
    DepartamentoMapper departamentoMapper;
    
    @Autowired
    PaisMapper paisMapper;
    
    @Autowired
    SedeMapper sedeMapper;

    
    @Override
    public EstudianteDto entityToDto(Estudiante entity) {
        EstudianteDto dto= new EstudianteDto();
        if(entity!=null){
            dto.setBarrio(entity.getBarrio());
            dto.setCiudadOMunicipio(ciudadOMunicipioMapper.entityToDto(entity.getCiudadOMunicipio()));
            dto.setCorreoElectronico(entity.getCorreoElectronico());
            dto.setDepartamento(departamentoMapper.entityToDto(entity.getDepartamento()));
            dto.setDireccion(entity.getDireccion());
            dto.setDocumentoId(entity.getDocumentoId());
            dto.setEstado(entity.getEstado());
            dto.setFechaNacimiento(entity.getFechaNacimiento());
            dto.setFechaRegistro(entity.getFechaRegistro());
            dto.setFoto(entity.getFoto());
            dto.setId(entity.getId());
            dto.setNombre(entity.getNombre());
            dto.setPais(paisMapper.entityToDto(entity.getPais()));
            dto.setPrimerApellido(entity.getPrimerApellido());
            dto.setSede(sedeMapper.entityToDto(entity.getSede()));
            dto.setSegundoApellido(entity.getSegundoApellido());
            dto.setSexo(entity.getSexo());
            dto.setTelefono1(entity.getTelefono1());
            dto.setTelefono2(entity.getTelefono2());
            dto.setTipoAcceso(entity.getTipoAcceso());
        }
        return dto;
    }
    
    /**
     *
     * @param entities
     * @return
     */
    @Override
    public List<EstudianteDto> listEntitiesToListDtos(List<Estudiante> entities){
        List<EstudianteDto> dtos= new ArrayList<>();
        if(entities!=null){
            for(Estudiante entity: entities){
                dtos.add(entityToDto(entity));
            }
        }
        return dtos;
    }
    
    @Override
    public Estudiante dtoToEntity(EstudianteDto dto) {
        Estudiante entity= new Estudiante();
        if(dto!=null){
            entity.setBarrio(dto.getBarrio());
            entity.setCiudadOMunicipio(ciudadOMunicipioMapper.dtoToEntity(dto.getCiudadOMunicipio()));
            entity.setCorreoElectronico(dto.getCorreoElectronico());
            entity.setDepartamento(departamentoMapper.dtoToEntity(dto.getDepartamento()));
            entity.setDireccion(dto.getDireccion());
            entity.setDocumentoId(dto.getDocumentoId());
            entity.setEstado(dto.getEstado());
            entity.setFechaNacimiento(dto.getFechaNacimiento());
            entity.setFechaRegistro(dto.getFechaRegistro());
            entity.setFoto(dto.getFoto());
            entity.setId(dto.getId());
            entity.setNombre(dto.getNombre());
            entity.setPais(paisMapper.dtoToEntity(dto.getPais()));
            entity.setPrimerApellido(dto.getPrimerApellido());
            entity.setSede(sedeMapper.dtoToEntity(dto.getSede()));
            entity.setSegundoApellido(dto.getSegundoApellido());
            entity.setSexo(dto.getSexo());
            entity.setTelefono1(dto.getTelefono1());
            entity.setTelefono2(dto.getTelefono2());
            entity.setTipoAcceso(dto.getTipoAcceso());
        }
        return entity;
    }
    
    /**
     *
     * @return
     */
    @Override
    public List<Estudiante> listDtosToListEntities(List<EstudianteDto> dtos){
        List<Estudiante> entities= new ArrayList<>();
        if(entities!=null){
            for(EstudianteDto dto: dtos){
                entities.add(dtoToEntity(dto));
            }
        }
        return entities;
    }

}
