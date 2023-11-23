package ar.edu.poo2.tpFinal.buqueState;

import ar.edu.poo2.tpFinal.Buque;

public class Departing implements BuqueState{

	@Override
	public void depart(Buque buque) {
		throw new IllegalStateException("El buque no puede hacer departing en el estado Departing");
	}

	@Override
	public void iniciarTrabajo(Buque buque) {
		throw new IllegalStateException("El buque no puede iniciar trabajo en el estado Departing");		
	}

	@Override
	public void actualizarDistanciaDestino(double distancia, Buque buque) {
		if(esDistanciaAlejadaDeTerminal(distancia)) {
			buque.setBuqueState(new Outbound());
			buque.notificarPartidaDeTerminal();
		}
	}
	
	private boolean esDistanciaAlejadaDeTerminal(double distancia) {
		return distancia >= 1;
	}
}