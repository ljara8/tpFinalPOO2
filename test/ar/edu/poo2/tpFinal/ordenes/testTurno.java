package ar.edu.poo2.tpFinal.ordenes;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.poo2.tpFinal.Camion;
import ar.edu.poo2.tpFinal.Chofer;
import ar.edu.poo2.tpFinal.CircuitosNaviera.*;
import ar.edu.poo2.tpFinal.Clientes.Cliente;
import ar.edu.poo2.tpFinal.ordenes.OrdenExportacion;
import ar.edu.poo2.tpFinal.ordenes.Turno;

class testTurno {
	private OrdenExportacion orden;
	private Date fechaRecepcion;
	private Date fechaRecepcion2;
	private Cliente cliente;
	private Cliente cliente2;
	private Camion camion;
	private Camion camion2;
	private Chofer chofer;
	private Chofer chofer2;
	private Viaje viaje;
	private Viaje viaje2;
	private Turno turno;

	@BeforeEach
	void setUp() throws Exception {
		turno = mock(Turno.class);
		fechaRecepcion = mock(Date.class);
		fechaRecepcion2 = mock(Date.class);
		orden = mock(OrdenExportacion.class);
		chofer2 = mock(Chofer.class);
		cliente2 = mock(Cliente.class);
		camion2 = mock(Camion.class);
		viaje2 = mock(Viaje.class);
	}

	@Test
	void testFechaRecepcion() {
		when(turno.getFechaRecepcion()).thenReturn(fechaRecepcion);
		
		assertEquals(turno.getFechaRecepcion(), fechaRecepcion);
	}

	@Test
	void testFechaRecepcionFalse() {
		when(turno.getFechaRecepcion()).thenReturn(fechaRecepcion);
		
		assertNotEquals(turno.getFechaRecepcion(), fechaRecepcion2);
	}

	@Test
	void testCliente() {
		when(turno.getShipper()).thenReturn(cliente);
		
		assertEquals(turno.getShipper(), cliente);
	}

	@Test
	void testClienteFalse() {
		when(turno.getShipper()).thenReturn(cliente);
		
		assertNotEquals(turno.getShipper(), cliente2);
	}

	@Test
	void testCamion() {
		when(turno.getCamion()).thenReturn(camion);
		
		assertEquals(turno.getCamion(), camion);
	}

	@Test
	void testCamionFalse() {
		when(turno.getCamion()).thenReturn(camion);
		
		assertNotEquals(turno.getCamion(), camion2);
	}

	@Test
	void testChofer() {
		when(turno.getChofer()).thenReturn(chofer);
		
		assertEquals(turno.getChofer(), chofer);
	}

	@Test
	void testChoferFalse() {
		when(turno.getChofer()).thenReturn(chofer);
		
		assertNotEquals(turno.getChofer(), chofer2);
	}

	@Test
	void testViaje() {
		when(turno.getViaje()).thenReturn(viaje);
		
		assertEquals(turno.getViaje(), viaje);
	}

	@Test
	void testViajeFalse() {
		when(turno.getViaje()).thenReturn(viaje);
		
		assertNotEquals(turno.getViaje(), viaje2);
	}
}