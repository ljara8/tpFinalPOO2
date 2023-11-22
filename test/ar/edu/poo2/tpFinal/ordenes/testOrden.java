package ar.edu.poo2.tpFinal.ordenes;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.poo2.tpFinal.Camion;
import ar.edu.poo2.tpFinal.Chofer;
import ar.edu.poo2.tpFinal.CircuitosNaviera.*;
import ar.edu.poo2.tpFinal.contyserv.Container;
import ar.edu.poo2.tpFinal.ordenes.Desglose;
import ar.edu.poo2.tpFinal.ordenes.Orden;

class testOrden {
	private Orden orden;
	private Container cont;
	private Container cont2;
	private Camion camion;
	private Camion camion2;
	private Chofer chofer;
	private Chofer chofer2;
	private Viaje viajeActual;
	private LocalDateTime fechaLlegada;
	private LocalDateTime fechaSalida;

	@BeforeEach
	void setUp() throws Exception {
		orden = mock(Orden.class);
		chofer2 = mock(Chofer.class);
		cont2 = mock(Container.class);
		camion2 = mock(Camion.class);
		fechaLlegada = mock(LocalDateTime.class);
		fechaSalida = mock(LocalDateTime.class);
		viajeActual = mock(Viaje.class);
	}

	@Test
	void testChoferDeOrden() {
		when(orden.getChofer()).thenReturn(chofer);
		
		assertEquals(chofer, orden.getChofer());
	}

	@Test
	void testChoferDeOrdenFalse() {
		when(orden.getChofer()).thenReturn(chofer);
		
		assertNotEquals(chofer2, orden.getChofer());
	}

	@Test
	void testContainerDeOrdenFalse() {
		when(orden.getContainer()).thenReturn(cont);
		
		assertNotEquals(cont2, orden.getContainer());
	}

	@Test
	void testContainerDeOrden() {
		when(orden.getContainer()).thenReturn(cont);
		
		assertEquals(cont, orden.getContainer());
	}

	@Test
	void testCamionDeOrden() {
		when(orden.getCamion()).thenReturn(camion);
		
		assertEquals(camion, orden.getCamion());
	}

	@Test
	void testCamionDeOrdenFalse() {
		when(orden.getCamion()).thenReturn(camion);
		
		assertNotEquals(camion2, orden.getCamion());
	}

	@Test
	void testFechaLlegada() {
		when(orden.getFechaLlegadaADestino()).thenReturn(fechaLlegada);
		when(viajeActual.getFechaLlegada()).thenReturn(fechaLlegada);
		
		assertEquals(orden.getFechaLlegadaADestino(),viajeActual.getFechaLlegada());
	}

	@Test
	void testFechaLlegadaFalse() {
		when(orden.getFechaLlegadaADestino()).thenReturn(fechaLlegada);
		when(viajeActual.getFechaLlegada()).thenReturn(fechaSalida);
		
		assertNotEquals(orden.getFechaLlegadaADestino(),viajeActual.getFechaLlegada());
	}

	@Test
	
	void testFechaSalida() {
		when(orden.getFechaSalidaADestino()).thenReturn(fechaSalida);
		when(viajeActual.getFechaSalida()).thenReturn(fechaSalida);
		
		assertEquals(orden.getFechaSalidaADestino(),viajeActual.getFechaSalida());
	}

	@Test
	
	void testFechaSalidaFalse() {
		when(orden.getFechaSalidaADestino()).thenReturn(fechaLlegada);
		when(viajeActual.getFechaSalida()).thenReturn(fechaSalida);
		
		assertNotEquals(orden.getFechaSalidaADestino(),viajeActual.getFechaSalida());
	}

}