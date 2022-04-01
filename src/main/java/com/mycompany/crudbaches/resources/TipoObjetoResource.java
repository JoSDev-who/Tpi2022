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
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
    public Response findAll() {
        List<TipoObjeto> registros = toBean.findAll();
        Long total = toBean.contar();

        return Response.ok(registros)
                .header("Total-Registro", total)
                .build();

    }

    @POST
    public Response crea(TipoObjeto nuevo) {
        nuevo.setActivo(Boolean.TRUE);
        toBean.crear(nuevo);
        return Response.ok(nuevo)
                .build();
    }

    @PUT
    public Response modificar(TipoObjeto edit) {
        
        edit.setActivo(Boolean.FALSE);
        
        toBean.Modificar(edit);
        return Response.ok(edit)
                .build();

    }
    
    @DELETE
    @Path("{userId}")
    public Response eliminar(TipoObjeto eliminar,@PathParam("userId") int id){
        eliminar.setIdTipoObjeto(id);
        toBean.eliminar(eliminar);
        return Response.ok(eliminar)
                .header("iD eliminado: ", id)
                .build();
    }
    
}
