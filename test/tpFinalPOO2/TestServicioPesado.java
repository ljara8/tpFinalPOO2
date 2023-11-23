package tpFinalPOO2;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.poo2.tpFinal.Camion;
import ar.edu.poo2.tpFinal.Chofer;
import ar.edu.poo2.tpFinal.CircuitosNaviera.Viaje;
import ar.edu.poo2.tpFinal.clientes.Consignee;
import ar.edu.poo2.tpFinal.contyserv.Container;
import ar.edu.poo2.tpFinal.contyserv.Pesado;
import ar.edu.poo2.tpFinal.ordenes.FacturaResponsableViaje;
import ar.edu.poo2.tpFinal.ordenes.Orden;
import ar.edu.poo2.tpFinal.ordenes.OrdenImportacion;

class TestServicioPesado {
	private OrdenImportacion orden;
	private double costoFijo = 1000;

	private Consignee cliente;

	private Camion cam;
	private Chofer chofer;
	private Viaje viaje;
	private FacturaResponsableViaje fact;
	private int ancho = 50;
	private int largo = 20;
	private int altura = 30;
	private double peso = 5013.5;
	private Container cont;
	private double pesoPromedio;

	private Pesado pesado;

	@BeforeEach
	void setUp() throws Exception {

		orden = new OrdenImportacion(cliente, cont, cam, chofer, viaje, fact);
		cont = new Container(ancho, largo, altura, peso);
		pesoPromedio = 1003;

		pesado = new Pesado(cont, costoFijo);
	}

	@Test
	void testPesoMenorAlPromedio() {
		assertTrue(pesado.getPesoRegistrado() < pesoPromedio);
	}

	@Test
	void testPesoIgualAlPromedio() {
		pesoPromedio = 5013.5;
		pesado.setPesoRegistrado(cont.getPeso());

		assertEquals(pesado.getPesoRegistrado(), pesoPromedio);
	}

	@Test
	void testPesoMayorAlPromedio() {

		pesado.setPesoRegistrado(cont.getPeso());
		pesoPromedio = 5013.5;

		assertEquals(pesado.getPesoRegistrado(), pesoPromedio);
	}

}
