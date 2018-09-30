/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.areatecnica.plaza_segura_webapp.facade;

import com.areatecnica.plaza_segura_webapp.entities.Nacionalidad;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.areatecnica.plaza_segura_webapp.entities.Nacionalidad_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.areatecnica.plaza_segura_webapp.entities.PersonaInteres;
import java.util.List;

/**
 *
 * @author ianfr
 */
@Stateless
public class NacionalidadFacade extends AbstractFacade<Nacionalidad> {

    @PersistenceContext(unitName = "com.areatecnica_plaza_segura_webapp_war_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NacionalidadFacade() {
        super(Nacionalidad.class);
    }

    public boolean isPersonaInteresListEmpty(Nacionalidad entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Nacionalidad> nacionalidad = cq.from(Nacionalidad.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(nacionalidad, entity), cb.isNotEmpty(nacionalidad.get(Nacionalidad_.personaInteresList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<PersonaInteres> findPersonaInteresList(Nacionalidad entity) {
        Nacionalidad mergedEntity = this.getMergedEntity(entity);
        List<PersonaInteres> personaInteresList = mergedEntity.getPersonaInteresList();
        personaInteresList.size();
        return personaInteresList;
    }
    
}
