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

import ar.edu.poo2.tpFinal.contyserv.Refeer;

class TestContainerRefeer {
	@Mock
	private Refeer containerRefeer;
	private int ancho = 50;
	private int largo = 20;
	private int altura = 30;
	private double peso = 100;
	private int volumenPromedio;
	private double consumoKwPromedio = 300;

	@BeforeEach
	void setUp() throws Exception {
		containerRefeer = new Refeer(altura, altura, altura, peso, consumoKwPromedio);
		volumenPromedio = 27000;
		consumoKwPromedio = 500;

	}

	@Test
	void testVolumenContainerMenorAPromedio() {
		altura = 10;
		ancho = 20;
		largo = 30;

		assertFalse(containerRefeer.calcularVolumen() < volumenPromedio);

	}

	@Test
	void testVolumenContainerIgualAPromedio() {

		assertEquals(containerRefeer.calcularVolumen(), volumenPromedio);

	}

	@Test
	void testVolumenContainerIgualrAPromedio() {

		assertEquals(containerRefeer.calcularVolumen(), volumenPromedio);

	}

	@Test
	void testKwPorHoraMenorAPromedio() {

		assertNotEquals(containerRefeer.getKwPorHora(), consumoKwPromedio);
	}

}
