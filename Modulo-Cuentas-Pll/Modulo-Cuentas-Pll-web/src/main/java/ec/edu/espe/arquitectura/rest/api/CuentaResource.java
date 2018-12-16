/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.rest.api;

import ec.edu.espe.arquitectura.model.Cuenta;
import ec.edu.espe.arquitectura.service.CuentaService;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Jefferson
 */
@Path("cuenta")
@RequestScoped
public class CuentaResource {

    @Context
    private UriInfo context;
    @Inject
    private CuentaService cuentaService;
    private List<Cuenta> lstCuentas;

    /**
     * Creates a new instance of CuentaResource
     */
    public CuentaResource() {
    }

    /**
     * Retrieves representation of an instance of ec.edu.espe.arquitectura.rest.api.CuentaResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("{cedula}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson(@PathParam("cedula")String cedula) {
        //TODO return proper representation object
        lstCuentas = cuentaService.obtenerPorCedulaCliente(cedula);
        GenericEntity generic = new GenericEntity<List<Cuenta>>(lstCuentas){};
        
        return Response.ok(generic).build();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson() {
        //TODO return proper representation object
        lstCuentas = cuentaService.obtenerTodos();
        GenericEntity generic = new GenericEntity<List<Cuenta>>(lstCuentas){};
        
        return Response.ok(generic).build();
    }

    /**
     * PUT method for updating or creating an instance of CuentaResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
