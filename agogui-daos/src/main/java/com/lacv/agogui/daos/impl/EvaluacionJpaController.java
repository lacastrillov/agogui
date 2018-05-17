/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lacv.agogui.daos.impl;


import com.lacv.agogui.daos.EvaluacionJpa;
import com.lacv.agogui.model.entities.Evaluacion;
import com.lacv.jmagrexs.dao.JPAGenericDao;
import org.springframework.stereotype.Repository;

/**
 *
 * @author lacastrillov
 */
@Repository
public class EvaluacionJpaController extends JPAGenericDao<Evaluacion> implements EvaluacionJpa {

}