package tpFinalPOO2;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.poo2.tpFinal.contyserv.Excedente;
import ar.edu.poo2.tpFinal.ordenes.Orden;

class TestServicioExcedente {
	private Excedente excedente;
	private Orden orden;
	private double costoExcedentePromedio;

	@BeforeEach
	void setUp() throws Exception {
		excedente = mock(Excedente.class);
		orden = mock(Orden.class);

		costoExcedentePromedio = 15050.5;
	}

	@Test
	void testExcedentePorMasDeUnDiaDeDemora() {
		when(orden.getHorasDeDemora()).thenReturn(25);
		assertTrue(orden.getHorasDeDemora() > 24);
		
		when(excedente.montoTotal(orden)).thenReturn(50000.5);
		assertTrue(excedente.montoTotal(orden) == 50000.5);
	}

	@Test
	void testCostoDeExcedenteMayorAPromedio() {
		
		when(excedente.getCostoPorExcedente()).thenReturn(50000.5);
		assertTrue(excedente.getCostoPorExcedente() > costoExcedentePromedio);
	}

	@Test
	void testCostoDeExcedenteMenorAPromedio() {
		
		when(excedente.getCostoPorExcedente()).thenReturn(1234.5);
		assertTrue(excedente.getCostoPorExcedente() < costoExcedentePromedio);
	}

	@Test
	void testCostoDeExcedenteIgualAPromedio() {
		
		when(excedente.getCostoPorExcedente()).thenReturn(15050.5);
		assertTrue(excedente.getCostoPorExcedente() == costoExcedentePromedio);
	}

}
