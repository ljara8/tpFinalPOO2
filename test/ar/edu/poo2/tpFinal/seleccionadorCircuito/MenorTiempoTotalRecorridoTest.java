package ar.edu.poo2.tpFinal.seleccionadorCircuito;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class MenorTiempoTotalRecorridoTest {
	
	private List<CircuitoMaritimo> circuitos;
	private CircuitoMaritimo primerCircuito;
	private CircuitoMaritimo segundoCircuito;
	private CircuitoMaritimo tercerCircuito;
	private MenorTiempoTotalRecorrido menorTiempoTotalRecorrido;
	
	@Before
	public void setup() {
		primerCircuito = mock(CircuitoMaritimo.class);
		segundoCircuito = mock(CircuitoMaritimo.class);
		tercerCircuito = mock(CircuitoMaritimo.class);
		
		circuitos = new ArrayList<CircuitoMaritimo>();
		
		menorTiempoTotalRecorrido = new MenorTiempoTotalRecorrido();
		
		when(primerCircuito.getTiempoTotalRecorrido()).thenReturn(27);
		when(segundoCircuito.getTiempoTotalRecorrido()).thenReturn(24);
		when(tercerCircuito.getTiempoTotalRecorrido()).thenReturn(37);
		
		circuitos.add(primerCircuito);
		circuitos.add(segundoCircuito);
		circuitos.add(tercerCircuito);
	}
	
	@Test
	public void testSegundoCircuitoEsMejor() {
		assertEquals(segundoCircuito, menorTiempoTotalRecorrido.mejorCircuitoEntre(circuitos));
	}
	
	@Test
	public void testNoHayCircuitosEntoncesLanzaError() {
		circuitos.clear();
		assertThrowsExactly(IllegalArgumentException.class, () -> menorTiempoTotalRecorrido.mejorCircuitoEntre(circuitos));
	}
	
	@Test
	public void testSoloHayUnCircuito() {
		circuitos.clear();
		circuitos.add(primerCircuito);
		assertEquals(primerCircuito, menorTiempoTotalRecorrido.mejorCircuitoEntre(circuitos));
	}
	
}
