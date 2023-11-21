package ar.edu.poo2.tpFinal.ordenes;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.poo2.tpFinal.ordenes.FacturaResponsableViaje;
import ar.edu.poo2.tpFinal.ordenes.OrdenImportacion;

class testOrdenImportacion {

	private FacturaResponsableViaje fact;
	private FacturaResponsableViaje fact2;
	private OrdenImportacion orden;

	@BeforeEach
	void setUp() throws Exception {
		orden = mock(OrdenImportacion.class);
		fact = mock(FacturaResponsableViaje.class);
		fact2 = mock(FacturaResponsableViaje.class);
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