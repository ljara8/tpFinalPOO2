package ar.edu.poo2.tpFinal.contyserv;

import ar.edu.poo2.tpFinal.ordenes.Orden;

public class Excedente extends Servicio {

	private double costoPorExcedente;
	private Container cont;
	
	Excedente(double costoExceso, Container cont){
		this.costoPorExcedente = costoExceso;
		this.cont = cont;
	}

	@Override
	public double montoTotal(Orden orden) {
		return this.getCostoPorExcedente() * orden.getHorasDeDemora();
	}

	public double getCostoPorExcedente() {
		return costoPorExcedente;
	}

}
