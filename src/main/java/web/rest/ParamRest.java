package web.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import model.entity.Param;
import business.service.ParamService;

@Path("/param")
@RequestScoped
public class ParamRest {

	@EJB
	private ParamService paramService;

	@Path("/save")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Param save(@QueryParam("chave") String chave,
			@QueryParam("valor") String valor,
			@QueryParam("descricao") String descricao) {

		Param param = new Param(chave, valor, descricao);
		paramService.save(param);
		return param;
	}

	@Path("/getListaParam")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Param> getListaParam() {
		return paramService.getListaParam();
	}
	
	@Path("/remove")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String remove(@QueryParam("id") Integer id) {
		paramService.remove(new Param(id));
		return "OK";
	}
	
	

}
