package ar.com.grupoesfera.pruebas.aceptacion;

import org.junit.Test;
import org.openqa.selenium.By;

import java.net.HttpURLConnection;
import java.net.URL;

import static org.assertj.core.api.Assertions.assertThat;

public class BasicoAceptacionIT extends TestDeAceptacion {

	@Test
	public void smoke() throws Exception {
		URL url = new URL(urlBase + "/login");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.connect();
		assertThat(connection.getResponseCode()).isEqualTo(200);
	}
	
	@Test
	public void siElRegistroEsExitosoDebeLlevarAlLogin() {
		//preparacion
		String url = urlBase + "/nuevo-usuario";
		
		//ejecucion
		seleniumDriver.get(url);
		seleniumDriver.findElement(By.id("email")).sendKeys("seba@seba.com");
		seleniumDriver.findElement(By.id("password")).sendKeys("1234");
		seleniumDriver.findElement(By.id("btn-registrarme")).click();
		
		//verificacion
		assertThat(seleniumDriver.getCurrentUrl().contains("login"));
	}
	
	@Test
	public void siElRegistroEsExitosoYElUsuarioSeLoggeaDebeLlevarAlHome() {
		//preparacion
		String url = urlBase + "/nuevo-usuario";
		
		//ejecucion
		seleniumDriver.get(url);
		seleniumDriver.findElement(By.id("email")).sendKeys("seba2@seba.com");
		seleniumDriver.findElement(By.id("password")).sendKeys("1234");
		seleniumDriver.findElement(By.id("btn-registrarme")).click();
		
		seleniumDriver.findElement(By.id("email")).sendKeys("seba2@seba.com");
		seleniumDriver.findElement(By.id("password")).sendKeys("1234");
		seleniumDriver.findElement(By.id("btn-login")).click();
		
		//verificacion
		assertThat(seleniumDriver.getCurrentUrl().contains("home"));
	}
	
	@Test
	public void siQuieroRegistrarUnUsuarioExistenteDeberiaSeguirEnRegistro() {
		//preparacion
		String url = urlBase + "/nuevo-usuario";
		
		//ejecucion
		seleniumDriver.get(url);
		seleniumDriver.findElement(By.id("email")).sendKeys("seba3@seba.com");
		seleniumDriver.findElement(By.id("password")).sendKeys("1234");
		seleniumDriver.findElement(By.id("btn-registrarme")).click();
		
		seleniumDriver.get(url);
		seleniumDriver.findElement(By.id("email")).sendKeys("seba3@seba.com");
		seleniumDriver.findElement(By.id("password")).sendKeys("1234");
		seleniumDriver.findElement(By.id("btn-registrarme")).click();
		
		//verificacion
		assertThat(seleniumDriver.getCurrentUrl().contains("nuevo"));
		assertThat(seleniumDriver.getCurrentUrl().contains("El usuario ya existe"));
		
	}
	
	@Test
	public void siQuieroLoggearmeConUnaPassIncorrectaDeberiaNoPoder() {
		//preparacion
		String url = urlBase + "/nuevo-usuario";
		
		//ejecucion
		seleniumDriver.get(url);
		seleniumDriver.findElement(By.id("email")).sendKeys("seba4@seba.com");
		seleniumDriver.findElement(By.id("password")).sendKeys("1234");
		seleniumDriver.findElement(By.id("btn-registrarme")).click();
		
		seleniumDriver.findElement(By.id("email")).sendKeys("seba4@seba.com");
		seleniumDriver.findElement(By.id("password")).sendKeys("123214");
		seleniumDriver.findElement(By.id("btn-login")).click();
		
		//verificacion
		assertThat(seleniumDriver.getCurrentUrl().contains("login"));
		assertThat(seleniumDriver.getCurrentUrl().contains("Usuario o clave incorrecta"));
	}
	
	@Test
	public void siQuieroRegistrarmeConUnMailInvalidoDeberiaNoPoder() {
		//preparacion
		String url = urlBase + "/nuevo-usuario";
		
		//ejecucion
		seleniumDriver.get(url);
		seleniumDriver.findElement(By.id("email")).sendKeys("seba4seba.com");
		seleniumDriver.findElement(By.id("password")).sendKeys("1234");
		seleniumDriver.findElement(By.id("btn-registrarme")).click();
		
		//verificacion
		assertThat(seleniumDriver.getCurrentUrl().contains("nuevo"));
		assertThat(seleniumDriver.getCurrentUrl().contains("El formato del usuario no es una direccion de email válida"));
	}


	@Test
	public void siQuieroLoggearmeConUnUsuarioIncorrectoDeberiaNoPoder() {
		//preparacion
		String url = urlBase + "/nuevo-usuario";
		
		//ejecucion
		seleniumDriver.get(url);
		seleniumDriver.findElement(By.id("email")).sendKeys("seba5@seba.com");
		seleniumDriver.findElement(By.id("password")).sendKeys("1234");
		seleniumDriver.findElement(By.id("btn-registrarme")).click();
		
		seleniumDriver.findElement(By.id("email")).sendKeys("seb@seba.com");
		seleniumDriver.findElement(By.id("password")).sendKeys("1234");
		seleniumDriver.findElement(By.id("btn-login")).click();
		
		//verificacion
		assertThat(seleniumDriver.getCurrentUrl().contains("login"));
		assertThat(seleniumDriver.getCurrentUrl().contains("Usuario o clave incorrecta"));
	}
}
