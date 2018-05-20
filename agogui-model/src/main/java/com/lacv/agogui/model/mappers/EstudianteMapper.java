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
    PaisMapper paisMapper;
    
    @Autowired
    DepartamentoMapper departamentoMapper;
    
    @Autowired
    CiudadOMunicipioMapper ciudadOMunicipioMapper;
    
    @Autowired
    SedeMapper sedeMapper;

    
    @Override
    public EstudianteDto entityToDto(Estudiante entity) {
        EstudianteDto dto= new EstudianteDto();
        if(entity!=null){
            dto.setBarrio(entity.getBarrio());
            dto.setPais(paisMapper.entityToDto(entity.getPais()));
            dto.setDepartamento(departamentoMapper.entityToDto(entity.getDepartamento()));
            dto.setCiudadOMunicipio(ciudadOMunicipioMapper.entityToDto(entity.getCiudadOMunicipio()));
            dto.setCorreoElectronico(entity.getCorreoElectronico());
            dto.setDireccion(entity.getDireccion());
            dto.setDocumentoId(entity.getDocumentoId());
            dto.setEstado(entity.getEstado());
            dto.setFechaNacimiento(entity.getFechaNacimiento());
            dto.setFechaRegistro(entity.getFechaRegistro());
            dto.setFoto(entity.getFoto());
            dto.setId(entity.getId());
            dto.setSede(sedeMapper.entityToDto(entity.getSede()));
            dto.setNombre(entity.getNombre());
            dto.setPrimerApellido(entity.getPrimerApellido());
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
    
}
