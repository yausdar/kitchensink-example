package web.rest;

import java.io.IOException;

import javax.ws.rs.core.MediaType;

import junit.framework.Assert;
import model.entity.Param;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

public class ParamRestTest {

	public static StringBuilder path = new StringBuilder();

	@Test
	public void save() {
		String url = "http://localhost:8080/kitchensink-example/rest/param/save?chave=chave&valor=valor&descricao=descricao";
		Client client = Client.create();
		WebResource resource = client.resource(url);
		String stringJson = resource.type(MediaType.APPLICATION_JSON).get(
				String.class);
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			Param param = objectMapper.readValue(stringJson, Param.class);
			Assert.assertNotNull(param);
			Assert.assertEquals("descricao", param.getDescricao());
			System.out.println(param);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
