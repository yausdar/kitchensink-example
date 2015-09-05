package selenium.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TelaCadastroUsuario {

	private static WebDriver driver;

	public TelaCadastroUsuario(WebDriver driver) {
		TelaCadastroUsuario.driver = driver;
	}

	public void cadastrar(String nome, String email, String senha) {
		driver.get("http://localhost:8080/kitchensink-example/usuario/cadastrar.xhtml");
		driver.findElement(By.id("inputNome")).sendKeys(nome);
		driver.findElement(By.id("inputEmail")).sendKeys(email);
		driver.findElement(By.id("inputSenha")).sendKeys(senha);
		driver.findElement(By.id("inputConfirmacaoSenha")).sendKeys(senha);
		driver.findElement(By.id("buttonSalvar")).click();
	}

}
