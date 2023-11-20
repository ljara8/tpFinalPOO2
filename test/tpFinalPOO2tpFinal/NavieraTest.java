package tpFinalPOO2tpFinal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.poo2.tpFinal.CircuitosNaviera.CircuitoMaritimo;
import ar.edu.poo2.tpFinal.CircuitosNaviera.Naviera;
import ar.edu.poo2.tpFinal.CircuitosNaviera.TerminalPortuaria;

class NavieraTest {
	
	private CircuitoMaritimo primerCircuito;
	private CircuitoMaritimo segundoCircuito;
	private CircuitoMaritimo tecerCircuito;
	private CircuitoMaritimo cuartoCircuito;
	private TerminalPortuaria primeraTerminal;
	private TerminalPortuaria segundaTerminal;
	private TerminalPortuaria terceraTerminal;
	private Naviera naviera;
	
	@BeforeEach
	public void setUp() {
		naviera = new Naviera();
		
		primerCircuito = mock(CircuitoMaritimo.class);
		segundoCircuito = mock(CircuitoMaritimo.class);
		tecerCircuito = mock(CircuitoMaritimo.class);
		cuartoCircuito = mock(CircuitoMaritimo.class);

		primeraTerminal = mock(TerminalPortuaria.class);
		segundaTerminal = mock(TerminalPortuaria.class);
		terceraTerminal = mock(TerminalPortuaria.class);
		naviera.agregarCircuito(primerCircuito);
		naviera.agregarCircuito(segundoCircuito);
		naviera.agregarCircuito(tecerCircuito);
		
	}

	@Test
	void testTieneCircuitoConTerminal() {
		when(primerCircuito.tieneTerminalEnTrayecto(segundaTerminal)).thenReturn(false);
		when(segundoCircuito.tieneTerminalEnTrayecto(segundaTerminal)).thenReturn(false);
		when(tecerCircuito.tieneTerminalEnTrayecto(segundaTerminal)).thenReturn(true);
		when(cuartoCircuito.tieneTerminalEnTrayecto(segundaTerminal)).thenReturn(false);
		
		assertTrue(naviera.tieneCircuitoConTerminal(segundaTerminal));
	}
	
	@Test
	void testTiempoEntreTerminales() throws Exception {
		when(primerCircuito.tieneTrayectoEntreTerminales(primeraTerminal, terceraTerminal)).thenReturn(false);
		when(segundoCircuito.tieneTrayectoEntreTerminales(primeraTerminal, terceraTerminal)).thenReturn(true);
		when(tecerCircuito.tieneTrayectoEntreTerminales(primeraTerminal, terceraTerminal)).thenReturn(false);
		when(cuartoCircuito.tieneTrayectoEntreTerminales(primeraTerminal, terceraTerminal)).thenReturn(true);
		
		when(primerCircuito.tiempoDeLlegadaEntre(primeraTerminal, terceraTerminal)).thenReturn(0);
		when(segundoCircuito.tiempoDeLlegadaEntre(primeraTerminal, terceraTerminal)).thenReturn(3);
		when(tecerCircuito.tiempoDeLlegadaEntre(primeraTerminal, terceraTerminal)).thenReturn(0);
		when(cuartoCircuito.tiempoDeLlegadaEntre(primeraTerminal, terceraTerminal)).thenReturn(3);
		
		assertEquals(3, naviera.cuantoTardaEnLlegarNaviera(primeraTerminal, terceraTerminal));
	}
}
