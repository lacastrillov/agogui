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
    SedeMapper sedeMapper;

    
    @Override
    public DocenteDto entityToDto(Docente entity) {
        DocenteDto dto= new DocenteDto();
        if(entity!=null){
            dto.setBarrio(entity.getBarrio());
            dto.setCiudadOMunicipio(ciudadOMunicipioMapper.entityToDto(entity.getCiudadOMunicipio()));
            dto.setCorreoElectronico(entity.getCorreoElectronico());
            dto.setDireccion(entity.getDireccion());
            dto.setDocumentoId(entity.getDocumentoId());
            dto.setEstado(entity.getEstado());
            dto.setEstadoCivil(entity.getEstadoCivil());
            dto.setFechaNacimiento(entity.getFechaNacimiento());
            dto.setFechaRegistro(entity.getFechaRegistro());
            dto.setFoto(entity.getFoto());
            dto.setId(entity.getId());
            dto.setNacionalidad(entity.getNacionalidad());
            dto.setNombre(entity.getNombre());
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
    
}
