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

class WorkingTest {

	private Working working;
	private Buque buque;
	
	@BeforeEach
	void setup() {
		working = new Working();
		buque = mock(Buque.class);
	}

	@Test
	void testNoPuedeIniciarTrabajo() {
		assertThrows(IllegalStateException.class, () -> working.iniciarTrabajo(buque));
	}
	
	@Test
	void testSeLlamaAOrdenDepartYCambiaADepart() {
		working.depart(buque);
		verify(buque, times(1)).setBuqueState(any(Departing.class));
	}
	
	@Test
	void testActualizoPosicionYNoCambiaNada() {
		working.actualizarDistanciaDestino(50, buque);
		working.actualizarDistanciaDestino(5, buque);
		working.actualizarDistanciaDestino(0, buque);
		verify(buque, never()).setBuqueState(any());
	}

}
