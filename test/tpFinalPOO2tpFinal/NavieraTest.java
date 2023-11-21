package tpFinalPOO2tpFinal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
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
	private CircuitoMaritimo tecerCircuito;
	private TerminalPortuaria primeraTerminal;
	private TerminalPortuaria segundaTerminal;
	private TerminalPortuaria terceraTerminal;
	private Viaje viaje1;
	private Viaje viaje2;
	private LocalDate fecha = LocalDate.of(2023, 5, 12);
	private Naviera naviera;
	
	@BeforeEach
	public void setUp() {
		naviera = new Naviera();
		
		primerCircuito = mock(CircuitoMaritimo.class);
		segundoCircuito = mock(CircuitoMaritimo.class);
		tecerCircuito = mock(CircuitoMaritimo.class);

		primeraTerminal = mock(TerminalPortuaria.class);
		segundaTerminal = mock(TerminalPortuaria.class);
		terceraTerminal = mock(TerminalPortuaria.class);
		
		viaje1 = mock(Viaje.class);
		viaje2 = mock(Viaje.class);
		
		naviera.agregarCircuito(primerCircuito);
		naviera.agregarCircuito(segundoCircuito);
		naviera.agregarCircuito(tecerCircuito);
		naviera.agregarViaje(viaje1);
		naviera.agregarViaje(viaje2);
	}

	@Test
	void testTieneCircuitoConTerminal() {
		when(primerCircuito.tieneTerminalEnTrayecto(segundaTerminal)).thenReturn(false);
		when(segundoCircuito.tieneTerminalEnTrayecto(segundaTerminal)).thenReturn(false);
		when(tecerCircuito.tieneTerminalEnTrayecto(segundaTerminal)).thenReturn(true);
		
		assertTrue(naviera.tieneCircuitoConTerminal(segundaTerminal));
	}
	
	@Test
	void testNoTieneCircuitoConTerminal() {
		when(primerCircuito.tieneTerminalEnTrayecto(segundaTerminal)).thenReturn(false);
		when(segundoCircuito.tieneTerminalEnTrayecto(segundaTerminal)).thenReturn(false);
		when(tecerCircuito.tieneTerminalEnTrayecto(segundaTerminal)).thenReturn(false);
		
		assertFalse(naviera.tieneCircuitoConTerminal(segundaTerminal));
	}
	
	@Test
	void testTiempoEntreTerminales() throws Exception {
		when(primerCircuito.tieneTrayectoEntreTerminales(primeraTerminal, terceraTerminal)).thenReturn(false);
		when(segundoCircuito.tieneTrayectoEntreTerminales(primeraTerminal, terceraTerminal)).thenReturn(true);
		
		when(primerCircuito.tiempoDeLlegadaEntre(primeraTerminal, terceraTerminal)).thenReturn(0);
		when(segundoCircuito.tiempoDeLlegadaEntre(primeraTerminal, terceraTerminal)).thenReturn(3);
		
		assertEquals(3, naviera.cuantoTardaEnLlegarNaviera(primeraTerminal, terceraTerminal));
	}
	
	@Test
	void testProximaFechaPartidaADestino() throws Exception {
		when(viaje2.tieneTrayectoEntre(segundaTerminal, terceraTerminal)).thenReturn(true);
		when(viaje2.getFechaSalida()).thenReturn(fecha);
		
		assertEquals(fecha, naviera.proximaFechaDePartidaADestino(segundaTerminal, terceraTerminal));
	}
	
	@Test
	void testProximaFechaLlegadaADestinoThrowException() throws Exception {
		when(viaje1.tieneTrayectoEntre(primeraTerminal, terceraTerminal)).thenReturn(true);
		when(viaje1.fechaLlegadaATerminal(segundaTerminal)).thenThrow(NoSuchElementException.class);
		
		assertThrowsExactly(NoSuchElementException.class, () -> naviera.proximaFechaDeLlegadaADestino(primeraTerminal, segundaTerminal));
	}
}
