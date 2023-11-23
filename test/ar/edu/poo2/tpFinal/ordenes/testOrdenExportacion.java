package ar.edu.poo2.tpFinal.ordenes;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.poo2.tpFinal.ordenes.FacturaSimple;
import ar.edu.poo2.tpFinal.ordenes.OrdenExportacion;

class testOrdenExportacion {
	private FacturaSimple fact;
	private FacturaSimple fact2;
	private OrdenExportacion orden;

	@BeforeEach
	void setUp() throws Exception {
		orden = mock(OrdenExportacion.class);
		fact = mock(FacturaSimple.class);
		fact2 = mock(FacturaSimple.class);
	}

	@Test
	void testGetFactura() {
		when(orden.getFactura()).thenReturn(fact);
		
		assertEquals(orden.getFactura(), fact);
	}
	@Test
	void testGetFacturaFalse() {
		when(orden.getFactura()).thenReturn(fact);
		
		assertNotEquals(orden.getFactura(), fact2);
	}

}