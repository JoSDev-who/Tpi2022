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
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
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
        Object id = new Object();
        EstadoBean cut = new EstadoBean();
        assertThrows(IllegalArgumentException.class, () -> {
            cut.findByid(null);
        });
        assertThrows(IllegalStateException.class, () -> {
            cut.findByid(id);
        });
        EntityManager mockEM = Mockito.mock(EntityManager.class);
        cut.em = mockEM;
        cut.findByid(id);

        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of findAll method, of class EstadoBean.
//     */
//    @Test
//    public void testFindAll() throws Exception {
//        System.out.println("findAll");
//        EstadoBean cut = new EstadoBean();
//        assertThrows(IllegalStateException.class, () -> {
//            cut.findAll();
//        });
//        
//        EntityManager mockEM = Mockito.mock(EntityManager.class);
//        cut.em = mockEM;
//      
//        
//
//    }
//
//    /**
//     * Test of findRange method, of class EstadoBean.
//     */
//    @Test
//    public void testFindRange() throws Exception {
//        System.out.println("findRange");
//        int frist = 0;
//        int pageSize = 0;
//        EstadoBean cut = new EstadoBean();
//        assertThrows(IllegalStateException.class, () -> {
//            cut.findRange(frist, pageSize);
//        });
//        
//        EntityManager mockEM = Mockito.mock(EntityManager.class);
//        cut.em = mockEM;
//        cut.findRange(frist, pageSize);
//    }
//
//    /**
//     * Test of contar method, of class EstadoBean.
//     */
//    @Test
//    public void testContar() throws Exception {
//        System.out.println("contar");
//        EstadoBean cut = new EstadoBean();
//        assertThrows(IllegalStateException.class, () -> {
//            cut.contar();
//        });
//        
//        EntityManager mockEM = Mockito.mock(EntityManager.class);
//        cut.em = mockEM;
//        cut.contar();
//    }
//
//    /**
//     * Test of Modificar method, of class EstadoBean.
//     */
//    @Test
//    public void testModificar() throws Exception {
//        System.out.println("Modificar");
//        long id = 0L;
//        Estado nuevo = new Estado();
//        EstadoBean cut = new EstadoBean();
//        assertThrows(IllegalArgumentException.class, () -> {
//            cut.Modificar(null,id);
//        });
//        assertThrows(IllegalStateException.class, () -> {
//            cut.Modificar(nuevo,id);
//        });
//        EntityManager mockEM = Mockito.mock(EntityManager.class);
//        cut.em = mockEM;
//        cut.Modificar(nuevo,id);
//        //EJBContainer contain
//    }
//
//    /**
//     * Test of Eliminar method, of class EstadoBean.
//     */
//    @Test
//    public void testEliminar() throws Exception {
//        System.out.println("Eliminar");
//        int id = 0;
//        Estado nuevo = new Estado();
//        EstadoBean cut = new EstadoBean();
//        assertThrows(IllegalArgumentException.class, () -> {
//            cut.Eliminar(0);
//        });
//        assertThrows(IllegalStateException.class, () -> {
//            cut.Eliminar(id);
//        });
//        EntityManager mockEM = Mockito.mock(EntityManager.class);
//        cut.em = mockEM;
//        cut.Eliminar(id);
//    }
//
//    /**
//     * Test of getEntityManager method, of class EstadoBean.
//     */
//
//    /**
//     * Test of getEntityManager method, of class EstadoBean.
//     */
////    @Test
////    public void testGetEntityManager() throws Exception {
////        System.out.println("getEntityManager");
////        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
////        EstadoBean instance = (EstadoBean)container.getContext().lookup("java:global/classes/EstadoBean");
////        EntityManager expResult = null;
////        EntityManager result = instance.getEntityManager();
////        assertEquals(expResult, result);
////        container.close();
////        // TODO review the generated test code and remove the default call to fail.
////        fail("The test case is a prototype.");
////    }
////    
}
