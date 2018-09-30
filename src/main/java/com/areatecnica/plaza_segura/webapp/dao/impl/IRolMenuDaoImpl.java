/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.areatecnica.plaza_segura.webapp.dao.impl;


import com.areatecnica.plaza_segura.webapp.dao.IRolMenuDao;
import com.areatecnica.plaza_segura_webapp.entities.Rol;
import com.areatecnica.plaza_segura_webapp.entities.RolMenu;
import java.util.List;
import javax.persistence.NoResultException;

/**
 *
 * @author ianfr
 */
public class IRolMenuDaoImpl extends GenericDAOImpl<RolMenu> implements IRolMenuDao<RolMenu> {

    @Override
    public List<RolMenu> findAllByRol(Rol rol) {
        try {
            return this.entityManager.createNamedQuery("RolMenu.findByRol").setParameter("rolMenuIdRol", rol).getResultList();
        } catch (NoResultException ne) {
            return null;
        }
    }
    
}
