package tpFinalPOO2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import ar.edu.poo2.tpFinal.contyserv.Dry;
import ar.edu.poo2.tpFinal.contyserv.Tanque;

class TestContainerTanque {
	private Tanque containerTanque;
	private int ancho = 50;
	private int largo = 20;
	private int altura = 30;
	private double peso = 100;
	private int volumenPromedio;

	@BeforeEach
	void setUp() throws Exception {
		containerTanque = new Tanque(ancho, largo, altura, peso);
		volumenPromedio = 30000;

	}

	@Test
	void testVolumenContainerMenorAPromedio() {
		altura = 10;
		ancho = 20;
		largo = 30;

		assertFalse(containerTanque.calcularVolumen() < volumenPromedio);

	}

	@Test
	void testVolumenContainerIgualAPromedio() {
		int volumen = containerTanque.calcularVolumen();

		assertEquals(volumen, volumenPromedio);

	}
}