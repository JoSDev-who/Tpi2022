/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.crudbaches.control;

import com.mycompany.crudbaches.entity.ObjetoEstado;
import java.io.Serializable;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author josem
 */
@Stateless
@LocalBean
public class ObjetoEstadoBean extends abstractDataAcces<ObjetoEstado> implements Serializable {

    @PersistenceContext(unitName = "baches-PU")
    EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public ObjetoEstadoBean() {
        super(ObjetoEstado.class);
    }

}
