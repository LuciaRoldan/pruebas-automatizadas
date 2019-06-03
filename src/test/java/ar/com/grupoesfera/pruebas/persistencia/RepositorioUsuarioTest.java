package ar.com.grupoesfera.pruebas.persistencia;

import javax.inject.Inject;
import static org.assertj.core.api.Assertions.*;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.com.grupoesfera.pruebas.SpringTest;
import ar.com.grupoesfera.pruebas.modelo.Usuario;
import ar.com.grupoesfera.pruebas.repositorios.RepositorioUsuario;

public class RepositorioUsuarioTest extends SpringTest{

	@Inject
	private RepositorioUsuario repositorio;
	
	@Test
	@Transactional
	@Rollback
	public void alGuardarUnUsuarioDeberiaPoderEncontrarlo() {
		//preparacion
		Usuario seba = new Usuario();
		seba.setEmail("seba@seba.com");
		seba.setPassword("1234");
		
		//ejecucion
		repositorio.guardar(seba);
		
		//comprobacion
		assertThat(session().get(Usuario.class, seba.getId())).isNotNull();
	}
	
	@Test
	@Transactional
	@Rollback
	public void consultarUnUsuarioExistenteDeberiaPoderEncontrarlo() {
		//preparacion
		Usuario seba = new Usuario();
		seba.setEmail("seba@seba.com");
		seba.setPassword("1234");
		repositorio.guardar(seba);
		
		//ejecucion
		Usuario seba2 = repositorio.consultarUsuario(seba);
		
		//comprobacion
		assertThat(seba).isEqualTo(seba2);
	}
	
	@Test
	@Transactional
	@Rollback
	public void consultarUnUsuarioInexistenteDeberiaNoPoderEncontrarlo() {
		//preparacion
		Usuario seba = new Usuario();
		seba.setEmail("seba@seba.com");
		seba.setPassword("1234");
		
		//ejecucion
		Usuario seba2 = repositorio.consultarUsuario(seba);
		
		//comprobacion
		assertThat(seba2).isNull();
	}
	
	@Test
	@Transactional
	@Rollback
	public void buscarPorMailExistenteDeberiaPoderEncontrarlo() {
		//preparacion
		Usuario seba = new Usuario();
		seba.setEmail("seba@seba.com");
		seba.setPassword("1234");
		repositorio.guardar(seba);
		
		//ejecucion
		Usuario seba2 = repositorio.buscarPor(seba.getEmail());
		
		//comprobacion
		assertThat(seba).isEqualTo(seba2);
	}
	
	@Test
	@Transactional
	@Rollback
	public void buscarPorMailInexistenteDeberiaNoPoderEncontrarlo() {
		//preparacion
		Usuario seba = new Usuario();
		seba.setEmail("seba@seba.com");
		seba.setPassword("1234");
		
		//ejecucion
		Usuario seba2 = repositorio.buscarPor(seba.getEmail());
		
		//comprobacion
		assertThat(seba2).isNull();
	}
}
