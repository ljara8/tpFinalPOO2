package ar.edu.poo2.tpFinal.buqueState;

import ar.edu.poo2.tpFinal.Buque;

public class Working implements BuqueState{

	@Override
	public void depart(Buque buque) {
		buque.setBuqueState(new Departing());
	}

	@Override
	public void iniciarTrabajo(Buque buque) {
		throw new IllegalStateException("El buque no puede iniciar su trabajo en el estado Working");
	}

	@Override
	public void actualizarDistanciaDestino(double distancia, Buque buque) {}

}
