package tpFinalPOO2tpFinal;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.poo2.tpFinal.CircuitosNaviera.TerminalPortuaria;
import ar.edu.poo2.tpFinal.CircuitosNaviera.Tramo;

class TramoTest {
	
	private TerminalPortuaria primeraTerminal;
	private TerminalPortuaria segundaTerminal;
	private TerminalPortuaria terceraTerminal;
	private Tramo primerTramo;
	private Tramo segundoTramo;
	
	@BeforeEach
	public void setUp() {
		
		primeraTerminal = new TerminalPortuaria();
		segundaTerminal = new TerminalPortuaria();
		terceraTerminal = new TerminalPortuaria();
		primerTramo = new Tramo(primeraTerminal, segundaTerminal, 300, 3);
		segundoTramo = new Tramo(segundaTerminal, terceraTerminal, 250, 2);
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
