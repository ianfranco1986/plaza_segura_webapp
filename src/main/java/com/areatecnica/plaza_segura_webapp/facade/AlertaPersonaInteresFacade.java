/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.areatecnica.plaza_segura_webapp.facade;

import com.areatecnica.plaza_segura_webapp.entities.AlertaPersonaInteres;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.areatecnica.plaza_segura_webapp.entities.AlertaPersonaInteres_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.areatecnica.plaza_segura_webapp.entities.Alerta;
import com.areatecnica.plaza_segura_webapp.entities.PersonaInteres;

/**
 *
 * @author ianfr
 */
@Stateless
public class AlertaPersonaInteresFacade extends AbstractFacade<AlertaPersonaInteres> {

    @PersistenceContext(unitName = "com.areatecnica_plaza_segura_webapp_war_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AlertaPersonaInteresFacade() {
        super(AlertaPersonaInteres.class);
    }

    public boolean isAlertaPersonaInteresIdAlertaEmpty(AlertaPersonaInteres entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<AlertaPersonaInteres> alertaPersonaInteres = cq.from(AlertaPersonaInteres.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(alertaPersonaInteres, entity), cb.isNotNull(alertaPersonaInteres.get(AlertaPersonaInteres_.alertaPersonaInteresIdAlerta)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Alerta findAlertaPersonaInteresIdAlerta(AlertaPersonaInteres entity) {
        return this.getMergedEntity(entity).getAlertaPersonaInteresIdAlerta();
    }

    public boolean isAlertaPersonaInteresIdPersonaEmpty(AlertaPersonaInteres entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<AlertaPersonaInteres> alertaPersonaInteres = cq.from(AlertaPersonaInteres.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(alertaPersonaInteres, entity), cb.isNotNull(alertaPersonaInteres.get(AlertaPersonaInteres_.alertaPersonaInteresIdPersona)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public PersonaInteres findAlertaPersonaInteresIdPersona(AlertaPersonaInteres entity) {
        return this.getMergedEntity(entity).getAlertaPersonaInteresIdPersona();
    }
    
}
