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
import ar.edu.poo2.tpFinal.contyserv.Electricidad;
import ar.edu.poo2.tpFinal.contyserv.Refeer;
import ar.edu.poo2.tpFinal.ordenes.FacturaResponsableViaje;
import ar.edu.poo2.tpFinal.ordenes.Orden;
import ar.edu.poo2.tpFinal.ordenes.OrdenImportacion;

class TestServicioElectricidad {

	private double montoTotalPromedio = 1030.5;
	private double cantidadKwConsumidoPromedio = 40.13;
	private int precio = 5000;

	private int ancho = 50;
	private int largo = 20;
	private int altura = 30;
	private double peso = 100;
	private double consumoKwPromedio = 300;

	private Consignee cliente;
	private Container cont;
	private Camion cam;
	private Chofer chofer;
	private Viaje viaje;
	private FacturaResponsableViaje fact;

	private Orden orden;

	private Electricidad electricidad;
	private Refeer refeer;

	@BeforeEach
	void setUp() throws Exception {

		orden = new OrdenImportacion(cliente, cont, cam, chofer, viaje, fact);
		refeer = new Refeer(ancho, largo, altura, peso, consumoKwPromedio);
		fact = new FacturaResponsableViaje(orden);
		electricidad = new Electricidad(refeer, precio);
	}

	@Test
	void testMontoTotalConsumidoMenorPromedio() {

		assertTrue(electricidad.montoTotal(orden) < montoTotalPromedio);

	}

	@Test
	void testMontoTotalConsumidoIgualAPromedio() {
		montoTotalPromedio = 0;
		assertTrue(electricidad.montoTotal(orden) == montoTotalPromedio);
	}

	@Test
	void testKwConsumidoMenorAPromedio() {
		cantidadKwConsumidoPromedio = 15000001;
		assertTrue(electricidad.getCantidadKwConsumido() < cantidadKwConsumidoPromedio);
	}

	@Test
	void testKwConsumidoMayorAPromedio() {
		assertTrue(electricidad.getCantidadKwConsumido() > cantidadKwConsumidoPromedio);
	}

	@Test
	void testKwConsumidoIgualAPromedio() {
		cantidadKwConsumidoPromedio = 1500000;
		assertTrue(electricidad.getCantidadKwConsumido() == cantidadKwConsumidoPromedio);
	}

}
