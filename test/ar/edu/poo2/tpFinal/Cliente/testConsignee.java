package ar.edu.poo2.tpFinal.Cliente;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.poo2.tpFinal.Clientes.Consignee;
import ar.edu.poo2.tpFinal.ordenes.OrdenExportacion;
import ar.edu.poo2.tpFinal.ordenes.OrdenImportacion;

class testConsignee {
	private Consignee consignee;
	private OrdenExportacion orden;
	private OrdenImportacion orden2;
	private Exception excepcion = new Exception("No puede abonar una orden de importacion");

	@BeforeEach
	void setUp() throws Exception {
		consignee = mock(Consignee.class);
		orden = mock(OrdenExportacion.class);
		orden2 = mock(OrdenImportacion.class);
	}

	@Test
	void testAbonar() throws Exception {
		when(consignee.abonarFacturacion(orden)).thenReturn(50340.3);
		when(consignee.abonarFacturacion(orden2)).thenReturn(anyDouble());
		
		assertNotEquals(consignee.abonarFacturacion(orden),consignee.abonarFacturacion(orden2) );
	}

	@Test
	void testExcepcionAbonar() throws Exception {
		when(consignee.abonarFacturacion(orden)).thenThrow(excepcion);
		
		assertThrowsExactly(Exception.class, () -> consignee.abonarFacturacion(orden));
	
	}

	@Test
	void testGetOrden() throws Exception {
		when(consignee.getOrdenImp()).thenReturn(orden2);
		
		assertEquals(consignee.getOrdenImp(), orden2);
	}

	@Test
	void testGetOrdenFalse() throws Exception {
		when(consignee.getOrdenImp()).thenReturn(orden2);
		
		assertNotEquals(consignee.getOrdenImp(), orden);
	}
}
