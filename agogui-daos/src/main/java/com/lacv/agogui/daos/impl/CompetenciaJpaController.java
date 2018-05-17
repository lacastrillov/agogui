/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lacv.agogui.daos.impl;


import com.lacv.agogui.daos.CompetenciaJpa;
import com.lacv.agogui.model.entities.Competencia;
import com.lacv.jmagrexs.dao.JPAGenericDao;
import org.springframework.stereotype.Repository;

/**
 *
 * @author lacastrillov
 */
@Repository
public class CompetenciaJpaController extends JPAGenericDao<Competencia> implements CompetenciaJpa {

}