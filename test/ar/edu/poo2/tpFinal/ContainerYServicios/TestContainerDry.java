package ar.edu.poo2.tpFinal.ContainerYServicios;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import ar.edu.poo2.tpFinal.contyserv.Dry;

class TestContainerDry {
	@Mock
	private Dry containerDry;
	private int volumenPromedio;

	@BeforeEach
	void setUp() throws Exception {
		containerDry = mock(Dry.class);
		volumenPromedio = 5000;

	}

	@Test
	void testVolumenContainerMenorAPromedio() {
		//configuration
		when(containerDry.calcularVolumen()).thenReturn(4000);
		
		
		
		assertTrue(containerDry.calcularVolumen() < volumenPromedio );
		
	}

	@Test
	void testVolumenContainerMayorAPromedio() {
		//configuration
		when(containerDry.calcularVolumen()).thenReturn(6000);
		
		
		
		assertTrue(containerDry.calcularVolumen() > volumenPromedio );
		
	}

	@Test
	void testVolumenContainerIgualrAPromedio() {
		//configuration
		when(containerDry.calcularVolumen()).thenReturn(5000);
		
		
		
		assertTrue(containerDry.calcularVolumen() == volumenPromedio );
		
	}
}