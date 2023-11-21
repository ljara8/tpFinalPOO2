package tpFinalPOO2tpFinal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.util.NoSuchElementException;

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
	private TerminalPortuaria sextaTerminal;
	
	@BeforeEach
	public void setUp() throws Exception {

		primeraTerminal = mock(TerminalPortuaria.class);
		segundaTerminal = mock(TerminalPortuaria.class);
		terceraTerminal = mock(TerminalPortuaria.class);
		cuartaTerminal = mock(TerminalPortuaria.class);
		quintaTerminal = mock(TerminalPortuaria.class);
		sextaTerminal = mock(TerminalPortuaria.class);
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
	void testNoTieneTrayectoEntreTerminales() {
		
		assertFalse(circuito.tieneTrayectoEntreTerminales(primeraTerminal, sextaTerminal));
	}
	
	@Test
	void testTiempoDeLlegadaEntreTerminales() throws Exception{
		
		assertEquals(4, circuito.tiempoDeLlegadaEntre(segundaTerminal, cuartaTerminal));	
	}
	
	@Test
	void testTiempoDeLlegadaEntreTerminalesThrowException() throws Exception{
		
		assertThrowsExactly(NoSuchElementException.class,() -> circuito.tiempoDeLlegadaEntre(segundaTerminal, sextaTerminal));	
	}
	
	@Test 
	void testPrecioEntreTrayectos() throws Exception{
		
		assertEquals(900, circuito.precioDelTrayectoEntre(segundaTerminal, quintaTerminal));
	}
	
	@Test 
	void testPrecioEntreTrayectosThrowException() throws Exception{
		
		assertThrowsExactly(NoSuchElementException.class,() -> circuito.precioDelTrayectoEntre(segundaTerminal, sextaTerminal));
	}
}
