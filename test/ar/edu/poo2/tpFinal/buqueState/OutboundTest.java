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

class OutboundTest {

	private Outbound outbound;
	private Buque buque;
	
	@BeforeEach
	void setup() {
		outbound = new Outbound();
		buque = mock(Buque.class);
	}

	@Test
	void testNoPuedeHacerDeparting() {
		assertThrows(IllegalStateException.class, () -> outbound.depart(buque));
	}

	@Test
	void testNoPuedeIniciarTrabajo() {
		assertThrows(IllegalStateException.class, () -> outbound.iniciarTrabajo(buque));
	}
	
	@Test
	void testNoCambiaAInboundPorLejania() {
		outbound.actualizarDistanciaDestino(51, buque);
		verify(buque, never()).setBuqueState(any());
	}
	
	@Test
	void testCambiaAInboundPorLejania() {
		outbound.actualizarDistanciaDestino(49, buque);
		verify(buque, times(1)).setBuqueState(any(Inbound.class));
	}
	
}
