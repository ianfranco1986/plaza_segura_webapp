/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.areatecnica.plaza_segura.webapp.dao;

import com.areatecnica.plaza_segura_webapp.entities.Comuna;
import java.util.List;

/**
 *
 * @author ianfr
 * @param <T>
 */
public interface IComunaDao<T> extends IGenericDAO<T> {

    public List<Comuna> find();

}
