/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.crudbaches.control;

import com.mycompany.crudbaches.entity.Objeto;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sun.text.resources.CollationData;

@Stateless
@LocalBean
public class ObjetoBean extends abstractDataAcces<Objeto> implements Serializable {

    @PersistenceContext(unitName = "baches-PU")
    EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ObjetoBean() {
        super(Objeto.class);
    }

    public List<Objeto> findByIdTipoObjeto(final Integer idTipoObjeto, int frist, int pageSize) {
        if (this.em != null && idTipoObjeto != null) {
            Query q = em.createNamedQuery("Objeto.findByTipoObjeto");
            q.setParameter("idTipoObjeto", idTipoObjeto);
            q.setFirstResult(frist);
            q.setMaxResults(pageSize);
            return q.getResultList();
        }
        return Collections.EMPTY_LIST;

    }

    public int countTipoObjeto(final Integer idTipoObjeto) {
        if (this.em != null && idTipoObjeto != null) {
            Query q = em.createNamedQuery("Objeto.countByTipoObjeto");
            q.setParameter("idTipoObjeto", idTipoObjeto);
            
            return ((Long) q.getSingleResult()).intValue(); 
        }
        return 0;
    }

}
