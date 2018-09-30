/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.areatecnica.plaza_segura_webapp.facade;

import com.areatecnica.plaza_segura_webapp.entities.TipoAlerta;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.areatecnica.plaza_segura_webapp.entities.TipoAlerta_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.areatecnica.plaza_segura_webapp.entities.Alerta;
import java.util.List;

/**
 *
 * @author ianfr
 */
@Stateless
public class TipoAlertaFacade extends AbstractFacade<TipoAlerta> {

    @PersistenceContext(unitName = "com.areatecnica_plaza_segura_webapp_war_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoAlertaFacade() {
        super(TipoAlerta.class);
    }

    public boolean isAlertaListEmpty(TipoAlerta entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<TipoAlerta> tipoAlerta = cq.from(TipoAlerta.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(tipoAlerta, entity), cb.isNotEmpty(tipoAlerta.get(TipoAlerta_.alertaList)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public List<Alerta> findAlertaList(TipoAlerta entity) {
        TipoAlerta mergedEntity = this.getMergedEntity(entity);
        List<Alerta> alertaList = mergedEntity.getAlertaList();
        alertaList.size();
        return alertaList;
    }
    
}
