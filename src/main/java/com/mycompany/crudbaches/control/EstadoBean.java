package com.mycompany.crudbaches.control;

import com.mycompany.crudbaches.entity.Estado;
import java.io.Serializable;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
public class EstadoBean extends abstractDataAcces<Estado> implements Serializable {

    @PersistenceContext(unitName = "baches-PU")
    EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public EstadoBean() {
        super(Estado.class);
    }

}
