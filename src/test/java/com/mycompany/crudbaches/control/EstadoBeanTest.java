/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.crudbaches.control;

import com.mycompany.crudbaches.entity.Estado;
import java.util.List;
import javax.ejb.embeddable.EJBContainer;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Matchers;
import org.mockito.Mockito;

/**
 *
 * @author josem
 */
public class EstadoBeanTest {

    public EstadoBeanTest() {
    }

    /**
     * Test of crear method, of class EstadoBean.
     */
    @Test
    public void testCrear() throws Exception {
        System.out.println("crear");
        Estado nuevo = new Estado();
        EstadoBean cut = new EstadoBean();
        assertThrows(IllegalArgumentException.class, () -> {
            cut.crear(null);
        });
        assertThrows(IllegalStateException.class, () -> {
            cut.crear(nuevo);
        });
        EntityManager mockEM = Mockito.mock(EntityManager.class);
        cut.em = mockEM;
        cut.crear(nuevo);
        EstadoBean espia = Mockito.spy(EstadoBean.class);
        espia.em = mockEM;

        Mockito.when(espia.getEntityManager()).thenThrow(NullPointerException.class);
        try {
            espia.crear(nuevo);
        } catch (Exception e) {
        }
        Mockito.verify(espia, Mockito.times(1)).getEntityManager();

    }

