package ar.edu.poo2.tpFinal.ordenes;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.poo2.tpFinal.Camion;
import ar.edu.poo2.tpFinal.Chofer;
import ar.edu.poo2.tpFinal.CircuitosNaviera.*;
import ar.edu.poo2.tpFinal.clientes.Consignee;
import ar.edu.poo2.tpFinal.clientes.Shipper;
import ar.edu.poo2.tpFinal.contyserv.Container;
import ar.edu.poo2.tpFinal.ordenes.FacturaResponsableViaje;
import ar.edu.poo2.tpFinal.ordenes.FacturaSimple;
import ar.edu.poo2.tpFinal.ordenes.Orden;
import ar.edu.poo2.tpFinal.ordenes.OrdenImportacion;

class testFacturaSimple {

	private FacturaSimple fact;
	private Orden orden;
	private Orden orden2;

	private Shipper cliente;
	private String nombre = "Lucio Jara";
	private String email = "luciojara@gmail.com";
	private Container cont;
	private Camion cam;
	private Chofer chofer;
	private Viaje viaje;

	@BeforeEach
	void setUp() throws Exception {
		fact = new FacturaSimple(orden);
		orden = new OrdenExportacion(cliente, cont, cam, chofer, viaje, fact);
		orden2 = mock(OrdenExportacion.class);
	}

	@Test
	void testMontoTotalIgualA0() throws Exception {

		assertEquals(fact.getMontoTotalFacturado(orden), 0);

	}

	@Test
	void testGetOrden() {

		assertNotEquals(fact.getOrden(), orden);
	}

}