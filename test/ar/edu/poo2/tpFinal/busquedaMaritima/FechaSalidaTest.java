package ar.edu.poo2.tpFinal.busquedaMaritima;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.function.Predicate;

import org.junit.Before;
import org.junit.Test;

import ar.edu.poo2.tpFinal.Viaje;

public class FechaSalidaTest {

	private Predicate<Date> condicionFecha;
	private Viaje viaje;
	private Date date;
	private FechaSalida fechaSalida;
	
	@Before
	public void setup() {
		condicionFecha = mock(Predicate.class);
		viaje = mock(Viaje.class);
		date = mock(Date.class);
		fechaSalida = new FechaSalida(condicionFecha);
	}
	
	@Test
	public void testNegativeEvaluateFromFalsePredicate() {
		when(viaje.getFechaLlegada()).thenReturn(date);
		when(condicionFecha.test(any())).thenReturn(false);
		assertFalse(fechaSalida.evaluar(viaje));
	}
	
	@Test
	public void testPositiveEvaluateFromPositivePredicate() {
		when(viaje.getFechaLlegada()).thenReturn(date);
		when(condicionFecha.test(any())).thenReturn(true);
		assertTrue(fechaSalida.evaluar(viaje));
	}
	
}
