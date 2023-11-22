package ar.edu.poo2.tpFinal.busquedaMaritima;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

public class OrTest {
 
	private Or or;
	private BusquedaMaritima primeraBusqueda;
	private BusquedaMaritima segundaBusqueda;	
	
	@Before
	public void setup() {
		this.primeraBusqueda = mock(BusquedaMaritima.class);
		this.segundaBusqueda = mock(BusquedaMaritima.class);
		this.or = new Or(primeraBusqueda, segundaBusqueda);
	}
	
	@Test
	public void testTrueCase() {
		when(primeraBusqueda.evaluar(any())).thenReturn(false);
		when(segundaBusqueda.evaluar(any())).thenReturn(true);
		assertTrue(or.evaluar(any()));
	}
	
	@Test
	public void testFalseCase() {
		when(primeraBusqueda.evaluar(any())).thenReturn(false);
		when(segundaBusqueda.evaluar(any())).thenReturn(false);
		assertFalse(or.evaluar(any()));
	}
	
}