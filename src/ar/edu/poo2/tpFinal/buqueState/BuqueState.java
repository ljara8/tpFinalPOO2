package ar.edu.poo2.tpFinal.buqueState;

import ar.edu.poo2.tpFinal.Buque;

public interface BuqueState {
	void depart(Buque buque);
	void iniciarTrabajo(Buque buque);
	void actualizarDistanciaDestino(double distancia, Buque buque);
}
