package tpFinalPOO2;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.poo2.tpFinal.contyserv.Electricidad;
import ar.edu.poo2.tpFinal.contyserv.Refeer;
import ar.edu.poo2.tpFinal.ordenes.Orden;

class TestServicioElectricidad {
	private Electricidad electricidad;
	private Orden orden;
	private Refeer refeer;
	private double montoTotalPromedio;
	private double tiempoConexionPromedio;
	private double cantidadKwConsumidoPromedio;

	@BeforeEach
	void setUp() throws Exception {
		electricidad = mock(Electricidad.class);
		orden = mock(Orden.class);
		refeer = mock(Refeer.class);

		montoTotalPromedio = 1030.5;
		tiempoConexionPromedio = 51.6;
		cantidadKwConsumidoPromedio = 40.13;
	}

	@Test
	void testMontoTotalConsumidoMayorPromedioYMenorPromedioConexion() {
		when(orden.getTiempoConexion(refeer)).thenReturn(50.5);
		assertTrue(orden.getTiempoConexion(refeer) < tiempoConexionPromedio);
		
		when(electricidad.montoTotal(orden)).thenReturn(6043.5);
		assertTrue(electricidad.montoTotal(orden) > montoTotalPromedio);
		
	}

	@Test
	void testMontoTotalConsumidoMenorAPromedio() {
		when(electricidad.montoTotal(orden)).thenReturn(536.5);
		assertFalse(electricidad.montoTotal(orden) > montoTotalPromedio);
	}

	@Test
	void testMontoTotalConsumidoIgualAPromedio() {
		when(electricidad.montoTotal(orden)).thenReturn(1030.5);
		assertTrue(electricidad.montoTotal(orden) == montoTotalPromedio);
	}

	@Test
	void testKwConsumidoMenorAPromedio() {
		when(electricidad.getCantidadKwConsumido()).thenReturn(40.11);
		assertTrue(electricidad.getCantidadKwConsumido() < cantidadKwConsumidoPromedio);
	}

	@Test
	void testKwConsumidoMayorAPromedio() {
		when(electricidad.getCantidadKwConsumido()).thenReturn(50.5);
		assertTrue(electricidad.getCantidadKwConsumido() > cantidadKwConsumidoPromedio);
	}

	@Test
	void testKwConsumidoIgualAPromedio() {
		when(electricidad.getCantidadKwConsumido()).thenReturn(40.13);
		assertTrue(electricidad.getCantidadKwConsumido() == cantidadKwConsumidoPromedio);
	}

}
