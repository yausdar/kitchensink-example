package business.report;

import java.util.ArrayList;

import model.entity.Usuario;
import model.entity.UsuarioTest;

import org.junit.Test;

import business.report.ReportUsuario;

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
