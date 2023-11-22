package ar.edu.poo2.tpFinal.buqueState;

import ar.edu.poo2.tpFinal.Buque;

public class Arrived implements BuqueState{

	@Override
	public void depart(Buque buque) {
		throw new IllegalStateException("El buque no puede hacer departing en el estado Arrived");
	}

	@Override
	public void iniciarTrabajo(Buque buque) {
		buque.setBuqueState(new Working());
	}

	@Override
	public void actualizarDistanciaDestino(double distancia, Buque buque) {}

}
