package ar.edu.poo2.tpFinal.busquedaMaritima;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Date;
import java.util.function.Predicate;

import org.junit.Before;
import org.junit.Test;

import ar.edu.poo2.tpFinal.CircuitosNaviera.Viaje;

public class FechaLlegadaTest {

	private Predicate<LocalDate> condicionFecha;
	private Viaje viaje;
	private LocalDate date;
	private FechaLlegada fechaLlegada;
	
	@Before
	public void setup() {
		condicionFecha = mock(Predicate.class);
		viaje = mock(Viaje.class);
		date = mock(LocalDate.class);
		fechaLlegada = new FechaLlegada(condicionFecha);
	}
	
	@Test
	public void testNegativeEvaluateFromFalsePredicate() {
		when(viaje.getFechaLlegada()).thenReturn(date);
		when(condicionFecha.test(any())).thenReturn(false);
		assertFalse(fechaLlegada.evaluar(viaje));
	}
	
	@Test
	public void testPositiveEvaluateFromPositivePredicate() {
		when(viaje.getFechaLlegada()).thenReturn(date);
		when(condicionFecha.test(any())).thenReturn(true);
		assertTrue(fechaLlegada.evaluar(viaje));
	}
	
}
