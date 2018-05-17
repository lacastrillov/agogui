/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lacv.agogui.daos.impl;


import com.lacv.agogui.daos.AsignaturaJpa;
import com.lacv.agogui.model.entities.Asignatura;
import com.lacv.jmagrexs.dao.JPAGenericDao;
import org.springframework.stereotype.Repository;

/**
 *
 * @author lacastrillov
 */
@Repository
public class AsignaturaJpaController extends JPAGenericDao<Asignatura> implements AsignaturaJpa {

}