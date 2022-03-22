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
        //EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        //EstadoBean instance = (EstadoBean)container.getContext().lookup("java:global/classes/EstadoBean");

        //container.close();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of findByid method, of class EstadoBean.
     */
    @Test
    public void testFindByid() throws Exception {
        System.out.println("findByid");
        Integer id = 1;
        EntityManager mockEM = Mockito.mock(EntityManager.class);
        Estado esperado = new Estado();
        EstadoBean cut = new EstadoBean();

        Mockito.when(mockEM.find(Estado.class, id)).thenReturn(esperado);
        assertThrows(IllegalArgumentException.class, () -> {
            cut.findByid(null);
        });
        assertThrows(IllegalStateException.class, () -> {
            cut.findByid(id);
        });
        cut.em = mockEM;
        Estado Encontrado = cut.findByid(id);
        assertNotNull(Encontrado);
        assertEquals(esperado, Encontrado);

//        EstadoBean espia = Mockito.spy(EstadoBean.class);
//        espia.em = mockEM;
//        espia.findByid(id);
//        Mockito.when(espia.getEntityManager()).thenThrow(NullPointerException.class);
//        Mockito.verify(espia, Mockito.times(1)).getEntityManager();
    }

    /**
     * Test of findAll method, of class EstadoBean.
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");

    }

    /**
     * Test of findRange method, of class EstadoBean.
     */
    @Test
    public void testFindRange() throws Exception {
        System.out.println("findRange");

    }

    /**
     * Test of contar method, of class EstadoBean.
     */
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

//        EstadoBean espia = Mockito.spy(EstadoBean.class);
//        espia.em = mockEM;
//
//        Mockito.when(espia.getEntityManager()).thenThrow(NullPointerException.class);
        try {
            cut.em = null;
            cut.contar();
            fail("em null");
        } catch (Exception e) {
        }
//        Mockito.verify(espia,Mockito.times(1)).getEntityManager();

    }

    /**
     * Test of Modificar method, of class EstadoBean.
     */
    @Test
    public void testModificar() throws Exception {
        System.out.println("Modificar");

        //fail("esto va a fallar");
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

    }

    /**
     * Test of getEntityManager method, of class EstadoBean.
     */
    @Test
    public void testGetEntityManager() throws Exception {
        System.out.println("getEntityManager");

    }
}
