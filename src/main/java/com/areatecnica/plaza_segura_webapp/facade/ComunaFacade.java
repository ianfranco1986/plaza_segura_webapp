/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.areatecnica.plaza_segura_webapp.facade;

import com.areatecnica.plaza_segura_webapp.entities.Comuna;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.areatecnica.plaza_segura_webapp.entities.Comuna_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.areatecnica.plaza_segura_webapp.entities.Camara;
import com.areatecnica.plaza_segura_webapp.entities.Ciudad;
import java.util.List;

/**
 *
 * @author ianfr
 */
@Stateless
public class ComunaFacade extends AbstractFacade<Comuna> {

    @PersistenceContext(unitName = "com.areatecnica_plaza_segura_webapp_war_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ComunaFacade() {
        super(Comuna.class);
    }

    public boolean isCamaraListEmpty(Comuna entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Comuna> comuna = cq.from(Comuna.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(comuna, entity), cb.isNotEmpty(comuna.get(Comuna_.camaraList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Camara> findCamaraList(Comuna entity) {
        Comuna mergedEntity = this.getMergedEntity(entity);
        List<Camara> camaraList = mergedEntity.getCamaraList();
        camaraList.size();
        return camaraList;
    }

    public boolean isComunaIdCiudadEmpty(Comuna entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Comuna> comuna = cq.from(Comuna.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(comuna, entity), cb.isNotNull(comuna.get(Comuna_.comunaIdCiudad)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Ciudad findComunaIdCiudad(Comuna entity) {
        return this.getMergedEntity(entity).getComunaIdCiudad();
    }
    
}
