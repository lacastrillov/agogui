/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lacv.agogui.model.mappers;

import com.lacv.jmagrexs.mapper.EntityMapper;
import com.lacv.jmagrexs.mapper.EntityMapperImpl;
import com.lacv.agogui.model.dtos.DocenteDto;
import com.lacv.agogui.model.entities.Docente;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author lcastrillo
 */
@Component("docenteMapper")
public class DocenteMapper extends EntityMapperImpl<Docente, DocenteDto> implements EntityMapper<Docente, DocenteDto> {
    
    @Autowired
    CiudadOMunicipioMapper ciudadOMunicipioMapper;
    
    @Autowired
    DepartamentoMapper departamentoMapper;
    
    @Autowired
    PaisMapper paisMapper;
    
    @Autowired
    SedeMapper sedeMapper;

    
    @Override
    public DocenteDto entityToDto(Docente entity) {
        DocenteDto dto= new DocenteDto();
        if(entity!=null){
            dto.setBarrio(entity.getBarrio());
            dto.setCiudadOMunicipio(ciudadOMunicipioMapper.entityToDto(entity.getCiudadOMunicipio()));
            dto.setCorreoElectronico(entity.getCorreoElectronico());
            dto.setDepartamento(departamentoMapper.entityToDto(entity.getDepartamento()));
            dto.setDireccion(entity.getDireccion());
            dto.setDocumentoId(entity.getDocumentoId());
            dto.setEstado(entity.getEstado());
            dto.setEstadoCivil(entity.getEstadoCivil());
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
            dto.setTituloProfesional(entity.getTituloProfesional());
        }
        return dto;
    }
    
    /**
     *
     * @param entities
     * @return
     */
    @Override
    public List<DocenteDto> listEntitiesToListDtos(List<Docente> entities){
        List<DocenteDto> dtos= new ArrayList<>();
        if(entities!=null){
            for(Docente entity: entities){
                dtos.add(entityToDto(entity));
            }
        }
        return dtos;
    }
    
    @Override
    public Docente dtoToEntity(DocenteDto dto) {
        Docente entity= new Docente();
        if(dto!=null){
            entity.setBarrio(dto.getBarrio());
            entity.setCiudadOMunicipio(ciudadOMunicipioMapper.dtoToEntity(dto.getCiudadOMunicipio()));
            entity.setCorreoElectronico(dto.getCorreoElectronico());
            entity.setDepartamento(departamentoMapper.dtoToEntity(dto.getDepartamento()));
            entity.setDireccion(dto.getDireccion());
            entity.setDocumentoId(dto.getDocumentoId());
            entity.setEstado(dto.getEstado());
            entity.setEstadoCivil(dto.getEstadoCivil());
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
            entity.setTituloProfesional(dto.getTituloProfesional());
        }
        return entity;
    }
    
    /**
     *
     * @return
     */
    @Override
    public List<Docente> listDtosToListEntities(List<DocenteDto> dtos){
        List<Docente> entities= new ArrayList<>();
        if(entities!=null){
            for(DocenteDto dto: dtos){
                entities.add(dtoToEntity(dto));
            }
        }
        return entities;
    }

}
