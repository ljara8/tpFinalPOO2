package ar.edu.poo2.tpFinal.GPS;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class testGPSImpl {
	private GPSImpl gps;
	private GPSImpl gps2;
	private List<GPSImpl> gpsObs = new ArrayList<GPSImpl>();
	private Localizable localizable;
	private Localizable localizable2;
	private double distanciaDestino = 5003.3;
	private List<Localizable> localizables = new ArrayList<Localizable>();
	private List<Localizable> localizables2 = new ArrayList<Localizable>();

	@BeforeEach
	void setUp() throws Exception {
		gps = new GPSImpl(localizables);
		gps2 = new GPSImpl(localizables2);
		gpsObs.add(gps);
		gpsObs.add(gps2);
		localizable = mock(Localizable.class);
		localizable2 = mock(Localizable.class);
		gps.agregarLocalizable(localizable);
		gps.agregarLocalizable(localizable2);

	}

	@Test
	void testgetLocalizableVacia() {
		assertEquals(gps2.getLocalizables(), localizables2);
	}

	@Test
	void testgetLocalizable() {

		assertFalse(gps.getLocalizables().isEmpty());
	}

	@Test
	void testActualizarDistancia() {
		gps.actualizarDistanciaDestino(distanciaDestino);

		distanciaDestino = distanciaDestino - 300;

		gps2.actualizarDistanciaDestino(distanciaDestino);

	}

}
