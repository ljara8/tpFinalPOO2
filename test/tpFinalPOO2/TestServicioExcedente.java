package tpFinalPOO2;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.poo2.tpFinal.Camion;
import ar.edu.poo2.tpFinal.Chofer;
import ar.edu.poo2.tpFinal.CircuitosNaviera.TerminalPortuaria;
import ar.edu.poo2.tpFinal.CircuitosNaviera.Viaje;
import ar.edu.poo2.tpFinal.clientes.Consignee;
import ar.edu.poo2.tpFinal.contyserv.Container;
import ar.edu.poo2.tpFinal.contyserv.Excedente;
import ar.edu.poo2.tpFinal.ordenes.FacturaResponsableViaje;
import ar.edu.poo2.tpFinal.ordenes.Orden;
import ar.edu.poo2.tpFinal.ordenes.OrdenImportacion;

class TestServicioExcedente {

	private Consignee cliente;
	private Container cont;
	private Camion cam;
	private Chofer chofer;
	private Viaje viaje;
	private FacturaResponsableViaje fact;
	private double montoTotal;
	private Orden orden;
	private double costoExcedentePromedio;
	private int ancho = 50;
	private int largo = 20;
	private int altura = 30;
	private double peso = 100;
	private Excedente excedente;

	@BeforeEach
	void setUp() throws Exception {
		viaje = mock(Viaje.class);
		when(viaje.getOrigen()).thenReturn(mock(TerminalPortuaria.class));
		orden = new OrdenImportacion(cliente, cont, cam, chofer, viaje, fact);
		cont = new Container(ancho, largo, altura, peso);

		costoExcedentePromedio = 15050.5;
		excedente = new Excedente(costoExcedentePromedio, cont);
		montoTotal = excedente.montoTotal(orden);
	}

	@Test
	void testExcedentePorMasDeUnDiaDeDemora() {

		assertEquals(excedente.montoTotal(orden), montoTotal);
	}

	@Test
	void testCostoDeExcedenteMayorAPromedio() {

		costoExcedentePromedio = 1003;
		assertTrue(excedente.getCostoPorExcedente() > costoExcedentePromedio);
	}

	@Test
	void testCostoDeExcedenteMenorAPromedio() {

		costoExcedentePromedio = 540312;
		assertTrue(excedente.getCostoPorExcedente() < costoExcedentePromedio);
	}

	@Test
	void testCostoDeExcedenteIgualAPromedio() {

		assertTrue(excedente.getCostoPorExcedente() == costoExcedentePromedio);
	}

}
