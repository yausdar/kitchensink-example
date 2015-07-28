package selenium;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import selenium.pageObjects.TelaCadastroUsuario;
import selenium.pageObjects.TelaLogin;

public class CadastroUsuarioTest {

	private static WebDriver driver;
	private TelaCadastroUsuario telaCadastroUsuario;
	private TelaLogin telaLogin;

	@Before
	public void setup() {
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setJavascriptEnabled(true);
		System.setProperty("webdriver.chrome.driver",
				"C:/selenium/chromedriver.exe");
		driver = new ChromeDriver(capabilities);
		telaCadastroUsuario = new TelaCadastroUsuario(driver);
		telaLogin = new TelaLogin(driver);
	}

	@Test
	public void cadastrarNovoUsuario() {
		String nome = "fulano da silva";
		String email = "fulano@mail.com";
		String senha = "password";
		telaCadastroUsuario.cadastrar(nome, email, senha);
		telaLogin.login(email, senha);
	}

}
