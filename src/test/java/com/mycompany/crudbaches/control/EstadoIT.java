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

@ExtendWith(ArquillianExtension.class)
public class EstadoIT {

    @Deployment
    public static WebArchive crearDespliegue() {
        WebArchive salida = ShrinkWrap.create(WebArchive.class)
                .addPackage("sv.edu.ues.occ.ingenieria.tpi135.bachestpi.resources.entity")
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
    public void testCrear() {
        System.out.println("Crear");
        assertNotNull(cut);
        Estado nuevo = new Estado();
        nuevo.setNombre("creado IT " + System.currentTimeMillis());
        cut.crear(nuevo);
        System.out.println("jalo");

    }


    @Test
    public void testFindByid() {
        System.out.println("FindId");
        assertNotNull(cut);
        Estado nuevo = new Estado();
        Integer id = 4;
        Estado Result = cut.findByid(id);
        System.out.println("Se encontro " + Result.getNombre());

    }
    
    @Test
    public void testModificar() {
        System.out.println("Modificar");

        assertNotNull(cut);
        int id = 4;
        Estado nuevo = new Estado();
        nuevo.setIdEstado(id);
        nuevo.setNombre("holadsdsdsd");
        System.out.println("Modificar Estado nuevo " + nuevo);
        cut.Modificar(nuevo);
        System.out.println("Paso Modificar " + cut.findByid(id));
    }

    @Test
    public void testFindAll() {
        System.out.println("findAll");
        assertNotNull(cut);
        List<Estado> resultado = cut.findAll();
        assertNotNull(resultado);
        assertTrue(!resultado.isEmpty());
        System.out.println("La lista posee " + resultado.size());
    }

    @Test
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
    public void testContar() {
        System.out.println("Contar");
        assertNotNull(cut);
        Long resultado = cut.contar();
        assertNotNull(resultado);
        System.out.println("hay " + resultado);

    }

    @Test
    public void testEliminar() {
        System.out.println("Eliminar");
        assertNotNull(cut);
        Estado eliminado = new Estado(2);
        cut.eliminar(eliminado);
        System.out.println("Eliminado el Registro "+ eliminado);

    }

}
