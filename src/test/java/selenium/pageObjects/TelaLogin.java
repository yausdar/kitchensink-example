package selenium.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TelaLogin {

	private static WebDriver driver;

	public TelaLogin(WebDriver driver) {
		TelaLogin.driver = driver;
	}

	public void login(String email, String senha) {
		driver.get("http://localhost:8080/kitchensink-example/usuario/login.xhtml");
		driver.findElement(By.id("inputEmail")).sendKeys(email);
		driver.findElement(By.id("inputSenha")).sendKeys(senha);
		driver.findElement(By.id("buttonSubmit")).click();
	}

}
