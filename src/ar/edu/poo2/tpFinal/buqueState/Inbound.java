package ar.edu.poo2.tpFinal.buqueState;

import ar.edu.poo2.tpFinal.Buque;

public class Inbound implements BuqueState{
	
	public Inbound(Buque buque) {
		buque.notificarSobreLlegadaInminente();
	}

	@Override
	public void depart(Buque buque) {
		throw new IllegalStateException("El buque no puede hacer departing en el estado Inbound");
	}

	@Override
	public void iniciarTrabajo(Buque buque) {
		throw new IllegalStateException("El buque no puede iniciar trabajo en el estado Inbound");
	}

	@Override
	public void actualizarDistanciaDestino(double distancia, Buque buque) {
		if(esDistanciaDeLlegada(distancia)) {
			buque.setBuqueState(new Arrived());
		}
	}

	private boolean esDistanciaDeLlegada(double distancia) {
		return distancia <= 0;
	}
	
}