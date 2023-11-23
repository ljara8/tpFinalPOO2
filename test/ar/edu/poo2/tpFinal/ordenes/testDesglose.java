package ar.edu.poo2.tpFinal.ordenes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.poo2.tpFinal.Camion;
import ar.edu.poo2.tpFinal.Chofer;
import ar.edu.poo2.tpFinal.CircuitosNaviera.TerminalPortuaria;
import ar.edu.poo2.tpFinal.CircuitosNaviera.Viaje;
import ar.edu.poo2.tpFinal.clientes.Cliente;
import ar.edu.poo2.tpFinal.clientes.Consignee;
import ar.edu.poo2.tpFinal.contyserv.Container;
import ar.edu.poo2.tpFinal.contyserv.Electricidad;
import ar.edu.poo2.tpFinal.contyserv.Servicio;
import ar.edu.poo2.tpFinal.ordenes.Desglose;
import ar.edu.poo2.tpFinal.ordenes.Orden;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class testDesglose {
	private Desglose desglose;
	private OrdenImportacion orden;
	private Orden orden2;
	private List<Servicio> servicios2 = new ArrayList<Servicio>();
	private Electricidad electric;
	private long hoy;

	private Consignee cliente;
	private String nombre = "Lucio Jara";
	private String email = "luciojara@gmail.com";
	private Container cont;
	private Camion cam;
	private Chofer chofer;
	private Viaje viaje;
	private FacturaResponsableViaje fact;

	@BeforeEach
	void setUp() throws Exception {
		desglose = new Desglose(orden);
		orden = new OrdenImportacion(cliente, cont, cam, chofer, viaje, fact);
		orden2 = mock(Orden.class);
		electric = mock(Electricidad.class);
		orden.getServiciosContratados().add(electric);

	}

	@Test
	void testGetServiciosFalse() {
		when(orden2.getServiciosContratados()).thenReturn(servicios2);

		assertNotEquals(orden2.getServiciosContratados(), desglose.getServicios(orden));

	}

	@Test
	void testGetServicios() {

		assertTrue(orden.getServiciosContratados() == desglose.getServicios(orden));

	}

	@Test
	void testGetMontoTotalDeOrden() throws Exception {
		assertThrowsExactly(NullPointerException.class, () -> desglose.getMontoTotal(orden));
	}

	@Test
	void testGetFechaFalse() {

		assertNotEquals(hoy, desglose.getFecha());

	}

	@Test
	void getOrdenDesgloseFalse() {

		assertNotEquals(orden2, desglose.getOrden());

	}

}