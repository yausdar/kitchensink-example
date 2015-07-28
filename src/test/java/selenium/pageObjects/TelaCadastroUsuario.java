package selenium.pageObjects;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TelaCadastroUsuario {

	private static WebDriver driver;

	public TelaCadastroUsuario(WebDriver driver) {
		TelaCadastroUsuario.driver = driver;
	}

	public void cadastrar(String nome, String email, String senha) {
		driver.get("http://localhost:8080/kitchensink-example/usuario/cadastrarUsuario.xhtml");
		driver.findElement(By.id("formContent:inputNome")).sendKeys(nome);
		driver.findElement(By.id("formContent:inputEmail")).sendKeys(email);
		driver.findElement(By.id("formContent:inputSenha")).sendKeys(senha);
		driver.findElement(By.id("formContent:inputConfirmacaoSenha")).sendKeys(
				senha);
		driver.findElement(By.id("formContent:buttonSubmit")).click();
	}

}
