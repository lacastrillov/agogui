/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lacv.agogui.daos.impl;


import com.lacv.agogui.daos.JornadaJpa;
import com.lacv.agogui.model.entities.Jornada;
import com.lacv.jmagrexs.dao.JPAGenericDao;
import org.springframework.stereotype.Repository;

/**
 *
 * @author lacastrillov
 */
@Repository
public class JornadaJpaController extends JPAGenericDao<Jornada> implements JornadaJpa {

}