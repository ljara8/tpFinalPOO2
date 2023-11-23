package ar.edu.poo2.tpFinal.ordenes;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.poo2.tpFinal.Camion;
import ar.edu.poo2.tpFinal.Chofer;
import ar.edu.poo2.tpFinal.CircuitosNaviera.Viaje;
import ar.edu.poo2.tpFinal.clientes.Consignee;
import ar.edu.poo2.tpFinal.clientes.Shipper;
import ar.edu.poo2.tpFinal.contyserv.Container;
import ar.edu.poo2.tpFinal.ordenes.FacturaSimple;
import ar.edu.poo2.tpFinal.ordenes.OrdenExportacion;

class testOrdenExportacion {
	private FacturaSimple fact;
	private FacturaSimple fact2;
	private OrdenExportacion orden;
	private OrdenExportacion orden2;

	private Shipper cliente;
	private String nombre = "Lucio Jara";
	private String email = "luciojara@gmail.com";
	private Container cont;
	private Camion cam;
	private Chofer chofer;
	private Viaje viaje;

	@BeforeEach
	void setUp() throws Exception {
		orden = new OrdenExportacion(cliente, cont, cam, chofer, viaje, fact);
		orden2 = mock(OrdenExportacion.class);
		fact = new FacturaSimple(orden);
		fact2 = new FacturaSimple(orden);
	}

	@Test
	void testGetFactura() {
		when(orden2.getFactura()).thenReturn(fact);
		
		assertEquals(orden2.getFactura(), fact);
	}

	@Test
	void testGetFacturaFalse() {
		
		assertNotEquals(orden.getFactura(), fact2);
	}

}