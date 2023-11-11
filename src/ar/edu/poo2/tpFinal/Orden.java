package ar.edu.poo2.tpFinal;

import ar.edu.poo2.tpFinal.contyserv.Container;
import ar.edu.poo2.tpFinal.contyserv.Refeer;

public abstract class Orden {
	private Container cont;

	public double getTiempoConexion(Refeer refri) {
		return 0;
	}

	public Object getContainer() {
		return cont;
	}

}
