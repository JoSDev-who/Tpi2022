/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.crudbaches.control;


import com.mycompany.crudbaches.JAXRSConfiguration;
import com.mycompany.crudbaches.resources.TipoObjetoResource;
import java.net.URL;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.eclipse.persistence.jpa.jpql.Assert;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit5.ArquillianExtension;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 *
 * @author josem
 */
@ExtendWith(ArquillianExtension.class)
public class TipoObjetoResourceIT {

    @Deployment
    public static WebArchive crearDespliegue() {
        WebArchive salida = ShrinkWrap.create(WebArchive.class)
                .addPackage("com.mycompany.crudbaches.entity")
                .addAsResource("persistence-arquillian.xml")
                .addClass(abstractDataAcces.class)
                .addClass(TipoObjetoBean.class)
                .addClass(JAXRSConfiguration.class)
                .addClass(TipoObjetoResource.class)
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsResource("META-INF/sql/datos.sql", "META-INF/sql/datos.sql")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
        System.out.println(salida.toString(true));
        return salida;
    }
    @ArquillianResource
    URL url;

    @Test
    @RunAsClient
    public void testFinAll() {
        System.out.println("findAll");
//        int resultadoEsperado = 200;
//        Client cliente=ClientBuilder.newClient();
//        WebTarget target = cliente.target(url.toString() + "resources/");
//        Response respuesta = target.path("tipoobjeto").request("application/json").get();
//        Assertions.assertEquals(resultadoEsperado,respuesta);
    }

}
