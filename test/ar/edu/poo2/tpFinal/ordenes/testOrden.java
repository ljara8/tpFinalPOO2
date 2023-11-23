package ar.edu.poo2.tpFinal.ordenes;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.poo2.tpFinal.Camion;
import ar.edu.poo2.tpFinal.Chofer;
import ar.edu.poo2.tpFinal.CircuitosNaviera.*;
import ar.edu.poo2.tpFinal.clientes.Consignee;
import ar.edu.poo2.tpFinal.contyserv.Container;
import ar.edu.poo2.tpFinal.ordenes.Desglose;
import ar.edu.poo2.tpFinal.ordenes.Orden;

class testOrden {
	private Orden orden;
	private Orden orden2;
	private Container cont;
	private Container cont2;
	private Camion camion;
	private Camion camion2;
	private Chofer chofer;
	private Chofer chofer2;
	private Viaje viajeActual;
	private LocalDateTime fechaLlegada;
	private LocalDateTime fechaSalida;
	private FacturaResponsableViaje fact;

	private Consignee cliente;

	@BeforeEach
	void setUp() throws Exception {
		orden = new OrdenImportacion(cliente, cont, camion, chofer, viajeActual, fact);
		orden2 = mock(OrdenImportacion.class);
		chofer2 = mock(Chofer.class);
		cont2 = mock(Container.class);
		camion2 = mock(Camion.class);
		fechaLlegada = mock(LocalDateTime.class);
		fechaSalida = mock(LocalDateTime.class);
		viajeActual = mock(Viaje.class);
	}

	@Test
	void testChoferDeOrden() {

		assertEquals(chofer, orden.getChofer());
	}

	@Test
	void testChoferDeOrdenFalse() {

		assertNotEquals(chofer2, orden.getChofer());
	}

	@Test
	void testContainerDeOrdenFalse() {

		assertNotEquals(cont2, orden.getContainer());
	}

	@Test
	void testContainerDeOrden() {

		assertEquals(cont, orden.getContainer());
	}

	@Test
	void testCamionDeOrden() {

		assertEquals(camion, orden.getCamion());
	}

	@Test
	void testCamionDeOrdenFalse() {

		assertNotEquals(camion2, orden.getCamion());
	}

	@Test
	void testFechaLlegada() {
		when(orden2.getFechaLlegadaADestino()).thenReturn(fechaLlegada);
		when(viajeActual.getFechaLlegada()).thenReturn(fechaLlegada);
		
		assertEquals(orden2.getFechaLlegadaADestino(),viajeActual.getFechaLlegada());
	}

	@Test
	void testFechaLlegadaFalse() {
		when(orden2.getFechaLlegadaADestino()).thenReturn(fechaLlegada);
		when(viajeActual.getFechaLlegada()).thenReturn(fechaSalida);
		
		assertNotEquals(orden2.getFechaLlegadaADestino(),viajeActual.getFechaLlegada());
	}

	@Test
	
	void testFechaSalida() {
		when(orden2.getFechaSalidaADestino()).thenReturn(fechaSalida);
		when(viajeActual.getFechaSalida()).thenReturn(fechaSalida);
		
		assertEquals(orden2.getFechaSalidaADestino(),viajeActual.getFechaSalida());
	}

	@Test
	
	void testFechaSalidaFalse() {
		when(orden2.getFechaSalidaADestino()).thenReturn(fechaLlegada);
		when(viajeActual.getFechaSalida()).thenReturn(fechaSalida);
		
		assertNotEquals(orden2.getFechaSalidaADestino(),viajeActual.getFechaSalida());
	}

}