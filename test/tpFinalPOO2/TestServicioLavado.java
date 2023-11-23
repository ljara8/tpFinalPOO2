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
import ar.edu.poo2.tpFinal.contyserv.Lavado;
import ar.edu.poo2.tpFinal.ordenes.FacturaResponsableViaje;
import ar.edu.poo2.tpFinal.ordenes.Orden;
import ar.edu.poo2.tpFinal.ordenes.OrdenImportacion;

class TestServicioLavado {

	private OrdenImportacion orden;
	private double costoLavadoPromedio;
	private double costoFijo;

	private Consignee cliente;

	private Camion cam;
	private Chofer chofer;
	private Viaje viaje;
	private FacturaResponsableViaje fact;
	private int ancho = 50;
	private int largo = 20;
	private int altura = 30;
	private double peso = 100;
	private Container cont;
	private Lavado lavado;

	@BeforeEach
	void setUp() throws Exception {
		viaje = mock(Viaje.class);
		when(viaje.getOrigen()).thenReturn(mock(TerminalPortuaria.class));
		orden = new OrdenImportacion(cliente, cont, cam, chofer, viaje, fact);
		costoLavadoPromedio = 912.18;

		cont = new Container(ancho, largo, altura, peso);
		lavado = new Lavado(cont, costoFijo);
	}

	@Test
	void testSuperaCapacidad() {
		assertTrue(lavado.superaLaCapacidad());
	}

	@Test
	void testMontoTotalSegunCapacidadMenorAPromedio() {
		costoLavadoPromedio = 10000;
		assertTrue(lavado.montoTotal(orden) < costoLavadoPromedio);
	}

	@Test
	void testMontoTotalSegunCapacidadIgualAPromedio() {
		costoLavadoPromedio = 1000;
		assertEquals(lavado.montoTotal(orden), costoLavadoPromedio);
	}

	@Test
	void testMontoTotalSegunCapacidadMayorAPromedio() {
		assertTrue(lavado.montoTotal(orden) > costoLavadoPromedio);
	}

}
