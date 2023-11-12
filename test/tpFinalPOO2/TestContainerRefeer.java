package tpFinalPOO2;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import ar.edu.poo2.tpFinal.contyserv.Refeer;

class TestContainerRefeer {
	@Mock
	private Refeer containerRefeer;
	private int volumenPromedio;
	private double consumoKwPromedio;

	@BeforeEach
	void setUp() throws Exception {
		containerRefeer = mock(Refeer.class);
		volumenPromedio = 5000;
		consumoKwPromedio = 500;

	}

	@Test
	void testVolumenContainerNoIgualAPromedio() {
		//configuration
		when(containerRefeer.calcularVolumen()).thenReturn(4000);
	
		
		
		
		assertFalse(containerRefeer.calcularVolumen() == volumenPromedio );
		
	}

	@Test
	void testVolumenContainerMenorAPromedio() {
		//configuration
		when(containerRefeer.calcularVolumen()).thenReturn(4000);
		
		
		
		assertTrue(containerRefeer.calcularVolumen() < volumenPromedio );
		
	}

	@Test
	void testVolumenContainerMayorAPromedio() {
		//configuration
		when(containerRefeer.calcularVolumen()).thenReturn(6000);
		
		
		
		assertTrue(containerRefeer.calcularVolumen() > volumenPromedio );
		
	}

	@Test
	void testVolumenContainerIgualrAPromedio() {
		//configuration
		when(containerRefeer.calcularVolumen()).thenReturn(5000);
		
		
		
		assertTrue(containerRefeer.calcularVolumen() == volumenPromedio );
		
	}

	@Test
	void testKwPorHoraMayorAPromedio() {
		when(containerRefeer.getKwPorHora()).thenReturn(550.5);
		
		assertTrue(containerRefeer.getKwPorHora() > consumoKwPromedio );
	}

	@Test
	void testKwPorHoraMenorAPromedio() {
		when(containerRefeer.getKwPorHora()).thenReturn(49.5);
		
		assertTrue(containerRefeer.getKwPorHora() < consumoKwPromedio );
	}

	@Test
	void testKwPorHoraIgualAPromedio() {
		when(containerRefeer.getKwPorHora()).thenReturn(500.00);
		
		assertTrue(containerRefeer.getKwPorHora() == consumoKwPromedio );
	}

}
