package tpFinalPOO2tpFinal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.poo2.tpFinal.CircuitosNaviera.CircuitoMaritimo;
import ar.edu.poo2.tpFinal.CircuitosNaviera.Naviera;
import ar.edu.poo2.tpFinal.CircuitosNaviera.TerminalPortuaria;
import ar.edu.poo2.tpFinal.CircuitosNaviera.Viaje;

class NavieraTest {
	
	private CircuitoMaritimo primerCircuito;
	private CircuitoMaritimo segundoCircuito;
	private TerminalPortuaria primeraTerminal;
	private TerminalPortuaria segundaTerminal;
	private TerminalPortuaria terceraTerminal;
	private Viaje viaje1;
	private Viaje viaje2;
	private LocalDateTime fecha1 = LocalDateTime.of(2023, 5, 12, 0, 0, 0);
	private LocalDateTime fecha2 = LocalDateTime.of(2023, 5, 15, 0, 0, 0);
	private Naviera naviera;
	
	@BeforeEach
	public void setUp() {
		naviera = new Naviera();
		
		primerCircuito = mock(CircuitoMaritimo.class);
		segundoCircuito = mock(CircuitoMaritimo.class);

		primeraTerminal = mock(TerminalPortuaria.class);
		segundaTerminal = mock(TerminalPortuaria.class);
		terceraTerminal = mock(TerminalPortuaria.class);
		
		viaje1 = mock(Viaje.class);
		viaje2 = mock(Viaje.class);
		
		naviera.agregarCircuito(primerCircuito);
		naviera.agregarCircuito(segundoCircuito);
		naviera.agregarViaje(viaje1);
		naviera.agregarViaje(viaje2);
	}

	@Test
	void testTieneCircuitoConTerminal() {
		when(primerCircuito.tieneTerminalEnTrayecto(segundaTerminal)).thenReturn(true);
		primerCircuito.tieneTerminalEnTrayecto(segundaTerminal);
		
		verify(primerCircuito,times(1)).tieneTerminalEnTrayecto(segundaTerminal);
		
		assertTrue(naviera.tieneCircuitoConTerminal(segundaTerminal));
	}
	
	@Test
	void testCircuitosContenidos() {
		HashSet<CircuitoMaritimo> circuitosEsperados = new HashSet<>();
		circuitosEsperados.add(primerCircuito);
		circuitosEsperados.add(segundoCircuito);
		
		assertEquals(circuitosEsperados, naviera.getCircuitos());
	}
	
	@Test
	void testViajesContenidos() {
		HashSet<Viaje> viajesEsperados = new HashSet<>();
		viajesEsperados.add(viaje1);
		viajesEsperados.add(viaje2);
		
		assertEquals(viajesEsperados, naviera.getViajes());
	}
	
	
	@Test
	void testNoTieneCircuitoConTerminal() {
		when(segundoCircuito.tieneTerminalEnTrayecto(segundaTerminal)).thenReturn(false);
		segundoCircuito.tieneTerminalEnTrayecto(segundaTerminal);
		
		verify(segundoCircuito,times(1)).tieneTerminalEnTrayecto(segundaTerminal);
		
		assertFalse(naviera.tieneCircuitoConTerminal(segundaTerminal));
	}
	
	@Test
	void testTieneCircuitoConTrayecto() {
		when(primerCircuito.tieneTrayectoEntreTerminales(primeraTerminal,segundaTerminal)).thenReturn(true);
		when(segundoCircuito.tieneTrayectoEntreTerminales(primeraTerminal,segundaTerminal)).thenReturn(false);
		
		assertTrue(naviera.tieneCircuitoConTrayecto(primeraTerminal, segundaTerminal));
	}
	
	@Test
	void testTiempoEntreTerminales() throws Exception {
		when(segundoCircuito.tieneTrayectoEntreTerminales(primeraTerminal, terceraTerminal)).thenReturn(true);	
		when(primerCircuito.tieneTrayectoEntreTerminales(primeraTerminal, terceraTerminal)).thenReturn(true);	
		when(primerCircuito.tiempoDeLlegadaEntre(primeraTerminal, terceraTerminal)).thenReturn(6);
		when(segundoCircuito.tiempoDeLlegadaEntre(primeraTerminal, terceraTerminal)).thenReturn(5);
		
		assertEquals(5, naviera.cuantoTardaEnLlegarNaviera(primeraTerminal, terceraTerminal));
	}
	
	@Test
	void testProximaFechaPartidaADestino() {
		when(viaje2.tieneTrayectoEntre(segundaTerminal, terceraTerminal)).thenReturn(true);
		when(viaje2.getFechaSalida()).thenReturn(fecha1);
		naviera.proximaFechaDePartidaADestino(segundaTerminal, terceraTerminal);
		
		verify(viaje2,times(1)).tieneTrayectoEntre(segundaTerminal, terceraTerminal);
		verify(viaje2,times(1)).getFechaSalida();
		
		assertEquals(fecha1, naviera.proximaFechaDePartidaADestino(segundaTerminal, terceraTerminal));
	}
	
	@Test
	void testProximaFechaLlegadaADestino() throws Exception {
		when(viaje1.tieneTrayectoEntre(primeraTerminal, terceraTerminal)).thenReturn(true);
		when(viaje1.fechaLlegadaATerminal(terceraTerminal)).thenReturn(fecha2);
		when(viaje2.tieneTrayectoEntre(primeraTerminal, terceraTerminal)).thenReturn(true);
		when(viaje2.fechaLlegadaATerminal(terceraTerminal)).thenReturn(fecha1);
		
		assertEquals(fecha1, naviera.proximaFechaDeLlegadaADestino(primeraTerminal, terceraTerminal));
	}
	
	@Test
	void testProximaFechaLlegadaADestinoThrowException() {
		when(viaje1.tieneTrayectoEntre(primeraTerminal, terceraTerminal)).thenReturn(true);
		when(viaje1.fechaLlegadaATerminal(segundaTerminal)).thenThrow(NoSuchElementException.class);
		
		assertThrowsExactly(NoSuchElementException.class, () -> naviera.proximaFechaDeLlegadaADestino(primeraTerminal, segundaTerminal));
	}
}
