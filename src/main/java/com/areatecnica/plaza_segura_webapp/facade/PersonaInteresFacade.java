/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.areatecnica.plaza_segura_webapp.facade;

import com.areatecnica.plaza_segura_webapp.entities.PersonaInteres;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.areatecnica.plaza_segura_webapp.entities.PersonaInteres_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.areatecnica.plaza_segura_webapp.entities.Nacionalidad;
import com.areatecnica.plaza_segura_webapp.entities.AlertaPersonaInteres;
import com.areatecnica.plaza_segura_webapp.entities.Antecedentes;
import java.util.List;

/**
 *
 * @author ianfr
 */
@Stateless
public class PersonaInteresFacade extends AbstractFacade<PersonaInteres> {

    @PersistenceContext(unitName = "com.areatecnica_plaza_segura_webapp_war_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersonaInteresFacade() {
        super(PersonaInteres.class);
    }

    public boolean isPersonaInteresIdNacionalidadEmpty(PersonaInteres entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<PersonaInteres> personaInteres = cq.from(PersonaInteres.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(personaInteres, entity), cb.isNotNull(personaInteres.get(PersonaInteres_.personaInteresIdNacionalidad)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Nacionalidad findPersonaInteresIdNacionalidad(PersonaInteres entity) {
        return this.getMergedEntity(entity).getPersonaInteresIdNacionalidad();
    }

    public boolean isAlertaPersonaInteresListEmpty(PersonaInteres entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<PersonaInteres> personaInteres = cq.from(PersonaInteres.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(personaInteres, entity), cb.isNotEmpty(personaInteres.get(PersonaInteres_.alertaPersonaInteresList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<AlertaPersonaInteres> findAlertaPersonaInteresList(PersonaInteres entity) {
        PersonaInteres mergedEntity = this.getMergedEntity(entity);
        List<AlertaPersonaInteres> alertaPersonaInteresList = mergedEntity.getAlertaPersonaInteresList();
        alertaPersonaInteresList.size();
        return alertaPersonaInteresList;
    }

    public boolean isAntecedentesListEmpty(PersonaInteres entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<PersonaInteres> personaInteres = cq.from(PersonaInteres.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(personaInteres, entity), cb.isNotEmpty(personaInteres.get(PersonaInteres_.antecedentesList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Antecedentes> findAntecedentesList(PersonaInteres entity) {
        PersonaInteres mergedEntity = this.getMergedEntity(entity);
        List<Antecedentes> antecedentesList = mergedEntity.getAntecedentesList();
        antecedentesList.size();
        return antecedentesList;
    }
    
}
