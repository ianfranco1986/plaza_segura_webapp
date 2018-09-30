/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.areatecnica.plaza_segura_webapp.facade;

import com.areatecnica.plaza_segura_webapp.entities.Region;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.areatecnica.plaza_segura_webapp.entities.Region_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.areatecnica.plaza_segura_webapp.entities.Ciudad;
import java.util.List;

/**
 *
 * @author ianfr
 */
@Stateless
public class RegionFacade extends AbstractFacade<Region> {

    @PersistenceContext(unitName = "com.areatecnica_plaza_segura_webapp_war_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RegionFacade() {
        super(Region.class);
    }

    public boolean isCiudadListEmpty(Region entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Region> region = cq.from(Region.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(region, entity), cb.isNotEmpty(region.get(Region_.ciudadList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Ciudad> findCiudadList(Region entity) {
        Region mergedEntity = this.getMergedEntity(entity);
        List<Ciudad> ciudadList = mergedEntity.getCiudadList();
        ciudadList.size();
        return ciudadList;
    }
    
}
