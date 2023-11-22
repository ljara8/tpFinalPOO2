package ar.edu.poo2.tpFinal.busquedaMaritima;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import ar.edu.poo2.tpFinal.CircuitosNaviera.TerminalPortuaria;
import ar.edu.poo2.tpFinal.CircuitosNaviera.Viaje;

public class PuertoDestinoTest {

	private TerminalPortuaria puertoUno;
	private TerminalPortuaria puertoDos;
	private PuertoDestino puertoDestino;
	private Viaje viaje;
	
	@Before
	public void setup() {
		puertoUno = mock(TerminalPortuaria.class);
		puertoDos = mock(TerminalPortuaria.class);
		viaje = mock(Viaje.class);
		puertoDestino = new PuertoDestino(puertoUno);
	}
	
	@Test
	public void testMismaTerminal() {
		when(viaje.getDestino()).thenReturn(puertoUno);
		assertTrue(puertoDestino.evaluar(viaje));
	}
	
	@Test
	public void testTerminalDiferente() {
		when(viaje.getDestino()).thenReturn(puertoDos);
		assertFalse(puertoDestino.evaluar(viaje));
	}
	
}