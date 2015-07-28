package selenium.pageObjects;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TelaLogin {

	private static WebDriver driver;

	public TelaLogin(WebDriver driver) {
		TelaLogin.driver = driver;
	}

	public void login(String email, String senha) {
		driver.get("http://localhost:8080/kitchensink-example/usuario/login.xhtml");
		driver.findElement(By.id("formContent:inputEmail")).sendKeys(email);
		driver.findElement(By.id("formContent:inputSenha")).sendKeys(senha);
		driver.findElement(By.id("formContent:buttonSubmit")).click();
	}

}
