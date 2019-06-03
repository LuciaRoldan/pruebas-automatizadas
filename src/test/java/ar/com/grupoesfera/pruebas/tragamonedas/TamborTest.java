package ar.com.grupoesfera.pruebas.tragamonedas;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

public class TamborTest {

	@Test
	public void alGirarDeberiaObtenerUnValorEntre1y8() {
		//preparacion
		Tambor tambor = new Tambor();
		
		//ejecucion
		tambor.girar();
		
		//verificacion
		assertThat(tambor.obtenerPosicion()).isBetween(1, 8);
	}
	
	@Test
	public void siNoGirloDeberiaObtener0() {
		//preparacion
		Tambor tambor = new Tambor();
		
		//ejecucion
		
		//verificacion
		assertThat(tambor.obtenerPosicion()).isEqualTo(0);
	}

}
