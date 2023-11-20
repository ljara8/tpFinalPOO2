package ar.edu.poo2.tpFinal.serviciosYContainers;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import ar.edu.poo2.tpFinal.contyserv.Tanque;

class TestContainerTanque {
	@Mock
	private Tanque containerTanque;
	private int volumenPromedio;

	@BeforeEach
	void setUp() throws Exception {
		containerTanque = mock(Tanque.class);
		volumenPromedio = 5000;

	}

	@Test
	void testVolumenContainerMenorAPromedio() {
		//configuration
		when(containerTanque.calcularVolumen()).thenReturn(4000);
		
		
		
		assertTrue(containerTanque.calcularVolumen() < volumenPromedio );
		
	}

	@Test
	void testVolumenContainerMayorAPromedio() {
		//configuration
		when(containerTanque.calcularVolumen()).thenReturn(6000);
		
		
		
		assertTrue(containerTanque.calcularVolumen() > volumenPromedio );
		
	}

	@Test
	void testVolumenContainerIgualrAPromedio() {
		//configuration
		when(containerTanque.calcularVolumen()).thenReturn(5000);
		
		
		
		assertTrue(containerTanque.calcularVolumen() == volumenPromedio );
		
	}
}