package rest;

import java.io.IOException;

import javax.ws.rs.core.MediaType;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

import entity.Usuario;

public class UsuarioRestTest {

	public static StringBuilder path = new StringBuilder();

	@Test
	public void foo() {
		String url = "http://localhost:8080/kitchensink-example/rest/usuario/foo";
		Client client = Client.create();
		WebResource resource = client.resource(url);
		String stringJson = resource.type(MediaType.APPLICATION_JSON).get(
				String.class);
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			Usuario usuario = objectMapper.readValue(stringJson, Usuario.class);
			Assert.assertNotNull(usuario);
			Assert.assertEquals("Foo", usuario.getNome());
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
