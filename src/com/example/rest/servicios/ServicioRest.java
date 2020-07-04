package com.example.rest.servicios;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.example.rest.dao.PaisModel;
import com.example.rest.entidades.Pais;


@Path("/servicios")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class ServicioRest {
	private static final Log log = LogFactory.getLog(ServicioRest.class);
	private PaisModel daoPais = new PaisModel();
	
	
	@GET
	@Path("/pais")
	public Response listarTodos() {
		log.info("listarTodos rest ");
		return Response.ok(daoPais.listarTodos()).build();
	}
	
	@POST
	@Path("/pais")
	public Response registra(Pais obj) {
		log.info("Registra pais " + obj.getIdpais());
		if (daoPais.insertaPais(obj) >0)
			return Response.ok().build();
		else
			return Response.notModified().build();
	}
	
	@PUT
	@Path("/pais")
	public Response atualiza(Pais obj) {
		log.info("Actualiza pais " + obj.getIdpais());
		if (daoPais.actualizaPais(obj) >0)
			return Response.ok().build();
		else
			return Response.notModified().build();
	}

	@DELETE
	@Path("/pais/{idpais}")
	public Response elimina(@PathParam("idpais") int id) {
		log.info("Elimina Pais " + id);
		if (daoPais.eliminaPais(id) > 0)
			return Response.ok().build();
		else
			return Response.notModified().build();
	}


}