/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.areatecnica.plaza_segura_webapp.facade;

import com.areatecnica.plaza_segura_webapp.entities.Camara;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.areatecnica.plaza_segura_webapp.entities.Camara_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.areatecnica.plaza_segura_webapp.entities.Alerta;
import com.areatecnica.plaza_segura_webapp.entities.Comuna;
import com.areatecnica.plaza_segura_webapp.entities.TipoCamara;
import java.util.List;

/**
 *
 * @author ianfr
 */
@Stateless
public class CamaraFacade extends AbstractFacade<Camara> {

    @PersistenceContext(unitName = "com.areatecnica_plaza_segura_webapp_war_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CamaraFacade() {
        super(Camara.class);
    }

    public boolean isAlertaListEmpty(Camara entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Camara> camara = cq.from(Camara.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(camara, entity), cb.isNotEmpty(camara.get(Camara_.alertaList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Alerta> findAlertaList(Camara entity) {
        Camara mergedEntity = this.getMergedEntity(entity);
        List<Alerta> alertaList = mergedEntity.getAlertaList();
        alertaList.size();
        return alertaList;
    }

    public boolean isCamaraIdComunaEmpty(Camara entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Camara> camara = cq.from(Camara.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(camara, entity), cb.isNotNull(camara.get(Camara_.camaraIdComuna)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Comuna findCamaraIdComuna(Camara entity) {
        return this.getMergedEntity(entity).getCamaraIdComuna();
    }

    public boolean isCamaraIdTipoEmpty(Camara entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Camara> camara = cq.from(Camara.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(camara, entity), cb.isNotNull(camara.get(Camara_.camaraIdTipo)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public TipoCamara findCamaraIdTipo(Camara entity) {
        return this.getMergedEntity(entity).getCamaraIdTipo();
    }
    
}
