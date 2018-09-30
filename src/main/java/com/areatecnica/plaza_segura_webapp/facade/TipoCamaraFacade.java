/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.areatecnica.plaza_segura_webapp.facade;

import com.areatecnica.plaza_segura_webapp.entities.TipoCamara;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.areatecnica.plaza_segura_webapp.entities.TipoCamara_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.areatecnica.plaza_segura_webapp.entities.Camara;
import java.util.List;

/**
 *
 * @author ianfr
 */
@Stateless
public class TipoCamaraFacade extends AbstractFacade<TipoCamara> {

    @PersistenceContext(unitName = "com.areatecnica_plaza_segura_webapp_war_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoCamaraFacade() {
        super(TipoCamara.class);
    }

    public boolean isCamaraListEmpty(TipoCamara entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<TipoCamara> tipoCamara = cq.from(TipoCamara.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(tipoCamara, entity), cb.isNotEmpty(tipoCamara.get(TipoCamara_.camaraList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Camara> findCamaraList(TipoCamara entity) {
        TipoCamara mergedEntity = this.getMergedEntity(entity);
        List<Camara> camaraList = mergedEntity.getCamaraList();
        camaraList.size();
        return camaraList;
    }
    
}
