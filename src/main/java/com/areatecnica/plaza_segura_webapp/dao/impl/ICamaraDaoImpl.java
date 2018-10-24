/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.areatecnica.plaza_segura_webapp.dao.impl;

import com.areatecnica.plaza_segura.webapp.dao.ICamaraDao;
import com.areatecnica.plaza_segura_webapp.entities.Camara;
import com.areatecnica.plaza_segura_webapp.entities.Comuna;
import java.util.List;
import javax.persistence.NoResultException;

/**
 *
 * @author ianfr
 */
public class ICamaraDaoImpl extends GenericDAOImpl<Camara> implements ICamaraDao<Camara> {

    public ICamaraDaoImpl() {
        super(Camara.class);
    }

    @Override
    public List<Camara> findAllByComuna(Comuna comuna) {
        try {
            return this.entityManager.createNamedQuery("Camara.findByCamaraIdComuna").setParameter("camaraIdComuna", comuna).getResultList();
        } catch (NoResultException ne) {
            return null;
        }
    }

}
