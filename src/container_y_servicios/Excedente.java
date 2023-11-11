package container_y_servicios;

import ar.edu.poo2.tpFinal.Orden;

public class Excedente extends Servicio {

	private double costoPorExcedente;

	@Override
	public double montoTotal(Orden orden) {
		return 0;
	}

}
