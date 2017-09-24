package bddTest;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

public class LoginStepDefinition {

	private WebDriver webDriver;
	public static String curDir = System.getProperty("user.dir");

	@Given("^El usuario esta en la pagina principal de linkedin$")
	public void irALaPaginaDeLinkedin() throws Throwable {
		System.setProperty("webdriver.chrome.driver", curDir + "\\Driver\\chromedriver.exe");
		webDriver = new ChromeDriver();
		webDriver.get("https://www.linkedin.com");
	}

	@When("^El usuario ingresa el email (.+)$")
	public void elUsuarioIngresaElEmail(String email) throws Throwable {
		webDriver.findElement(By.id("login-email")).sendKeys(email);
	}

	@When("^El usuario ingresa el password (.+)$")
	public void elUsuarioIngresaElPassword(String password) throws Throwable {
		webDriver.findElement(By.name("session_password")).sendKeys(password);
		webDriver.findElement(By.id("login-submit")).click();
	}

	@Then("^El login resulta (.+)$")
	public void elLoginResulta(String status) throws Throwable {
		if (webDriver.getCurrentUrl().equalsIgnoreCase("https://www.linkedin.com/uas/login-submit")) {
			System.out.println("Login " +status);
		} else {
			throw new Exception();
		} 
		webDriver.close();
	}

	@When("^El usuario no ingresa el email (.+)$")
	public void elUsuarioNoIngresaElEmail(String email) throws Throwable {
		if (email.equals("-")) {
			webDriver.findElement(By.id("login-email")).sendKeys("");
		} else {
			webDriver.findElement(By.id("login-email")).sendKeys(email);
		}
	}

	@When("^El usuario no ingresa el password (.+)$")
	public void elUsuarioNoIngresaElPassword(String password) throws Throwable {
		if (password.equals("-")) {
			webDriver.findElement(By.name("session_password")).sendKeys("");
		} else {
			webDriver.findElement(By.name("session_password")).sendKeys(password);
		}
		webDriver.findElement(By.id("login-submit")).click();
	}

	@Then("^El boton no realiza accion$")
	public void elBotonNoRealizaAccion() throws Throwable {
		if (webDriver.getCurrentUrl().equalsIgnoreCase("https://www.linkedin.com/")) {
			System.out.println("El boton no realiza accion ");
		} else {
			throw new Exception();
		}
		webDriver.close();
	}
	
	@When("^El usuario ingresa email en un formato incorrecto (.+)$")
	public void elUsuarioIngresaEmailEnUnFormatoIncorrecto(String email) throws Throwable {
		webDriver.findElement(By.id("login-email")).sendKeys(email);
	}

	@When("^El usuario ingresa password en un formato incorrecto (.+)$")
	public void elUsuarioIngresaPasswordEnUnFormatoIncorrecto(String password) throws Throwable {
		webDriver.findElement(By.name("session_password")).sendKeys(password);
		webDriver.findElement(By.id("login-submit")).click();
	}

	@Then("^Redirecciona a relogin$")
	public void redireccionaARelogin() throws Throwable {
		if (webDriver.getCurrentUrl().equalsIgnoreCase("https://www.linkedin.com/home?goback=")) {
			System.out.println("Se redirige al usuario a una pagina de relogin");
		} else {
			throw new Exception();
		}
		webDriver.close();
	}
	
	@When("^Ingresa los datos en los campos correspondientes$")
	public void ingresaLosDatosEnLosCamposCorrespondientes(Map<String, String> data) throws Throwable {
		webDriver.findElement(By.id("login-email")).sendKeys(data.get("email"));
		webDriver.findElement(By.name("session_password")).sendKeys(data.get("password"));
		webDriver.findElement(By.id("login-submit")).click();
	}

	@Then("^El usuario puede ingresar a su cuenta$")
	public void puedeIngresarALinkedin() throws Throwable {
		if (webDriver.getCurrentUrl().equalsIgnoreCase("https://www.linkedin.com/feed/")) {
			System.out.println("Login exitoso");
		} else {
			throw new Exception();
		}
		webDriver.close();
	}

}