/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.crudbaches.control;

import com.mycompany.crudbaches.entity.Estado;
import java.util.List;
import javax.inject.Inject;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit5.ArquillianExtension;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;

@ExtendWith(ArquillianExtension.class)
@TestMethodOrder(OrderAnnotation.class)
public class EstadoIT {

    @Deployment
    public static WebArchive crearDespliegue() {
        WebArchive salida = ShrinkWrap.create(WebArchive.class)
                .addPackage("com.mycompany.cudbaches.entity")
                .addAsResource("persistence-arquillian.xml")
                .addClass(abstractDataAcces.class)
                .addClass(EstadoBean.class)
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsResource("META-INF/sql/datos.sql", "META-INF/sql/datos.sql")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
        System.out.println(salida.toString(true));
        return salida;
    }

    @Inject
    EstadoBean cut;

    @Test
    @Order(1)
    public void testCrear() {
        System.out.println("Crear");
        assertNotNull(cut);
        Estado nuevo = new Estado();
        nuevo.setNombre("creado IT " + System.currentTimeMillis());
        cut.crear(nuevo);
       

    }


    @Test
    @Order(7)
    public void testFindByid() {
        System.out.println("FindId");
        assertNotNull(cut);
        Estado nuevo = new Estado();
        Integer id = 4;
        Estado Result = cut.findByid(id);
        System.out.println("Se encontro " + Result.getNombre());

    }
    
    @Test
    @Order(2)
    public void testModificar() {
        System.out.println("Modificar");

        assertNotNull(cut);
        int id = 4;
        Estado nuevo = new Estado();
        nuevo.setIdEstado(id);
        nuevo.setNombre("modificado prueba 4");
       
        cut.Modificar(nuevo);
        System.out.println("Paso Modificar " + cut.findByid(id));
    }

    @Test
    @Order(3)
    public void testFindAll() {
        System.out.println("findAll");
        assertNotNull(cut);
        List<Estado> resultado = cut.findAll();
        assertNotNull(resultado);
        assertTrue(!resultado.isEmpty());
        System.out.println("La lista posee " + resultado.size());
    }

    @Test
    @Order(4)
    public void testFindRange() {
        System.out.println("FindRange");
        assertNotNull(cut);
        int frist = 1;
        int pageSize = 3;
        List<Estado> resultado = cut.findRange(frist, pageSize);
        assertNotNull(resultado);
        assertTrue(!resultado.isEmpty());
        System.out.println("se encontraron " + resultado.size());

    }

    @Test
    @Order(6)
    public void testContar() {
        System.out.println("Contar");
        assertNotNull(cut);
        Long resultado = cut.contar();
        assertNotNull(resultado);
        System.out.println("hay " + resultado);

    }

    @Test
    @Order(5)
    public void testEliminar() {
        System.out.println("Eliminar");
        assertNotNull(cut);
        Estado eliminado = new Estado(2);
        cut.eliminar(eliminado);
        System.out.println("Eliminado el Registro "+ eliminado);

    }

}
