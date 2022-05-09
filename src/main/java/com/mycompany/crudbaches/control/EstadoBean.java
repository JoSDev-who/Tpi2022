package com.mycompany.crudbaches.control;

import com.mycompany.crudbaches.entity.Estado;
import java.io.Serializable;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
   
        public List<Estado> findNombre(String nombre){
        
        Query q=em.createNamedQuery("Estado.findByNombre");
        q.setParameter("nombre", nombre);
        
        return q.getResultList();
    }
}
