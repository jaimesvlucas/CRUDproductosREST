/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.List;
import javax.json.Json;
import javax.json.JsonBuilderFactory;
import javax.json.JsonObject;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import modelo.Productos;
import modelo.ProductosCRUD;

/**
 * REST Web Service
 *
 * @author DAW-B
 */
@Path("rest")
public class RestProductos {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of RestProductos
     */
    public RestProductos() {
    }

    /**
     * Retrieves representation of an instance of controlador.RestProductos
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/persona")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson() {
        JsonBuilderFactory factory = Json.createBuilderFactory(null);
        /* JsonObject persona = factory.createObjectBuilder()
        .add("nombre", "Juan")
        .add("apellido", "Sanchez")
        .add("edad", 25)
        .add("direccion", factory.createObjectBuilder()
          .add("calle", "Norte 21")
          .add("ciudad", "Alcázar")
          .add("provincia", "Ciudad Real")
          .add("codpostal", "10021"))
        .add("telefono", factory.createArrayBuilder()
            .add(factory.createObjectBuilder()
              .add("tipo", "casa")
              .add("numero", "212 555-1234"))
            .add(factory.createObjectBuilder()
              .add("tipo", "fax")
              .add("numero", "646 555-4567")))
      .build();*/
      String persona = "[\"nombre\":\"Juan\",\"contraseña\":\"1234\",\"pais\":\"España\"]";  
      ResponseBuilder res = Response.ok(persona.toString());   
        return res.build();
    }
    
    @GET
    @Path("/producto/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Productos getProductoJson(@PathParam("id") int id) {
        Productos miProducto = ProductosCRUD.getProducto(id);
        return miProducto;
    }
    
    @GET
    @Path("/productos/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Productos> getProductos() {
        List<Productos> miProducto = ProductosCRUD.getProductos();
        return miProducto;
    }
    
    @PUT
    @Path("/producto/")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Productos updateProductos(Productos p) {
        ProductosCRUD.actualizaProducto(p);
        return p;
    }
    
    @POST
    @Path("/producto/")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void setProducto(Productos p) {
        ProductosCRUD.insertaProducto(p);
    }
    
    @DELETE
    @Path("/producto/{id}")
    public void deleteProducto(@PathParam("id") int id) {
        ProductosCRUD.destroyProducto(id);
    }
    
    
    /*@GET
    public Response ping(){
        return Response
                .ok("ping")
                .build();
    }*/
    
    @GET
    @Path("rest2")
    public String rest2(){
        return "Probando rest";
    }
    
    @GET
    @Path("test/{nombre}")
    public String nombre(@PathParam("nombre") String nombre){
        return "hola "+nombre;
    }

    /**
     * PUT method for updating or creating an instance of RestProductos
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
