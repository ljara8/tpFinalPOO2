package ar.edu.poo2.tpFinal.contyserv;

import ar.edu.poo2.tpFinal.ordenes.Orden;

public abstract class Servicio {

	private Container container;

	public abstract double montoTotal(Orden orden);

	public Container getContainer() {
		return container;
	}

}