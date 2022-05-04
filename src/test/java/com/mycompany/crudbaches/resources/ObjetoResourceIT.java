/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.crudbaches.resources;

import com.mycompany.crudbaches.JAXRSConfiguration;
import com.mycompany.crudbaches.control.ObjetoBean;
import com.mycompany.crudbaches.control.abstractDataAcces;
import com.mycompany.crudbaches.entity.Objeto;
import java.io.StringReader;
import java.net.URL;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit5.ArquillianExtension;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;



/**
 *
 * @author whoami
 */
@ExtendWith(ArquillianExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ObjetoResourceIT {
    

    @Deployment
    public static WebArchive crearDespliegue() {
        WebArchive salida = ShrinkWrap.create(WebArchive.class)
                .addPackage("com.mycompany.crudbaches.entity")
                .addAsResource("persistence-arquillian.xml")
                .addClass(abstractDataAcces.class)
                .addClass(ObjetoBean.class)
                .addClass(JAXRSConfiguration.class)
                .addClass(ObjetoResource.class)
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsResource("META-INF/sql/datos.sql", "META-INF/sql/datos.sql")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
        System.out.println(salida.toString(true));
        return salida;
    }
    @ArquillianResource
    URL url;

//    @Test
//    @RunAsClient
//    @Order(4)
//    public void testFindAll() {
//        System.out.println("findAllObjeto");
//        
//        int resultadoEsperado = 200;
//        Client cliente = ClientBuilder.newClient();
//        WebTarget target = cliente.target(url.toString() + "resources/");
//        Response respuesta = target.path("objeto").request("application/json").get();
//        assertEquals(resultadoEsperado, respuesta.getStatus());
//        String totalTexto = respuesta.getHeaderString("Total-Registro");
//        assertNotEquals(Integer.valueOf(0), Integer.valueOf(totalTexto));
//        String cuerpoString = respuesta.readEntity(String.class);
//        JsonReader lector = Json.createReader(new StringReader(cuerpoString));
//        JsonArray listaJson = lector.readArray();
//        int totalRegistros = listaJson.size();
//        assertTrue(totalRegistros > 0);
//        System.out.println("\n\n");
//        System.out.println("\n\n");
//        for (int i = 0; i < listaJson.size(); i++) {
//            JsonObject objeto = listaJson.getJsonObject(i);
//            System.out.println("ID: " + objeto.getInt("idObjeto") + " Activo:" + objeto.getBoolean("activo"));
//        }
//    }

    @Test
    @RunAsClient
    @Order(1)
    public void testCrear() {
        System.out.println("Crear Objeto");
        Objeto nuevo = new Objeto();
        nuevo.setIdObjeto(3L);
        nuevo.setNombre("creado desde test objto");

        int resultadoEsperado = 200;
        Client cliente = ClientBuilder.newClient();
        WebTarget target = cliente.target(url.toString() + "resources/");
        Response respuesta = target.path("objeto").request("application/json").post(Entity.entity(nuevo, MediaType.APPLICATION_JSON));
        assertEquals(resultadoEsperado, respuesta.getStatus());
        String registro = respuesta.getHeaderString("Registro-Creado");
        assertNotEquals(null, registro);
        String cuerpoString = respuesta.readEntity(String.class);
        JsonReader lector = Json.createReader(new StringReader(cuerpoString));
        JsonObject objeto = lector.readObject();
        System.out.println("\n\n");
        System.out.println("\n\n");
        System.out.println("Creado " + objeto);
        System.out.println("\n\n");
        System.out.println("\n\n");
    }

    @Test
    @RunAsClient
    @Order(2)
    public void testModificar() {
        System.out.println("Modificar Objeto");
        Objeto nuevo = new Objeto();
        nuevo.setIdObjeto(3L);
        nuevo.setNombre("modificado desde test objeto");

        int resultadoEsperado = 200;
        Client cliente = ClientBuilder.newClient();
        WebTarget target = cliente.target(url.toString() + "resources/");
        Response respuesta = target.path("objeto").request("application/json").put(Entity.entity(nuevo, MediaType.APPLICATION_JSON));
        assertEquals(resultadoEsperado, respuesta.getStatus());
        String registro = respuesta.getHeaderString("Modificado");
        assertNotEquals(null, registro);
        String cuerpoString = respuesta.readEntity(String.class);
        JsonReader lector = Json.createReader(new StringReader(cuerpoString));
        JsonObject objeto = lector.readObject();
        System.out.println("\n\n");
        System.out.println("\n\n");
        System.out.println("Modificado " + objeto);
        System.out.println("\n\n");
        System.out.println("\n\n");

    }

    @Test
    @RunAsClient
    @Order(3)
    public void testEliminar() {
        System.out.println("Eliminar Objeto");
        Objeto nuevo = new Objeto();

        int resultadoEsperado = 200;
        Client cliente = ClientBuilder.newClient();
        WebTarget target = cliente.target(url.toString() + "resources/");
        Response respuesta = target.path("objeto/3").request("application/json").delete();
        assertEquals(resultadoEsperado, respuesta.getStatus());
        String registro = respuesta.getHeaderString("ID-eliminado");
        assertNotEquals(null, registro);
        String cuerpoString = respuesta.readEntity(String.class);
        JsonReader lector = Json.createReader(new StringReader(cuerpoString));
        JsonObject objeto = lector.readObject();

        System.out.println("\n\n");
        System.out.println("\n\n");
        System.out.println("ID:" + objeto.getInt("idObjeto") + " eliminado con exito");
        System.out.println("\n\n");
        System.out.println("\n\n");
    }
    
}
