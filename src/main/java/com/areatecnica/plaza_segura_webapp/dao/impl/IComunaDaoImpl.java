/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.areatecnica.plaza_segura_webapp.dao.impl;

import com.areatecnica.plaza_segura.webapp.dao.IComunaDao;
import com.areatecnica.plaza_segura_webapp.entities.Comuna;
import java.util.List;
import javax.persistence.NoResultException;

/**
 *
 * @author ianfr
 */
public class IComunaDaoImpl extends GenericDAOImpl<Comuna> implements IComunaDao<Comuna> {

    public IComunaDaoImpl() {
        super(Comuna.class);
    }

    @Override
    public List<Comuna> find() {
        try {
            return this.entityManager.createNamedQuery("Comuna.findAll").getResultList();
        } catch (NoResultException ne) {
            return null;
        }
    }

}
