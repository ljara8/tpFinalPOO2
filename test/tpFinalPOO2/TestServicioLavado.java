package tpFinalPOO2;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.poo2.tpFinal.contyserv.Lavado;
import ar.edu.poo2.tpFinal.ordenes.Orden;

class TestServicioLavado {
	private Lavado lavado;
	private Orden orden;
	private double costoLavadoPromedio;

	@BeforeEach
	void setUp() throws Exception {
		lavado = mock(Lavado.class);
		orden = mock(Orden.class);
		costoLavadoPromedio = 912.18;
	}

	@Test
	void testSuperaCapacidad() {
		when(lavado.superaLaCapacidad()).thenReturn(true);
		assertTrue(lavado.superaLaCapacidad());
	}

	@Test
	void testNoSuperaCapacidad() {
		when(lavado.superaLaCapacidad()).thenReturn(false);
		assertFalse(lavado.superaLaCapacidad());
	}

	@Test
	void testMontoTotalSegunCapacidadMenorAPromedio() {
		when(lavado.montoTotal(orden)).thenReturn(700.5);
		assertTrue(lavado.montoTotal(orden) < costoLavadoPromedio);
	}

	@Test
	void testMontoTotalSegunCapacidadIgualAPromedio() {
		when(lavado.montoTotal(orden)).thenReturn(912.18);
		assertTrue(lavado.montoTotal(orden) == costoLavadoPromedio);
	}

	@Test
	void testMontoTotalSegunCapacidadMayorAPromedio() {
		when(lavado.montoTotal(orden)).thenReturn(1000.5);
		assertTrue(lavado.montoTotal(orden) > costoLavadoPromedio);
	}

}
