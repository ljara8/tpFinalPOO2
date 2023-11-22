package ar.edu.poo2.tpFinal.buqueState;

import ar.edu.poo2.tpFinal.Buque;

public class Outbound implements BuqueState{

	@Override
	public void depart(Buque buque) {
		throw new IllegalStateException("El buque no puede hacer departing en el estado Outbound");
	}

	@Override
	public void iniciarTrabajo(Buque buque) {
		throw new IllegalStateException("El buque no puede iniciar su trabajo en el estado Outbound");
	}

	@Override
	public void actualizarDistanciaDestino(double distancia, Buque buque) {
		if(esDistanciaCercana(distancia)) {
			buque.setBuqueState(new Inbound(buque));
		}
	}
	
	private boolean esDistanciaCercana(double distancia) {
		return distancia < 50F;
	}

}
