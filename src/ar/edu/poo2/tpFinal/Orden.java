package ar.edu.poo2.tpFinal;

import container_y_servicios.Container;
import container_y_servicios.Refeer;

public abstract class Orden {
	private Container cont;

	public double getTiempoConexion(Refeer refri) {
		return 0;
	}

	public Object getContainer() {
		return cont;
	}

}
