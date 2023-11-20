package ar.edu.poo2.tpFinal.ordenesYFacturass;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.poo2.tpFinal.contyserv.Electricidad;
import ar.edu.poo2.tpFinal.contyserv.Servicio;
import ar.edu.poo2.tpFinal.ordenes.Desglose;
import ar.edu.poo2.tpFinal.ordenes.Orden;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class testDesglose {
	private Desglose desglose;
	private Orden orden;
	private Orden orden2;
	private List<Servicio> servicios = new ArrayList<Servicio>();
	private List<Servicio> servicios2 = new ArrayList<Servicio>();
	private Electricidad electric;
	private long hoy;
	

	@BeforeEach
	void setUp() throws Exception {
		desglose = mock(Desglose.class);
		orden = mock(Orden.class);
		orden2 = mock(Orden.class);
		electric = mock(Electricidad.class);
		servicios.add(electric);

	}

	@Test
	void testGetServiciosFalse() {
		when(orden.getServiciosContratados()).thenReturn(servicios);
		when(desglose.getServicios(orden)).thenReturn(servicios2);
		
		assertFalse(orden.getServiciosContratados() == desglose.getServicios(orden));
			
	}

	@Test
	void testGetServicios() {
		when(orden.getServiciosContratados()).thenReturn(servicios);
		when(desglose.getServicios(orden)).thenReturn(servicios);
		
		assertTrue(orden.getServiciosContratados() == desglose.getServicios(orden));
		
	}

	@Test
	void testGetMontoTotalDeOrden() {
		when(electric.montoTotal(orden)).thenReturn(5000.34);
		when(desglose.getMontoTotal(orden)).thenReturn(5000.34);
		
		assertEquals(desglose.getMontoTotal(orden), electric.montoTotal(orden));

	}

	@Test
	void testGetMontoTotalDeOrdenMenor() {
		when(electric.montoTotal(orden)).thenReturn(5000.4);
		when(desglose.getMontoTotal(orden)).thenReturn(5000.34);
		
		assertNotEquals(desglose.getMontoTotal(orden), electric.montoTotal(orden));

	}

	@Test
	void testGetFechaFalse() {

		assertNotEquals(hoy, desglose.getFecha());

	}
	
	@Test
	void getOrdenDesgloseFalse() {
		
		when(desglose.getOrden()).thenReturn(orden);
		assertNotEquals(orden2, desglose.getOrden());
		
	}
	
	@Test
	void getOrdenDesglose() {
		
		when(desglose.getOrden()).thenReturn(orden);
		assertEquals(orden, desglose.getOrden());
		
	}

}
