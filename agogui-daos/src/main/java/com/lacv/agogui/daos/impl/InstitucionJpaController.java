/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lacv.agogui.daos.impl;


import com.lacv.agogui.daos.InstitucionJpa;
import com.lacv.agogui.model.entities.Institucion;
import com.lacv.jmagrexs.dao.JPAGenericDao;
import org.springframework.stereotype.Repository;

/**
 *
 * @author lacastrillov
 */
@Repository
public class InstitucionJpaController extends JPAGenericDao<Institucion> implements InstitucionJpa {

}