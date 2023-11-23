package tpFinalPOO2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import ar.edu.poo2.tpFinal.contyserv.Dry;

class TestContainerDry {
	private Dry containerDry;
	private int ancho = 50;
	private int largo = 20;
	private int altura = 30;
	private double peso = 100;
	private int volumenPromedio;

	@BeforeEach
	void setUp() throws Exception {
		containerDry = new Dry(ancho, largo, altura, peso);
		volumenPromedio = 30000;

	}

	@Test
	void testVolumenContainerMenorAPromedio() {
		altura = 10;
		ancho = 20;
		largo = 30;

		assertFalse(containerDry.calcularVolumen() < volumenPromedio);

	}

	@Test
	void testVolumenContainerIgualAPromedio() {
		int volumen = containerDry.calcularVolumen();

		assertEquals(volumen, volumenPromedio);

	}

}