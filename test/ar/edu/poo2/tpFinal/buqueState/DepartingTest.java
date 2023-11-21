package ar.edu.poo2.tpFinal.buqueState;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.poo2.tpFinal.Buque;

class DepartingTest {

	private Departing departing;
	private Buque buque;
	
	@BeforeEach
	void setup() {
		departing = new Departing();
		buque = mock(Buque.class);
	}

	@Test
	void testNoSeAlejaLoSuficienteYNoAvisaATerminal() {
		departing.actualizarDistanciaDestino(0.5, buque);
		verify(buque, never()).notificarPartidaDeTerminal();
		verify(buque, never()).setBuqueState(any());
	}
	
	@Test
	void testSeAlejaLoSuficienteYSiAvisaATerminal() {
		departing.actualizarDistanciaDestino(1.2, buque);
		verify(buque, times(1)).notificarPartidaDeTerminal();
		verify(buque, times(1)).setBuqueState(any(Outbound.class));
	}
	
	@Test
	void testNoPuedeHacerDeparting() {
		assertThrows(IllegalStateException.class, () -> departing.depart(buque));
	}
	
	@Test
	void testNoPuedeIniciarTrabajo() {
		assertThrows(IllegalStateException.class, () -> departing.iniciarTrabajo(buque));
	}
	
}
