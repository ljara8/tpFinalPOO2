package tpFinalPOO2tpFinal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.poo2.tpFinal.CircuitosNaviera.CircuitoMaritimo;
import ar.edu.poo2.tpFinal.CircuitosNaviera.CronogramaViaje;
import ar.edu.poo2.tpFinal.CircuitosNaviera.TerminalPortuaria;


class CronogramaViajeTest {
	
	TerminalPortuaria terminal1;
	TerminalPortuaria terminal2;
	TerminalPortuaria terminal3;
	TerminalPortuaria terminal4;
	CircuitoMaritimo circuito1;
	CircuitoMaritimo circuito2;
	LocalDateTime fecha1 = LocalDateTime.of(2023, 3, 5, 0, 0, 0);
	LocalDateTime fecha2 = LocalDateTime.of(2023, 3, 17, 0, 0, 0);
	LocalDateTime fechaEsperada1 = LocalDateTime.of(2023, 3, 8, 0, 0, 0);
	LocalDateTime fechaEsperada2 = LocalDateTime.of(2023, 3, 23, 0, 0, 0);
	CronogramaViaje cronograma;
	
	@BeforeEach
	void setUp() {
		terminal1 = mock(TerminalPortuaria.class);
		terminal2 = mock(TerminalPortuaria.class);
		terminal3 = mock(TerminalPortuaria.class);
		terminal4 = mock(TerminalPortuaria.class);
		circuito1 = new CircuitoMaritimo(terminal1, terminal2, 300, 3);
		circuito2 = new CircuitoMaritimo(terminal2, terminal3, 200, 2);
	}
	
	@Test
	void testFechaSalida() {
		cronograma = new CronogramaViaje(circuito1,fecha1);
		
		assertEquals(fecha1, cronograma.getFechaSalida());
	}
	
	@Test
	void testFechaLlegada() {
		cronograma = new CronogramaViaje(circuito1, fecha1);
	
		assertEquals(fechaEsperada1, cronograma.getFechaLlegada());
	}
	
	@Test
	void testFechaLlegadaATerminal() {
		circuito2.agregarTramoHacia(terminal4, 400, 4);
		cronograma = new CronogramaViaje(circuito2, fecha2);
	
		assertEquals(fechaEsperada2, cronograma.fechaLlegadaATerminal(terminal4));
		
	}
	
	@Test
	void testFechaLlegadaATerminalNoTieneTerminalThrowException() {
		circuito2.agregarTramoHacia(terminal4, 400, 4);
		cronograma = new CronogramaViaje(circuito2, fecha2);

		assertThrowsExactly(NoSuchElementException.class, () -> cronograma.fechaLlegadaATerminal(terminal1));
		
	}
}