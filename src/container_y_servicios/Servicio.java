package container_y_servicios;

import ar.edu.poo2.tpFinal.Orden;

public abstract class Servicio {

	private Container container;

	public abstract double montoTotal(Orden orden);

	public Container getContainer() {
		return container;
	}

}
