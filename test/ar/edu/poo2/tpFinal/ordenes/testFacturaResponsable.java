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
import ar.edu.poo2.tpFinal.contyserv.Container;
import ar.edu.poo2.tpFinal.ordenes.FacturaResponsableViaje;
import ar.edu.poo2.tpFinal.ordenes.Orden;
import ar.edu.poo2.tpFinal.ordenes.OrdenImportacion;

class testFacturaResponsable {
	private FacturaResponsableViaje fact;
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
		orden = new OrdenImportacion(cliente, cont, cam, chofer, viaje, fact);
		orden2 = mock(OrdenImportacion.class);

	}

	@Test
	void testMontoTotalIgual() throws Exception {

		assertThrowsExactly(NullPointerException.class, () -> fact.getMontoTotalFacturado(orden));
	}

	@Test
	void testGetOrden() {

		assertNotEquals(fact.getOrden(), orden);
	}

}