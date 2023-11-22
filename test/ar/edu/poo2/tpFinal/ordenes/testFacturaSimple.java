package ar.edu.poo2.tpFinal.ordenes;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.poo2.tpFinal.CircuitosNaviera.*;
import ar.edu.poo2.tpFinal.ordenes.FacturaResponsableViaje;
import ar.edu.poo2.tpFinal.ordenes.FacturaSimple;
import ar.edu.poo2.tpFinal.ordenes.Orden;
import ar.edu.poo2.tpFinal.ordenes.OrdenImportacion;

class testFacturaSimple {

	private FacturaSimple fact;
	private Orden orden;
	private Viaje viaje1;
	private Viaje viaje2;
	private Orden orden2;

	@BeforeEach
	void setUp() throws Exception {
		fact = mock(FacturaSimple.class);
		orden = mock(Orden.class);
		orden2 = mock(Orden.class);
		viaje1 = mock(Viaje.class);
		viaje2 = mock(Viaje.class);
	}

	@Test
	void testMontoTotal() throws Exception {
		when(fact.getMontoTotalFacturado(orden)).thenReturn(45503.3);
		when(fact.getMontoTotalFacturado(orden2)).thenReturn(454323.3);
		
		assertNotEquals(fact.getMontoTotalFacturado(orden),fact.getMontoTotalFacturado(orden2) );
	}

	@Test
	void testMontoTotalIgual() throws Exception {
		when(fact.getMontoTotalFacturado(orden)).thenReturn(45503.3);
		when(fact.getMontoTotalFacturado(orden2)).thenReturn(45503.3);
		
		assertEquals(fact.getMontoTotalFacturado(orden),fact.getMontoTotalFacturado(orden2) );
	}

	@Test
	void testGetOrden() {
		when(fact.getOrden()).thenReturn(orden);
		
		assertEquals(fact.getOrden(),orden);
	}

	@Test
	void testGetOrdenDistinto() {
		when(fact.getOrden()).thenReturn(orden);
		
		assertNotEquals(fact.getOrden(),orden2);
	}
	
	

}