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

class InboundTest {

	private Inbound inbound;
	private Buque buque;
	
	@BeforeEach
	void setup() {
		buque = mock(Buque.class);
		inbound = new Inbound(buque);
	}
	
	@Test
	void testNotificaAlSerCreado() {
		verify(buque, times(1)).notificarSobreLlegadaInminente();
	}

	@Test
	void testNoPuedeHacerDeparting() {
		assertThrows(IllegalStateException.class, () -> inbound.depart(buque));
	}

	@Test
	void testNoPuedeIniciarTrabajo() {
		assertThrows(IllegalStateException.class, () -> inbound.iniciarTrabajo(buque));
	}
	
	@Test
	void testNoCambiaAArrivedPorCercania() {
		inbound.actualizarDistanciaDestino(1, buque);
		verify(buque, never()).setBuqueState(any());
	}
	
	@Test
	void testCambiaAArrivedPorCercania() {
		inbound.actualizarDistanciaDestino(0, buque);
		verify(buque, times(1)).setBuqueState(any(Arrived.class));
	}

}
