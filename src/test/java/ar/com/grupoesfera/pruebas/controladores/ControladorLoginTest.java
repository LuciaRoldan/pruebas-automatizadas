package ar.com.grupoesfera.pruebas.controladores;

import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import ar.com.grupoesfera.pruebas.modelo.Usuario;
import ar.com.grupoesfera.pruebas.servicios.ServicioUsuarioImpl;

public class ControladorLoginTest {
	
	ServicioUsuarioImpl servicio;
	HttpServletRequest request;
	HttpSession session;
	ControladorLogin controlador;
	
	@Before
	public void init() {
		servicio = mock(ServicioUsuarioImpl.class);
		request = mock(HttpServletRequest.class);
		session = mock(HttpSession.class);
		controlador = new ControladorLogin();
		
		controlador.setServicioLogin(servicio);
		
	}
	
	@Test
	public void loginConUsuarioYContraseniaCorrectaDeberiaLlevarAHome() {
		//preparacion
		Usuario usuarioEncontradoMock = mock(Usuario.class);
		when(usuarioEncontradoMock.getRol()).thenReturn("ADMIN");
		when(servicio.consultarUsuario(any(Usuario.class))).thenReturn(usuarioEncontradoMock);
		when(request.getSession()).thenReturn(session);
		
		//ejecucion
		ModelAndView modelAndView = controlador.validarLogin(usuarioEncontradoMock, request);
		
		//validacion
		assertThat(modelAndView.getViewName()).isEqualTo("redirect:/home");
		verify(session,times(1)).setAttribute("ROL", usuarioEncontradoMock.getRol());
	}
	
	@Test
	public void loginConUsuarioYContraseniaIncorrectaDeberiaLlevarAHome() {
		//preparacion
		Usuario usuarioEncontradoMock = mock(Usuario.class);
		when(usuarioEncontradoMock.getRol()).thenReturn("ADMIN");
		when(servicio.consultarUsuario(any(Usuario.class))).thenReturn(null);
		when(request.getSession()).thenReturn(session);
		
		//ejecucion
		ModelAndView modelAndView = controlador.validarLogin(usuarioEncontradoMock, request);
		
		//validacion
		assertThat(modelAndView.getViewName()).isEqualTo("login");
		verify(session,times(0)).setAttribute("ROL", usuarioEncontradoMock.getRol());
	}

}
