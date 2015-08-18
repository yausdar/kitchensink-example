package report;

import java.util.ArrayList;

import model.UsuarioTest;

import org.junit.Test;

import entity.Usuario;

public class ReportUsuarioTest {

	@Test
	public void test() {
		ArrayList<Usuario> listaUsuario = new ArrayList<Usuario>();
		for (int i = 0; i < 10; i++) {
			listaUsuario.add(UsuarioTest.getUsuario());
		}

		ReportUsuario reportUsuario = new ReportUsuario();
		reportUsuario.generate(listaUsuario);

	}

}
