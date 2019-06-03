package ar.com.grupoesfera.pruebas.servicios;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ar.com.grupoesfera.pruebas.modelo.Usuario;
import ar.com.grupoesfera.pruebas.modelo.UsuarioExistente;
import ar.com.grupoesfera.pruebas.repositorios.RepositorioUsuario;

public class ServicioUsuarioTest {

	ServicioUsuarioImpl servicio; 
	RepositorioUsuario repositorio;
	ServicioMail servicioMail;
	
	@Before
	public void init() {
		servicio = new ServicioUsuarioImpl();
		repositorio = mock(RepositorioUsuario.class);
		servicioMail = mock(ServicioMail.class);
		
		servicio.setRepositorioUsuario(repositorio);
		servicio.setServicioMail(servicioMail );
	}
	
	@Test(expected = UsuarioExistente.class)
	public void registrarUsuarioExistenteDeberiaTirarExcepcionUsuarioExistente() throws Exception {
		//preparacion
		Usuario seba = new Usuario();
		seba.setEmail("seba@seba.com");
		seba.setPassword("1234");
		
		//ejecucion
		when(repositorio.buscarPor(seba.getEmail())).thenReturn(seba);
		
		//ejecucion
		servicio.registrar(seba);		
	}		

	@Test
	public void registrarUsuarioInexistenteDeberiaRegistrarse() throws Exception {
		//preparacion
		Usuario seba = new Usuario();
		seba.setEmail("seba@seba.com");
		seba.setPassword("1234");
		
		//ejecucion
		when(repositorio.buscarPor(seba.getEmail())).thenReturn(null);
		servicio.registrar(seba);
	}
	
	@Test
	public void alRegistrarUnUsuarioSeDeberiaEnviarUnMailYGuardarElUsuario() throws Exception {
		//preparacion
		Usuario seba = new Usuario();
		seba.setEmail("seba@seba.com");
		seba.setPassword("1234");
		when(repositorio.buscarPor(seba.getEmail())).thenReturn(null);
		
		//ejecucion
		servicio.registrar(seba);
		
		//verificacion
		verify(servicioMail, times(1)).enviarMailDeBienvenida(seba);
		verify(repositorio, times(1)).guardar(seba);
	}
}
