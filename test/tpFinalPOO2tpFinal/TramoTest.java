package tpFinalPOO2tpFinal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.poo2.tpFinal.MailManager;
import ar.edu.poo2.tpFinal.CircuitosNaviera.TerminalPortuaria;
import ar.edu.poo2.tpFinal.CircuitosNaviera.Tramo;
import ar.edu.poo2.tpFinal.seleccionadorCircuito.SeleccionadorCircuito;

class TramoTest {
	
	private TerminalPortuaria primeraTerminal;
	private TerminalPortuaria segundaTerminal;
	private TerminalPortuaria terceraTerminal;
	private Tramo primerTramo;
	private Tramo segundoTramo;
	
	@BeforeEach
	public void setUp() {
		primeraTerminal = new TerminalPortuaria(mock(MailManager.class), mock(SeleccionadorCircuito.class));
		segundaTerminal = new TerminalPortuaria(mock(MailManager.class), mock(SeleccionadorCircuito.class));
		terceraTerminal = new TerminalPortuaria(mock(MailManager.class), mock(SeleccionadorCircuito.class));
		primerTramo = new Tramo(primeraTerminal, segundaTerminal, 300, 3);
		segundoTramo = new Tramo(segundaTerminal, terceraTerminal, 250, 2);
	}
	
	@Test
	void testTiempoCorrecto() {
		
		assertEquals(2, segundoTramo.getTiempo());
	}
	
	@Test
	void testTiempoIncorrecto() {
		
		assertNotEquals(5, segundoTramo.getTiempo());
	}
	
	@Test
	void testPrecioCorrcto() {
		
		assertEquals(300, primerTramo.getPrecio());
	}
	
	@Test
	void testPrecioIncorrcto() {
		
		assertNotEquals(200, primerTramo.getPrecio());
	}
	
	@Test
	void testTramoContieneLaTerminal() {
		
		assertTrue(primerTramo.tieneTerminal(primeraTerminal));
	}
	
	@Test
	void testTramoNoContieneLaTerminal() {
		
		assertFalse(segundoTramo.tieneTerminal(primeraTerminal));
	}
}