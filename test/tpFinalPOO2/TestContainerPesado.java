package tpFinalPOO2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import ar.edu.poo2.tpFinal.contyserv.Dry;

class TestContainerPesado {
	@Mock
	private Dry containerDry;
	private int maximoPermitido;

	@BeforeEach
	void setUp() throws Exception {
		containerDry = mock(Dry.class);
		maximoPermitido = 70;

	}

	@Test
	void testVolumenContainerIgualA70() {
		//configuration
		when(containerDry.getLargo()).thenReturn(20);
		when(containerDry.getAltura()).thenReturn(30);
		when(containerDry.getAncho()).thenReturn(40);
		
		

		
		assertEquals(containerDry.calcularVolumen(), this.maximoPermitido);
		
	}

	@Test
	void testVolumenContainerMayorA70() {
		//configuration
		when(containerDry.getLargo()).thenReturn(20);
		when(containerDry.getAltura()).thenReturn(30);
		when(containerDry.getAncho()).thenReturn(40);
		
		
		//exercise
		containerDry.calcularVolumen();
		
		assertTrue(containerDry.calcularVolumen() >  this.maximoPermitido);
		
	}

	@Test
	void testVolumenContainerMenorA70() {
		//configuration
		when(containerDry.getLargo()).thenReturn(20);
		when(containerDry.getAltura()).thenReturn(30);
		when(containerDry.getAncho()).thenReturn(40);
		
		
		//exercise
		containerDry.calcularVolumen();
		
		assertTrue(containerDry.calcularVolumen() < this.maximoPermitido);
		
	}
}