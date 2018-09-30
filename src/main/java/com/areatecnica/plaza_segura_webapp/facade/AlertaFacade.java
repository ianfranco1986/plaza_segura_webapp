/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.areatecnica.plaza_segura_webapp.facade;

import com.areatecnica.plaza_segura_webapp.entities.Alerta;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.areatecnica.plaza_segura_webapp.entities.Alerta_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.areatecnica.plaza_segura_webapp.entities.Camara;
import com.areatecnica.plaza_segura_webapp.entities.TipoAlerta;
import com.areatecnica.plaza_segura_webapp.entities.AlertaPersonaInteres;
import java.util.List;

/**
 *
 * @author ianfr
 */
@Stateless
public class AlertaFacade extends AbstractFacade<Alerta> {

    @PersistenceContext(unitName = "com.areatecnica_plaza_segura_webapp_war_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AlertaFacade() {
        super(Alerta.class);
    }

    public boolean isAlertaIdCamaraEmpty(Alerta entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Alerta> alerta = cq.from(Alerta.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(alerta, entity), cb.isNotNull(alerta.get(Alerta_.alertaIdCamara)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Camara findAlertaIdCamara(Alerta entity) {
        return this.getMergedEntity(entity).getAlertaIdCamara();
    }

    public boolean isAlertaIdTipoEmpty(Alerta entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Alerta> alerta = cq.from(Alerta.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(alerta, entity), cb.isNotNull(alerta.get(Alerta_.alertaIdTipo)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public TipoAlerta findAlertaIdTipo(Alerta entity) {
        return this.getMergedEntity(entity).getAlertaIdTipo();
    }

    public boolean isAlertaPersonaInteresListEmpty(Alerta entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Alerta> alerta = cq.from(Alerta.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(alerta, entity), cb.isNotEmpty(alerta.get(Alerta_.alertaPersonaInteresList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<AlertaPersonaInteres> findAlertaPersonaInteresList(Alerta entity) {
        Alerta mergedEntity = this.getMergedEntity(entity);
        List<AlertaPersonaInteres> alertaPersonaInteresList = mergedEntity.getAlertaPersonaInteresList();
        alertaPersonaInteresList.size();
        return alertaPersonaInteresList;
    }
    
}
