/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.areatecnica.plaza_segura.webapp.dao;


import com.areatecnica.plaza_segura_webapp.entities.Alerta;
import com.areatecnica.plaza_segura_webapp.entities.Rol;
import java.util.List;

/**
 *
 * @author ianfr
 * @param <T>
 */
public interface IAlertaDao<T> extends IGenericDAO<T> {

    public List<Alerta> findAllByRol(Rol rol);

}
