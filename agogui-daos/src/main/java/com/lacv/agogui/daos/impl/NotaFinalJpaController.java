/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lacv.agogui.daos.impl;


import com.lacv.agogui.daos.NotaFinalJpa;
import com.lacv.agogui.model.entities.NotaFinal;
import com.lacv.jmagrexs.dao.JPAGenericDao;
import org.springframework.stereotype.Repository;

/**
 *
 * @author lacastrillov
 */
@Repository
public class NotaFinalJpaController extends JPAGenericDao<NotaFinal> implements NotaFinalJpa {

}