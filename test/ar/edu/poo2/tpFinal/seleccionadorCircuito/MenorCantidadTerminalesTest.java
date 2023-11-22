package ar.edu.poo2.tpFinal.seleccionadorCircuito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ar.edu.poo2.tpFinal.CircuitosNaviera.CircuitoMaritimo;

public class MenorCantidadTerminalesTest{
	
	private List<CircuitoMaritimo> circuitos;
	private CircuitoMaritimo primerCircuito;
	private CircuitoMaritimo segundoCircuito;
	private CircuitoMaritimo tercerCircuito;
	private MenorCantidadTerminales menorCantidadTerminales;
	
	@Before
	public void setup() {
		primerCircuito = mock(CircuitoMaritimo.class);
		segundoCircuito = mock(CircuitoMaritimo.class);
		tercerCircuito = mock(CircuitoMaritimo.class);
		
		circuitos = new ArrayList<CircuitoMaritimo>();
		
		menorCantidadTerminales = new MenorCantidadTerminales();
		
		when(primerCircuito.getCantidadTotalTerminales()).thenReturn(16);
		when(segundoCircuito.getCantidadTotalTerminales()).thenReturn(10);
		when(tercerCircuito.getCantidadTotalTerminales()).thenReturn(18);
		
		circuitos.add(primerCircuito);
		circuitos.add(segundoCircuito);
		circuitos.add(tercerCircuito);
	}
	
	@Test
	public void testSegundoCircuitoEsMejor() {
		assertEquals(segundoCircuito, menorCantidadTerminales.mejorCircuitoEntre(circuitos));
	}
	
	@Test
	public void testNoHayCircuitosEntoncesLanzaError() {
		circuitos.clear();
		assertThrowsExactly(IllegalArgumentException.class, () -> menorCantidadTerminales.mejorCircuitoEntre(circuitos));
	}
	
	@Test
	public void testSoloHayUnCircuito() {
		circuitos.clear();
		circuitos.add(primerCircuito);
		assertEquals(primerCircuito, menorCantidadTerminales.mejorCircuitoEntre(circuitos));
	}
	
}
