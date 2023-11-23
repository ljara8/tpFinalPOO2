package ar.edu.poo2.tpFinal.contyserv;

import ar.edu.poo2.tpFinal.ordenes.Orden;

public class Electricidad extends Servicio {

	private Refeer refe;
	private int precioFijo;

	public Electricidad(Refeer refeer, int precio) {
		this.refe = refeer;
		this.precioFijo = precio;
	}

	@Override
	public double montoTotal(Orden orden) {
		return orden.getTiempoConexion(refe) * this.getCantidadKwConsumido();
	}

	public double getCantidadKwConsumido() {
		return this.refe.getKwPorHora() * precioFijo;
	}

}