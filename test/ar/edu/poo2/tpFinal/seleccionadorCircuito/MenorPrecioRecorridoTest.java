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

public class MenorPrecioRecorridoTest {
	
	private List<CircuitoMaritimo> circuitos;
	private CircuitoMaritimo primerCircuito;
	private CircuitoMaritimo segundoCircuito;
	private CircuitoMaritimo tercerCircuito;
	private MenorPrecioRecorrido menorPrecioRecorrido;
	
	@Before
	public void setup() {
		primerCircuito = mock(CircuitoMaritimo.class);
		segundoCircuito = mock(CircuitoMaritimo.class);
		tercerCircuito = mock(CircuitoMaritimo.class);
		
		circuitos = new ArrayList<CircuitoMaritimo>();
		
		menorPrecioRecorrido = new MenorPrecioRecorrido();
		
		when(primerCircuito.getPrecioTotalRecorrido()).thenReturn(1860d);
		when(segundoCircuito.getPrecioTotalRecorrido()).thenReturn(1350d);
		when(tercerCircuito.getPrecioTotalRecorrido()).thenReturn(1400d);
		
		circuitos.add(primerCircuito);
		circuitos.add(segundoCircuito);
		circuitos.add(tercerCircuito);
	}
	
	@Test
	public void testSegundoCircuitoEsMejor() {
		assertEquals(segundoCircuito, menorPrecioRecorrido.mejorCircuitoEntre(circuitos));
	}
	
	@Test
	public void testNoHayCircuitosEntoncesLanzaError() {
		circuitos.clear();
		assertThrowsExactly(IllegalArgumentException.class, () -> menorPrecioRecorrido.mejorCircuitoEntre(circuitos));
	}
	
	@Test
	public void testSoloHayUnCircuito() {
		circuitos.clear();
		circuitos.add(primerCircuito);
		assertEquals(primerCircuito, menorPrecioRecorrido.mejorCircuitoEntre(circuitos));
	}
	
}
