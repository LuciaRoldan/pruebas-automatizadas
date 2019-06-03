package ar.com.grupoesfera.pruebas.tragamonedas;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import org.junit.Test;

public class TragamonedasTest {

	@Test
	public void alActivarDeberianGirarTodos() {
		Tambor tambor1 = new Tambor();
		Tambor tambor2 = new Tambor();
		Tambor tambor3 = new Tambor();
		
		Tragamonedas tragamonedas = new Tragamonedas(tambor1, tambor2, tambor3);
		
		tragamonedas.activar();
		
		assertThat(tambor1.obtenerPosicion()).isBetween(1, 8);
		assertThat(tambor2.obtenerPosicion()).isBetween(1, 8);
		assertThat(tambor3.obtenerPosicion()).isBetween(1, 8);
	}
	
	@Test
	public void siNoLoGiroDeberiaDarPremio() {
		Tambor tambor1 = new Tambor();
		Tambor tambor2 = new Tambor();
		Tambor tambor3 = new Tambor();
		
		Tragamonedas tragamonedas = new Tragamonedas(tambor1, tambor2, tambor3);
		
		assertThat(tragamonedas.entregaPremio()).isTrue();
	}
	
	@Test
	public void siLos3SonDistintosDeberiaNoDarPremio() {
		
		Tambor t1 = mock(Tambor.class);
		Tambor t2 = mock(Tambor.class);
		Tambor t3 = mock(Tambor.class);
		
		when(t1.obtenerPosicion()).thenReturn(2);
		when(t2.obtenerPosicion()).thenReturn(3);
		when(t3.obtenerPosicion()).thenReturn(4);
		
		Tragamonedas tragamonedas = new Tragamonedas(t1, t2, t3);
		
		tragamonedas.activar();
		
		assertThat(tragamonedas.entregaPremio()).isFalse();
	}
	
	@Test
	public void siLos3SonIgualessDeberiaDarPremio() {
		
		Tambor t1 = mock(Tambor.class);
		Tambor t2 = mock(Tambor.class);
		Tambor t3 = mock(Tambor.class);
		
		when(t1.obtenerPosicion()).thenReturn(3);
		when(t2.obtenerPosicion()).thenReturn(3);
		when(t3.obtenerPosicion()).thenReturn(3);
		
		Tragamonedas tragamonedas = new Tragamonedas(t1, t2, t3);
		
		tragamonedas.activar();
		
		assertThat(tragamonedas.entregaPremio()).isTrue();
	}
}
