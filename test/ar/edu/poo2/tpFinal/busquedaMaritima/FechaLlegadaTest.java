package ar.edu.poo2.tpFinal;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

import java.util.Date;
import java.util.function.Predicate;

class FechaLlegadaTest {
	
	private Predicate<Date> condicionFecha;
	private FechaLlegada fechaLlegada;
	private Viaje viaje;
	private Date fecha;
	
	@BeforeEach
	void setUp() {
		condicionFecha = mock(Predicate.class);
		fechaLlegada = new FechaLlegada(condicionFecha);
		viaje = mock(Viaje.class);
		fecha = mock(Date.class);
	}

	@Test
	void testNegativeEvaluateFromFalsePredicate() {
		when(condicionFecha.test(any(Date.class))).thenReturn(false);
		when(viaje.getFechaLlegada()).thenReturn(fecha);
		assertFalse(fechaLlegada.evaluar(viaje));
	}
	
	@Test
	void testPositiveEvaluateFromTruePredicate() {
		when(condicionFecha.test(any(Date.class))).thenReturn(true);
		when(viaje.getFechaLlegada()).thenReturn(fecha);
		assertTrue(fechaLlegada.evaluar(viaje));
	}

}
