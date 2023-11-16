package tpFinalPOO2tpFinal;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.poo2.tpFinal.CircuitosNaviera.CircuitoMaritimo;
import ar.edu.poo2.tpFinal.CircuitosNaviera.TerminalPortuaria;

class CircuitoMaritimoTest {
	
	private CircuitoMaritimo circuito;
	private TerminalPortuaria primeraTerminal;
	private TerminalPortuaria segundaTerminal;
	private TerminalPortuaria terceraTerminal;
	private TerminalPortuaria cuartaTerminal;
	private TerminalPortuaria quintaTerminal;
	
	@BeforeEach
	public void setUp() throws Exception {

		primeraTerminal = new TerminalPortuaria();
		segundaTerminal = new TerminalPortuaria();
		terceraTerminal = new TerminalPortuaria();
		cuartaTerminal = new TerminalPortuaria();
		quintaTerminal = new TerminalPortuaria();
		circuito = new CircuitoMaritimo(primeraTerminal, segundaTerminal, 300, 2);
		circuito.agregarTramoHacia(terceraTerminal, 200, 1);
		circuito.agregarTramoHacia(cuartaTerminal, 400, 3);
		circuito.agregarTramoHacia(quintaTerminal, 300, 2);
	}
	
	@Test
	void testTiempoTotalCorrecto() throws Exception {
		
		assertEquals(8, circuito.getTiempoTotalRecorrido());
	}
	
	@Test 
	void testPrecioTotal() throws Exception{
		
		assertEquals(1200, circuito.getPrecioTotalRecorrido());
	}
	
	@Test
	void testTotalTerminales() throws Exception{
		
		assertEquals(5, circuito.getCantidadTotalTerminales());
	}
	
	@Test
	void testTieneTrayectoEntreTerminales() {
		
		assertTrue(circuito.tieneTrayectoEntreTerminales(segundaTerminal, terceraTerminal));
	}
	
	@Test
	void testTiempoDeLlegadaEntreTerminales() throws Exception{
		
		assertEquals(6, circuito.tiempoDeLlegadaEntre(segundaTerminal, quintaTerminal));
	}
}
