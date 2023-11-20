package ar.edu.poo2.tpFinal.serviciosYContainers;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.poo2.tpFinal.contyserv.Pesado;
import ar.edu.poo2.tpFinal.ordenes.Orden;

class TestServicioPesado {
	private Pesado pesado;
	private double pesoPromedio;
	 	

	@BeforeEach
	void setUp() throws Exception {
		pesado = mock(Pesado.class);
		pesoPromedio = 5013.5;
	}

	@Test
	void testPesoMenorAlPromedio() {
		when (pesado.getPesoRegistrado()).thenReturn(501.3);
		
		assertTrue(pesado.getPesoRegistrado() < pesoPromedio);
	}
	
	@Test
	void testPesoIgualAlPromedio() {
		when (pesado.getPesoRegistrado()).thenReturn(5013.5);
		
		assertTrue(pesado.getPesoRegistrado() == pesoPromedio);
	}
	
	@Test
	void testPesoMayorAlPromedio() {
		when (pesado.getPesoRegistrado()).thenReturn(5016.3);
		
		assertTrue(pesado.getPesoRegistrado() > pesoPromedio);
	}

}
