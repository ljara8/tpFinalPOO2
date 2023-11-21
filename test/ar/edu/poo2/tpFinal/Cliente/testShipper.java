package ar.edu.poo2.tpFinal.Cliente;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.poo2.tpFinal.Clientes.*;
import ar.edu.poo2.tpFinal.ordenes.OrdenExportacion;
import ar.edu.poo2.tpFinal.ordenes.OrdenImportacion;
import net.bytebuddy.asm.Advice.OffsetMapping.Factory.Illegal;

class testShipper {
	private Shipper shipper;
	private OrdenExportacion orden;
	private OrdenImportacion orden2;
	private Exception excepcion = new Exception("No puede abonar una orden de importacion");

	@BeforeEach
	void setUp() throws Exception {
		shipper = mock(Shipper.class);
		orden = mock(OrdenExportacion.class);
		orden2 = mock(OrdenImportacion.class);
	}

	@Test
	void testAbonar() throws Exception {
		when(shipper.abonarFacturacion(orden)).thenReturn(50340.3);
		when(shipper.abonarFacturacion(orden2)).thenReturn(anyDouble());
		
		assertNotEquals(shipper.abonarFacturacion(orden),shipper.abonarFacturacion(orden2) );
	}

	@Test
	void testExcepcionAbonar() throws Exception {
		when(shipper.abonarFacturacion(orden2)).thenThrow(excepcion);
		
		assertThrowsExactly(Exception.class, () -> shipper.abonarFacturacion(orden2));
	
	}

	@Test
	void testGetOrden() throws Exception {
		when(shipper.getOrdenExp()).thenReturn(orden);
		
		assertEquals(shipper.getOrdenExp(), orden);
	}

	@Test
	void testGetOrdenFalse() throws Exception {
		when(shipper.getOrdenExp()).thenReturn(orden);
		
		assertNotEquals(shipper.getOrdenExp(), orden2);
	}

}
