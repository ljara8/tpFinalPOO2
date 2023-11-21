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

class ArrivedTest {

	private Arrived arrived;
	private Buque buque;
	
	@BeforeEach
	void setup() {
		arrived = new Arrived();
		buque = mock(Buque.class);
	}

	@Test
	void testNoPuedeHacerDeparting() {
		assertThrows(IllegalStateException.class, () -> arrived.depart(buque));
	}
	
	@Test
	void testComienzaTrabajoYCambiaAWorking() {
		arrived.iniciarTrabajo(buque);
		verify(buque, times(1)).setBuqueState(any(Working.class));
	}
	
	@Test
	void testActualizoPosicionYNoCambiaNada() {
		arrived.actualizarDistanciaDestino(50, buque);
		arrived.actualizarDistanciaDestino(5, buque);
		arrived.actualizarDistanciaDestino(0, buque);
		verify(buque, never()).setBuqueState(any());
	}

}
