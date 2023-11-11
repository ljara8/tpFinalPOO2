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

class TestContainerDry {
	private Dry containerDry;

	@BeforeEach
	void setUp() throws Exception {
		containerDry = new Dry(10, 20, 30, 40);
	}

	@Test
	void testVolumenContainerIgualA70() {

		assertEquals(containerDry.calcularVolumen(), 50);

	}

	@Test
	void testVolumenContainerMayorA70() { // configuration

		assertFalse(containerDry.calcularVolumen() < 50);

	}

}
