package ar.edu.poo2.tpFinal.ordenesYFacturass;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.poo2.tpFinal.Viaje;
import ar.edu.poo2.tpFinal.ordenes.FacturaResponsableViaje;
import ar.edu.poo2.tpFinal.ordenes.Orden;
import ar.edu.poo2.tpFinal.ordenes.OrdenImportacion;

class testFacturaResponsable {
	private FacturaResponsableViaje fact;
	private OrdenImportacion orden;
	private Viaje viaje1;
	private Viaje viaje2;
	private OrdenImportacion orden2;

	@BeforeEach
	void setUp() throws Exception {
		fact = mock(FacturaResponsableViaje.class);
		orden = mock(OrdenImportacion.class);
		orden2 = mock(OrdenImportacion.class);
		viaje1 = mock(Viaje.class);
		viaje2 = mock(Viaje.class);
	}

	@Test
	void testMontoTotal() {
		when(fact.getMontoTotalFacturado(orden)).thenReturn(45503.3);
		when(fact.getMontoTotalFacturado(orden2)).thenReturn(454323.3);
		
		assertNotEquals(fact.getMontoTotalFacturado(orden),fact.getMontoTotalFacturado(orden2) );
	}

	@Test
	void testMontoTotalIgual() {
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
