package ar.edu.poo2.tpFinal.ordenes;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.poo2.tpFinal.Camion;
import ar.edu.poo2.tpFinal.Chofer;
import ar.edu.poo2.tpFinal.EntregaTerrestre;
import ar.edu.poo2.tpFinal.CircuitosNaviera.*;
import ar.edu.poo2.tpFinal.clientes.Cliente;
import ar.edu.poo2.tpFinal.clientes.Shipper;
import ar.edu.poo2.tpFinal.contyserv.Container;
import ar.edu.poo2.tpFinal.ordenes.OrdenExportacion;
import ar.edu.poo2.tpFinal.ordenes.Turno;

class testTurno {
	private OrdenExportacion orden;
	private OrdenExportacion orden2;
	private OrdenExportacion orden3;
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
	private Turno turno2;

	private String nombre = "Lucio Jara";
	private String email = "luciojara@gmail.com";
	private Container cont;
	private FacturaSimple fact;

	@BeforeEach
	void setUp() throws Exception {
		viaje = mock(Viaje.class);
		when(viaje.getOrigen()).thenReturn(mock(TerminalPortuaria.class));
		fechaRecepcion = mock(LocalDateTime.class);
		fechaRecepcion2 = mock(LocalDateTime.class);
		camion = mock(Camion.class);
		orden = new OrdenExportacion(cliente, cont, camion, chofer, viaje, fact);
		orden2 = mock(OrdenExportacion.class);
		orden3 = mock(OrdenExportacion.class);
		chofer2 = mock(Chofer.class);
		cliente2 = new Shipper(email, nombre, orden);
		camion2 = mock(Camion.class);
		turno = mock(Turno.class);
		viaje2 = mock(Viaje.class);
		turno2 = mock(Turno.class);
	}

	@Test
	void testEsValidoParaEntregaTerrestre() {
		Turno turno = new Turno(orden3, 0, 0);
		
		EntregaTerrestre et = mock(EntregaTerrestre.class);
		when(et.getCamion()).thenReturn(camion);
		when(et.getChofer()).thenReturn(chofer);
		when(et.getTurno()).thenReturn(turno);
		
		when(orden3.getCamion()).thenReturn(camion);
		when(orden3.getChofer()).thenReturn(chofer);
		
		LocalDateTime ldt = mock(LocalDateTime.class);
		when(ldt.minusHours(anyLong())).thenReturn(ldt);
		when(ldt.plusHours(anyLong())).thenReturn(ldt);
		when(ldt.isBefore(any())).thenReturn(true);
		when(et.getHorarioArribo()).thenReturn(ldt);
		
		when(orden3.getFechaLlegadaADestino()).thenReturn(ldt);
		
		assertTrue(turno.esTurnoValidoParaEntregaTerrestre(et));
	}

	@Test
	void testNoEsValidoParaEntregaTerrestrePorHorario() {
		Turno turno = new Turno(orden3, 0, 0);
		
		EntregaTerrestre et = mock(EntregaTerrestre.class);
		when(et.getCamion()).thenReturn(camion);
		when(et.getChofer()).thenReturn(chofer);
		when(et.getTurno()).thenReturn(turno);
		
		when(orden3.getCamion()).thenReturn(camion);
		when(orden3.getChofer()).thenReturn(chofer);
		
		LocalDateTime ldt = mock(LocalDateTime.class);
		when(ldt.minusHours(anyLong())).thenReturn(ldt);
		when(ldt.plusHours(anyLong())).thenReturn(ldt);
		when(ldt.isBefore(any())).thenReturn(false);
		when(et.getHorarioArribo()).thenReturn(ldt);
		
		when(orden3.getFechaLlegadaADestino()).thenReturn(ldt);
		
		assertFalse(turno.esTurnoValidoParaEntregaTerrestre(et));
	}
	
	@Test
	void testNoEsValidoParaEntregaTerrestrePorConductor() {
		Turno turno = new Turno(orden3, 0, 0);
		
		EntregaTerrestre et = mock(EntregaTerrestre.class);
		when(et.getCamion()).thenReturn(camion);
		when(et.getChofer()).thenReturn(chofer2);
		when(et.getTurno()).thenReturn(turno);
		
		when(orden3.getCamion()).thenReturn(camion);
		when(orden3.getChofer()).thenReturn(chofer);
		
		LocalDateTime ldt = mock(LocalDateTime.class);
		when(ldt.minusHours(anyLong())).thenReturn(ldt);
		when(ldt.plusHours(anyLong())).thenReturn(ldt);
		when(ldt.isBefore(any())).thenReturn(true);
		when(et.getHorarioArribo()).thenReturn(ldt);
		
		when(orden3.getFechaLlegadaADestino()).thenReturn(ldt);
		
		assertFalse(turno.esTurnoValidoParaEntregaTerrestre(et));
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

		assertEquals(turno.getShipper(), cliente);
	}

	@Test
	void testClienteFalse() {

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

		assertEquals(turno.getChofer(), chofer);
	}

	@Test
	void testChoferFalse() {

		assertNotEquals(turno.getChofer(), chofer2);
	}

	@Test
	void testViaje() {
		when(turno.getViaje()).thenReturn(viaje);
		assertEquals(turno.getViaje(), viaje);
	}

	@Test
	void testViajeFalse() {

		assertNotEquals(turno.getViaje(), viaje2);
	}

}