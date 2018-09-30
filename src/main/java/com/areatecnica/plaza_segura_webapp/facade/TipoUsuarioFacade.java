/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.areatecnica.plaza_segura_webapp.facade;

import com.areatecnica.plaza_segura_webapp.entities.TipoUsuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.areatecnica.plaza_segura_webapp.entities.TipoUsuario_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.areatecnica.plaza_segura_webapp.entities.Usuario;
import java.util.List;

/**
 *
 * @author ianfr
 */
@Stateless
public class TipoUsuarioFacade extends AbstractFacade<TipoUsuario> {

    @PersistenceContext(unitName = "com.areatecnica_plaza_segura_webapp_war_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoUsuarioFacade() {
        super(TipoUsuario.class);
    }

    public boolean isUsuarioListEmpty(TipoUsuario entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<TipoUsuario> tipoUsuario = cq.from(TipoUsuario.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(tipoUsuario, entity), cb.isNotEmpty(tipoUsuario.get(TipoUsuario_.usuarioList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Usuario> findUsuarioList(TipoUsuario entity) {
        TipoUsuario mergedEntity = this.getMergedEntity(entity);
        List<Usuario> usuarioList = mergedEntity.getUsuarioList();
        usuarioList.size();
        return usuarioList;
    }
    
}
