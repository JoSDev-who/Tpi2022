/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.crudbaches.resources;

import com.mycompany.crudbaches.control.TipoObjetoBean;
import com.mycompany.crudbaches.entity.TipoObjeto;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 *
 * @author whoami
 */
@Path("tipoobjeto")
@RequestScoped
public class TipoObjetoResource {
    @Inject
    TipoObjetoBean toBean;
    
    @GET
    @Produces({"application/json; charset=UTF-8"})
    public Response findAll(){
        List<TipoObjeto> registros = toBean.findAll();
        return Response.ok(registros).build();
    
    
    }
}
