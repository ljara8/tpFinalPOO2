package ar.edu.poo2.tpFinal.busquedaMaritima;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import ar.edu.poo2.tpFinal.busquedaMaritima.And;
import ar.edu.poo2.tpFinal.busquedaMaritima.BusquedaMaritima;

public class AndTest {
	
	private And and;
	private BusquedaMaritima primeraBusqueda;
	private BusquedaMaritima segundaBusqueda;	
	
	@Before
	public void setup() {
		this.primeraBusqueda = mock(BusquedaMaritima.class);
		this.segundaBusqueda = mock(BusquedaMaritima.class);
		this.and = new And(primeraBusqueda, segundaBusqueda);
	}
	
	@Test
	public void testTrueCase() {
		when(primeraBusqueda.evaluar(any())).thenReturn(true);
		when(segundaBusqueda.evaluar(any())).thenReturn(true);
		assertTrue(and.evaluar(any()));
	}
	
	@Test
	public void testFalseCase() {
		when(primeraBusqueda.evaluar(any())).thenReturn(false);
		when(segundaBusqueda.evaluar(any())).thenReturn(true);
		assertFalse(and.evaluar(any()));
	}
	
}