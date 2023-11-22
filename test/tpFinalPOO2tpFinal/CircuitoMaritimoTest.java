package tpFinalPOO2tpFinal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

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
	void testTerminalOrigen() {
		
		assertEquals(primeraTerminal, circuito.getOrigen());
	}
	
	@Test
	void testTerminalDestino() {
		
		assertEquals(quintaTerminal, circuito.getDestino());
	}
	
	
	@Test
	void testTiempoTotalCorrecto() {
		
		assertEquals(8, circuito.getTiempoTotalRecorrido());
	}
	
	@Test 
	void testPrecioTotal() {
		
		assertEquals(1200, circuito.getPrecioTotalRecorrido());
	}
	
	@Test
	void testTotalTerminales() {
		
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
	void testTiempoDeLlegadaEntreTerminales() {
		
		assertTrue(circuito.tieneTrayectoEntreTerminales(segundaTerminal, cuartaTerminal));
		assertEquals(6, circuito.tiempoDeLlegadaEntre(segundaTerminal, quintaTerminal));	
	}	
	
	@Test
	void testTiempoDeLlegadaEntreTerminalesThrowException() {
		
		assertFalse(circuito.tieneTrayectoEntreTerminales(segundaTerminal, sextaTerminal));
		assertThrowsExactly(RuntimeException.class,() -> circuito.tiempoDeLlegadaEntre(segundaTerminal, sextaTerminal));	
	}	
	
	@Test 
	void testPrecioEntreTrayectos(){
		
		assertTrue(circuito.tieneTrayectoEntreTerminales(segundaTerminal, cuartaTerminal));
		assertEquals(600, circuito.precioDelTrayectoEntre(segundaTerminal, cuartaTerminal));
	}
	
	@Test 
	void testPrecioEntreTrayectosThrowException() {
		
		assertFalse(circuito.tieneTrayectoEntreTerminales(segundaTerminal, sextaTerminal));
		assertThrowsExactly(RuntimeException.class,() -> circuito.precioDelTrayectoEntre(segundaTerminal, sextaTerminal));
	}
}
