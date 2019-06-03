package ar.com.grupoesfera.pruebas.controladores;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import ar.com.grupoesfera.pruebas.modelo.Usuario;
import ar.com.grupoesfera.pruebas.modelo.UsuarioExistente;
import ar.com.grupoesfera.pruebas.servicios.ServicioUsuarioImpl;

public class ControladorRegistrarmeTest {

	ServicioUsuarioImpl servicio;
	ControladorRegistrarme controlador;
	
	@Before
	public void init() {
		servicio = mock(ServicioUsuarioImpl.class);
		controlador = new ControladorRegistrarme();
		
		controlador.setServicio(servicio);
	}
	
	@Test
	public void alRegistrarUnUsuarioValidoDeberiaIrAlLogin() throws UsuarioExistente {
		//preparacion
		Usuario usuario = mock(Usuario.class);
		when(usuario.getEmail()).thenReturn("ADMIN@ADMIN.com");
		when(servicio.consultarUsuario(any(Usuario.class))).thenReturn(usuario);
		
		//ejecucion
		ModelAndView modelAndView = controlador.registrarme(usuario);
		
		//validacion
		assertThat(modelAndView.getViewName()).isEqualTo("redirect:/login");
		verify(servicio, times(1)).registrar(usuario);

	}
	
	@Test
	public void alRegistrarUnUsuarioExistenteDeberiaTirarExcepcionUsuarioExistente() throws UsuarioExistente {
		//preparacion
		Usuario usuario = mock(Usuario.class);
		when(usuario.getEmail()).thenReturn("ADMIN@ADMIN.com");
		doThrow(new UsuarioExistente()).when(servicio).registrar(any(Usuario.class));
		
		//ejecucion
		ModelAndView modelAndView = controlador.registrarme(usuario);
		
		//validacion
		assertThat(modelAndView.getViewName()).isEqualTo("nuevo-usuario");
		verify(servicio, times(1)).registrar(usuario);

	}
}
