package ar.edu.poo2.tpFinal.clientes;



import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.poo2.tpFinal.clientes.*;
import ar.edu.poo2.tpFinal.ordenes.OrdenExportacion;
import ar.edu.poo2.tpFinal.ordenes.OrdenImportacion;

class testShipper {
	private Shipper shipper;
	private OrdenExportacion orden;
	private OrdenImportacion orden2;
	private Exception excepcion = new Exception("No puede abonar una orden de importacion");
	private String nombre = "Lucio Jara";
	private String nombre2 = "Lionel Messi";
	private String email = "luciojara@gmail.com";
	private String email2 = "liomessi@gmail.com";


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
	
	@Test 
	void testGetNombreFalse() {
		when(shipper.nombreCompleto()).thenReturn(nombre);
		
		assertNotEquals(nombre2, shipper.nombreCompleto());
	}
	
	@Test 
	void testGetNombre() {
		when(shipper.nombreCompleto()).thenReturn(nombre);
		
		assertEquals(nombre, shipper.nombreCompleto());
	}

	@Test 
	void testGetEmail() {
		when(shipper.getEmail()).thenReturn(email);
		
		assertEquals(email, shipper.getEmail());
	}

	@Test 
	void testGetEmailFalse() {
		when(shipper.getEmail()).thenReturn(email);
		
		assertNotEquals(email2, shipper.getEmail());
	}

}