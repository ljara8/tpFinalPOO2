package ar.edu.poo2.tpFinal.contyserv;

import ar.edu.poo2.tpFinal.ordenes.Orden;

public class Lavado extends Servicio {
	private double costoFijo;

	@Override
	public double montoTotal(Orden orden) {
		double monto = costoFijo;
		if (this.superaLaCapacidad()) {
			monto += 1000;
		}
		return monto;
	}

	public boolean superaLaCapacidad() {
		return this.getContainer().calcularVolumen() >= 70;
	}

}
