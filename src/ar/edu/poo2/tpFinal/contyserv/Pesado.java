package ar.edu.poo2.tpFinal.contyserv;

import ar.edu.poo2.tpFinal.ordenes.Orden;

public class Pesado extends Servicio {
	private Container cont;
	private double costoFijo;
	private double pesoRegistrado;

	public Pesado(Container cont, double costo) {
		this.cont = cont;
		this.costoFijo = costo;
	}

	@Override
	public double montoTotal(Orden orden) {
		return costoFijo;
	}

	public void setPesoRegistrado(double pesoRegistrado) {
		this.pesoRegistrado = pesoRegistrado;
	}

	public double getPesoRegistrado() {
		return pesoRegistrado;
	}

}