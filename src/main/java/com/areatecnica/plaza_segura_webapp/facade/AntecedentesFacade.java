/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.areatecnica.plaza_segura_webapp.facade;

import com.areatecnica.plaza_segura_webapp.entities.Antecedentes;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.areatecnica.plaza_segura_webapp.entities.Antecedentes_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.areatecnica.plaza_segura_webapp.entities.PersonaInteres;

/**
 *
 * @author ianfr
 */
@Stateless
public class AntecedentesFacade extends AbstractFacade<Antecedentes> {

    @PersistenceContext(unitName = "com.areatecnica_plaza_segura_webapp_war_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AntecedentesFacade() {
        super(Antecedentes.class);
    }

    public boolean isAntecedentesIdPersonaEmpty(Antecedentes entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Antecedentes> antecedentes = cq.from(Antecedentes.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(antecedentes, entity), cb.isNotNull(antecedentes.get(Antecedentes_.antecedentesIdPersona)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public PersonaInteres findAntecedentesIdPersona(Antecedentes entity) {
        return this.getMergedEntity(entity).getAntecedentesIdPersona();
    }
    
}
