package ar.edu.poo2.tpFinal.clientes;

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
	private String nombre = "Lucio Jara";
	private String nombre2 = "Lionel Messi";
	private String email = "luciojara@gmail.com";
	private String email2 = "liomessi@gmail.com";

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

	@Test 
	void testGetNombreFalse() {
		when(consignee.nombreCompleto()).thenReturn(nombre);
		
		assertNotEquals(nombre2, consignee.nombreCompleto());
	}
	
	@Test 
	void testGetNombre() {
		when(consignee.nombreCompleto()).thenReturn(nombre);
		
		assertNotEquals(nombre, consignee.nombreCompleto());
	}

	@Test 
	void testGetEmail() {
		when(consignee.getEmail()).thenReturn(email);
		
		assertEquals(email, consignee.getEmail());
	}

	@Test 
	void testGetEmailFalse() {
		when(consignee.getEmail()).thenReturn(email);
		
		assertNotEquals(email2, consignee.getEmail());
	}
}