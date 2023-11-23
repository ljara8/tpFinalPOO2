package terminalPortuaria;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.poo2.tpFinal.MailManager;
import ar.edu.poo2.tpFinal.CircuitosNaviera.Naviera;
import ar.edu.poo2.tpFinal.CircuitosNaviera.TerminalPortuaria;
import ar.edu.poo2.tpFinal.seleccionadorCircuito.SeleccionadorCircuito;

class TerminalPortuariaTiempoYFechaTest {
	
	private TerminalPortuaria terminalGestionada;
	private TerminalPortuaria primeraTerminal;
	private TerminalPortuaria segundaTerminal;
	private Naviera naviera1;
	private Naviera naviera2;
	private LocalDateTime fechaEsperada = LocalDateTime.of(2023,10,5,0,0,0);
	
	@BeforeEach
	void setUp() {
		terminalGestionada = new TerminalPortuaria(mock(MailManager.class), mock(SeleccionadorCircuito.class));
		primeraTerminal = mock(TerminalPortuaria.class);
		segundaTerminal = mock(TerminalPortuaria.class);
		naviera1 = mock(Naviera.class);
		naviera2 = mock(Naviera.class);
		when(naviera1.tieneCircuitoConTerminal(terminalGestionada)).thenReturn(true);
		when(naviera2.tieneCircuitoConTerminal(terminalGestionada)).thenReturn(true);
		terminalGestionada.registrarNaviera(naviera1);
		terminalGestionada.registrarNaviera(naviera2);

	}
	
	@Test
	void testProximaFechaDePartidaHaciaDestino() {
		when(naviera1.tieneCircuitoConTrayecto(terminalGestionada, segundaTerminal)).thenReturn(true);
		when(naviera2.tieneCircuitoConTrayecto(terminalGestionada, segundaTerminal)).thenReturn(true);
		when(naviera1.proximaFechaDePartidaADestino(terminalGestionada, segundaTerminal)).thenReturn(fechaEsperada);
		when(naviera2.proximaFechaDePartidaADestino(terminalGestionada, segundaTerminal)).thenReturn(fechaEsperada);
		
		assertEquals(fechaEsperada, terminalGestionada.proximaFechaDePartidaHaciaDestino(segundaTerminal));
	}

	@Test
	void testNoHayProximaFechaDePartidaHaciaDestino() {
		when(naviera1.tieneCircuitoConTrayecto(terminalGestionada, primeraTerminal)).thenReturn(false);
		when(naviera2.tieneCircuitoConTrayecto(terminalGestionada, primeraTerminal)).thenReturn(false);
		
		assertThrowsExactly(NoSuchElementException.class, () -> terminalGestionada.proximaFechaDePartidaHaciaDestino(primeraTerminal));
	}
	
	@Test
	void testTiempoDeLlegadaATerminal() {
		when(naviera1.tieneCircuitoConTrayecto(terminalGestionada, segundaTerminal)).thenReturn(true);
		when(naviera2.tieneCircuitoConTrayecto(terminalGestionada, segundaTerminal)).thenReturn(true);
		when(naviera1.cuantoTardaEnLlegarNaviera(terminalGestionada, segundaTerminal)).thenReturn(3);
		when(naviera2.cuantoTardaEnLlegarNaviera(terminalGestionada, segundaTerminal)).thenReturn(5);
		
		assertEquals(3, terminalGestionada.cuantoTardaEnLlegarNavieraADestino(segundaTerminal));
	}
	
	@Test
	void testNohayTiempoDeLlegadaATerminal() {
		when(naviera1.tieneCircuitoConTrayecto(terminalGestionada, primeraTerminal)).thenReturn(false);
		when(naviera2.tieneCircuitoConTrayecto(terminalGestionada, primeraTerminal)).thenReturn(false);
		
		assertThrowsExactly(NoSuchElementException.class, () -> terminalGestionada.cuantoTardaEnLlegarNavieraADestino(primeraTerminal));
	}
}