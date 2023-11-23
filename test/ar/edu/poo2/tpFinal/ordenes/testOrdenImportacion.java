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
import ar.edu.poo2.tpFinal.ordenes.FacturaResponsableViaje;
import ar.edu.poo2.tpFinal.ordenes.OrdenImportacion;

class testOrdenImportacion {

	private FacturaResponsableViaje fact;
	private FacturaResponsableViaje fact2;
	private OrdenImportacion orden;
	private OrdenImportacion orden2;

	private Consignee cliente;
	private String nombre = "Lucio Jara";
	private String email = "luciojara@gmail.com";
	private Container cont;
	private Camion cam;
	private Chofer chofer;
	private Viaje viaje;

	@BeforeEach
	void setUp() throws Exception {
		
		fact = new FacturaResponsableViaje(orden);
		fact2 = new FacturaResponsableViaje(orden);
		orden = new OrdenImportacion(cliente, cont, cam, chofer, viaje, fact);
		orden2 = mock(OrdenImportacion.class);
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