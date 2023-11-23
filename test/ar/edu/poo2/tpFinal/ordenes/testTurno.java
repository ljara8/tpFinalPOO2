package ar.edu.poo2.tpFinal.ordenes;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.poo2.tpFinal.Camion;
import ar.edu.poo2.tpFinal.Chofer;
import ar.edu.poo2.tpFinal.CircuitosNaviera.*;
import ar.edu.poo2.tpFinal.clientes.Cliente;
import ar.edu.poo2.tpFinal.clientes.Shipper;
import ar.edu.poo2.tpFinal.contyserv.Container;
import ar.edu.poo2.tpFinal.ordenes.OrdenExportacion;
import ar.edu.poo2.tpFinal.ordenes.Turno;

class testTurno {
	private OrdenExportacion orden;
	private OrdenExportacion orden2;
	private LocalDateTime fechaRecepcion;
	private LocalDateTime fechaRecepcion2;
	private Shipper cliente;
	private Shipper cliente2;
	private Camion camion;
	private Camion camion2;
	private Chofer chofer;
	private Chofer chofer2;
	private Viaje viaje;
	private Viaje viaje2;
	private Turno turno;

	private String nombre = "Lucio Jara";
	private String email = "luciojara@gmail.com";
	private Container cont;
	private FacturaSimple fact;

	@BeforeEach
	void setUp() throws Exception {

		fechaRecepcion = mock(LocalDateTime.class);

		orden = new OrdenExportacion(cliente, cont, camion, chofer, viaje, fact);
		orden2 = mock(OrdenExportacion.class);
		chofer2 = mock(Chofer.class);
		cliente2 = new Shipper(email, nombre, orden);
		camion2 = mock(Camion.class);
		viaje2 = mock(Viaje.class);
		fact = new FacturaSimple(orden);
		fechaRecepcion2 = mock(LocalDateTime.class);

		turno = new Turno(orden2);
	}

	@Test
	void testCliente() {

		assertEquals(turno.getShipper(), cliente);
	}

	@Test
	void testClienteFalse() {

		assertNotEquals(turno.getShipper(), cliente2);
	}

	@Test
	void testCamion() {

		assertEquals(turno.getCamion(), camion);
	}

	@Test
	void testCamionFalse() {

		assertNotEquals(turno.getCamion(), camion2);
	}

	@Test
	void testChofer() {

		assertEquals(turno.getChofer(), chofer);
	}

	@Test
	void testChoferFalse() {

		assertNotEquals(turno.getChofer(), chofer2);
	}

	@Test
	void testViaje() {

		assertEquals(turno.getViaje(), viaje);
	}

	@Test
	void testViajeFalse() {

		assertNotEquals(turno.getViaje(), viaje2);
	}

}