    /**
     * Test of findByid method, of class EstadoBean.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        Integer id = 1;
        EntityManager mockEM = Mockito.mock(EntityManager.class);
        EstadoBean cut = new EstadoBean();
        Estado esperado = new Estado();
        Mockito.when(mockEM.find(Estado.class, id)).thenReturn(esperado);
        assertThrows(IllegalArgumentException.class, () -> {
            cut.findByid(null);
        });
        assertThrows(IllegalStateException.class, () -> {
            cut.findByid(id);
        });

        cut.em = mockEM;
        Estado encontrado = cut.findByid(id);
        assertNotNull(encontrado);
        assertEquals(esperado, encontrado);

        EstadoBean espia = Mockito.spy(EstadoBean.class);
        espia.em = mockEM;

        Mockito.when(espia.getEntityManager()).thenThrow(NullPointerException.class);
        try {
            espia.findByid(id);
        } catch (Exception e) {
        }
        Mockito.verify(espia, Mockito.times(1)).getEntityManager();

    }

    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
//
//        EstadoBean cut = new EstadoBean();
//        EstadoBean aa = Mockito.mock(EstadoBean.class);
//
//        assertThrows(IllegalStateException.class, () -> {
//            cut.findAll();
//        });
//        
//        
//        List esperado = Mockito.mock(List.class);
//        EntityManager mockEM = Mockito.mock(EntityManager.class);
//        TypedQuery mockTQ = Mockito.mock(TypedQuery.class);
//        List mockList = Mockito.mock(List.class);
//
//        Mockito.when(cut.generarConsultaBase(mockEM)).thenReturn(mockTQ);
//        Mockito.when(mockTQ.getResultList()).thenReturn(esperado);
// 
//        cut.em = mockEM;
//        List<Estado> encontrado = cut.findAll();
//        assertNotNull(encontrado);
        //assertEquals(esperado, encontrado);
    }

    @Test
    public void testFindRange() throws Exception {
        System.out.println("findRange");
//        int frist = 0, pageSize = 0;
//        EstadoBean cut = new EstadoBean();
//
//        assertThrows(IllegalStateException.class, () -> {
//            cut.findRange(frist, pageSize);
//        });

    }

    @Test
    public void testContar() throws Exception {
        System.out.println("contar");
        Long esperado = Long.valueOf(1);
        EntityManager mockEM = Mockito.mock(EntityManager.class);

        CriteriaBuilder mockCB = Mockito.mock(CriteriaBuilder.class);
        CriteriaQuery mockCQ = Mockito.mock(CriteriaQuery.class);
        TypedQuery mockTQ = Mockito.mock(TypedQuery.class);

        Mockito.when(mockEM.getCriteriaBuilder()).thenReturn(mockCB);
        Mockito.when(mockCB.createQuery(Long.class)).thenReturn(mockCQ);
        Mockito.when(mockEM.createQuery(mockCQ)).thenReturn(mockTQ);
        Mockito.when(mockTQ.getSingleResult()).thenReturn(esperado);
        EstadoBean cut = new EstadoBean();

        assertThrows(IllegalArgumentException.class, () -> {
            cut.contar();
        });

        cut.em = mockEM;
        Long resultado = cut.contar();
        assertNotNull(resultado);
        assertEquals(esperado, resultado);

        EstadoBean espia = Mockito.spy(EstadoBean.class);
        espia.em = mockEM;

        Mockito.when(espia.getEntityManager()).thenThrow(NullPointerException.class);
        try {
            espia.contar();
        } catch (Exception e) {
        }
        Mockito.verify(espia, Mockito.times(1)).getEntityManager();

    }

    @Test
    public void testGenerarConsultaBase() throws Exception {
        System.out.println("Generar consulta base");
        EstadoBean cut = new EstadoBean();

        EntityManager mockEM = Mockito.mock(EntityManager.class);
        CriteriaBuilder mockCB = Mockito.mock(CriteriaBuilder.class);
        CriteriaQuery mockCQ = Mockito.mock(CriteriaQuery.class);
        Root<Estado> mockRoot = Mockito.mock(Root.class);
        TypedQuery mockTQ = Mockito.mock(TypedQuery.class);
        TypedQuery esperado = mockEM.createQuery(mockCQ);

        assertThrows(IllegalStateException.class, () -> {
            cut.generarConsultaBase(mockEM);

        });

        Mockito.when(mockEM.getCriteriaBuilder()).thenReturn(mockCB);
        Mockito.when(mockCB.createQuery(Estado.class)).thenReturn(mockCQ);
        Mockito.when(mockCQ.from(Estado.class)).thenReturn(mockRoot);
        

//        Mockito.when(mockTQ.getSingleResult()).thenReturn(esperado);
//        
//
//        //cut.em = mockEM;
//        
//        TypedQuery resultado=cut.generarConsultaBase(mockEM);
//        assertNotNull(resultado);
//        assertEquals(esperado, resultado);
//        
    }

    /**
     * Test of Modificar method, of class EstadoBean.
     */
    @Test
    public void testModificar() throws Exception {
        System.out.println("Modificar");
        int id = 1;
        EntityManager mockEM = Mockito.mock(EntityManager.class);

        Estado nuevo = new Estado(2);
        EstadoBean cut = new EstadoBean();

        assertThrows(IllegalArgumentException.class, () -> {
            cut.Modificar(null, id);
        });

        assertThrows(IllegalStateException.class, () -> {
            cut.Modificar(nuevo, id);
        });

        cut.em = mockEM;
        cut.Modificar(nuevo, id);

        EstadoBean espia = Mockito.spy(EstadoBean.class);
        espia.em = mockEM;
        Mockito.when(espia.getEntityManager()).thenThrow(NullPointerException.class);
        try {
            espia.Modificar(nuevo, id);
        } catch (Exception e) {
        }
        Mockito.verify(espia, Mockito.times(1)).getEntityManager();
    }

    /**
     * Test of Eliminar method, of class EstadoBean.
     */
    @Test
    public void testeliminar() throws Exception {
        System.out.println("eliminar");
        EntityManager mockEM = Mockito.mock(EntityManager.class);
        EstadoBean cut = new EstadoBean();
        cut.em = mockEM;
        Estado eliminado = new Estado(1);
        cut.eliminar(eliminado);
        Mockito.verify(mockEM, Mockito.times(1)).remove(Matchers.any());

        try {
            cut.eliminar(null);
            fail("el argumento era nulo");

        } catch (IllegalArgumentException e) {

        }
        try {
            cut.em = null;
            cut.eliminar(eliminado);
            fail("el entity era nulo");

        } catch (IllegalStateException e) {

        }

        EstadoBean espia = Mockito.spy(EstadoBean.class);
        espia.em = mockEM;
        Mockito.when(espia.getEntityManager()).thenThrow(NullPointerException.class);
        try {
            espia.eliminar(eliminado);
        } catch (Exception e) {
        }
        Mockito.verify(espia, Mockito.times(1)).getEntityManager();

    }

    /**
     * Test of getEntityManager method, of class EstadoBean.
     */
    @Test
    public void testGetEntityManager() throws Exception {
        System.out.println("getEntityManager");

    }
}
