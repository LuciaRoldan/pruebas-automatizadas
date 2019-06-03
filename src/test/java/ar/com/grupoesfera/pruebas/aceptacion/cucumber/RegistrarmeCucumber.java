package ar.com.grupoesfera.pruebas.aceptacion.cucumber;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.By;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegistrarmeCucumber extends TestDeAceptacionCucumber {
	
	String url = urlBase + "/nuevo-usuario";
	
	@Given("que no existe el usuario (.*)")
	public void noExisteElUsuario(String usuario) {
		
	}
	
	@Given("que ya existe el usuario (.*)")
	public void yaExisteElUsuario(String usuario) {
		seleniumDriver.get(url);
		
		seleniumDriver.findElement(By.id("email")).sendKeys(usuario);
		seleniumDriver.findElement(By.id("password")).sendKeys("1234");
		seleniumDriver.findElement(By.id("btn-registrarme")).click();
	}
	
	@When("me registro con el usuario (.*) y la pass (.*)")
	public void meRegistroConElUsuarioYPass(String usuario, String pass) {
		seleniumDriver.get(url);
		
		seleniumDriver.findElement(By.id("email")).sendKeys(usuario);
		seleniumDriver.findElement(By.id("password")).sendKeys(pass);
		seleniumDriver.findElement(By.id("btn-registrarme")).click();
	}


	@Then("sale mensaje de error (.*)")
	public void sale_mensaje_de_error(String mensaje) {
		assertThat(seleniumDriver.getPageSource()).contains(mensaje);
	}
	
	@Then("estoy en (.*)")
	public void estoyEn(String pantalla) {
		assertThat(seleniumDriver.getCurrentUrl()).contains(pantalla);
	}
	
	@When("me loggeo con el usuario (.*) y la pass (.*)")
	public void meRLoggeoConElUsuarioYPass(String usuario, String pass) {
		seleniumDriver.get(urlBase + "/login");
		
		seleniumDriver.findElement(By.id("email")).sendKeys(usuario);
		seleniumDriver.findElement(By.id("password")).sendKeys(pass);
		seleniumDriver.findElement(By.id("btn-login")).click();
	}

	@After()
	public void reset() {
		seleniumDriver.quit();
	}
	
}
