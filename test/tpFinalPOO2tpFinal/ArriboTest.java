package tpFinalPOO2tpFinal;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.poo2.tpFinal.CircuitosNaviera.Arribo;
import ar.edu.poo2.tpFinal.CircuitosNaviera.TerminalPortuaria;

class ArriboTest {
	
	private TerminalPortuaria primeraTerminal;
	private TerminalPortuaria segundaTerminal;
	private LocalDateTime fecha1 = LocalDateTime.of(2023, 10, 5, 0, 0, 0);
	private LocalDateTime fecha2 = LocalDateTime.of(2023, 10, 15, 0, 0, 0);
	private Arribo arribo1;
	private Arribo arribo2;
	
	@BeforeEach
	public void setUp() {
		primeraTerminal = mock(TerminalPortuaria.class);
		segundaTerminal = mock(TerminalPortuaria.class);
		arribo1= new Arribo(primeraTerminal, fecha1);
		arribo2= new Arribo(segundaTerminal, fecha2);
		
	}
	
	@Test
	void testTerminalCorrecta() {
		
		assertEquals(primeraTerminal, arribo1.getDestino());
	}
	
	@Test
	void testTerminalIncorrecta() {
		
		assertNotEquals(primeraTerminal, arribo2.getDestino());
	}

	@Test
	void testFechaCorrecta() {
		
		assertEquals(fecha1, arribo1.getFechaDeArribo());
	}
	
	@Test
	void testFechaIncorrecta() {
		
		assertNotEquals(fecha1, arribo2.getFechaDeArribo());
	}
}
