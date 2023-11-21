package ar.edu.poo2.tpFinal.CircuitoYViaje;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.poo2.tpFinal.Buque;
import ar.edu.poo2.tpFinal.CircuitosNaviera.CircuitoMaritimo;
import ar.edu.poo2.tpFinal.CircuitosNaviera.TerminalPortuaria;
import ar.edu.poo2.tpFinal.CircuitosNaviera.Viaje;

class ViajeTest {
	
	private Buque buque1;
	private Buque buque2;
	private LocalDate fecha1 = LocalDate.of(2023, 10, 19);
	private LocalDate fecha2 = LocalDate.of(2023, 11, 10);
	private LocalDate fechaEsperada2 = LocalDate.of(2023, 11, 14);
	private CircuitoMaritimo circuitoMock;
	private CircuitoMaritimo circuito1;
	private Viaje viaje1;
	private Viaje viaje2;
	private TerminalPortuaria terminal1;
	private TerminalPortuaria terminal2;
	private TerminalPortuaria terminal3;
	
	
	@BeforeEach
	void setUp() {
		buque1 = mock(Buque.class);
		buque2 = mock(Buque.class);
		terminal1 = mock(TerminalPortuaria.class);
		terminal2 = mock(TerminalPortuaria.class);
		terminal3 = mock(TerminalPortuaria.class);
		circuitoMock = mock(CircuitoMaritimo.class);
		circuito1 = new CircuitoMaritimo(terminal1, terminal2, 500, 4);
		viaje1 = new Viaje(circuitoMock, buque1, fecha1);
		viaje2 = new Viaje(circuito1, buque2, fecha2);
		
	}
	
	@Test
	void testTieneTrayectoEntreTerminales() {
		when(circuitoMock.tieneTrayectoEntreTerminales(terminal1, terminal3)).thenReturn(true);
		
		assertTrue(viaje1.tieneTrayectoEntre(terminal1, terminal3));	
	}
	
	@Test
	void testNoTieneTrayectoEntreTerminales() {
		when(circuitoMock.tieneTrayectoEntreTerminales(terminal1, terminal2)).thenReturn(false);
		
		assertFalse(viaje1.tieneTrayectoEntre(terminal1, terminal2));	
	}
	

	@Test
	void testFechaLlegadaATerminal() throws Exception {
		circuito1.agregarTramoHacia(terminal3,200, 3);
		
		
		assertEquals(fechaEsperada2, viaje2.fechaLlegadaATerminal(terminal2));
	}
	
	
	
	
	
	
	
	
}
