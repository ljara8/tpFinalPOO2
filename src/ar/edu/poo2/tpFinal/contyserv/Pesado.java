package ar.edu.poo2.tpFinal.contyserv;

import ar.edu.poo2.tpFinal.Orden;

public class Pesado extends Servicio {
	private double costoFijo;
	private double pesoRegistrado;

	Pesado(Container cont, double costo, int peso) {
		this.costoFijo = costo;
		this.pesoRegistrado = cont.getPeso();
	}

	@Override
	public double montoTotal(Orden orden) {
		return costoFijo;
	}

	public void setPesoRegistrado(int pesoRegistrado) {
		this.pesoRegistrado = pesoRegistrado;
	}

	public double getPesoRegistrado() {
		return pesoRegistrado;
	}

}
