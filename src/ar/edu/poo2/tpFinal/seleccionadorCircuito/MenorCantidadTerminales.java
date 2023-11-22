package ar.edu.poo2.tpFinal.seleccionadorCircuito;

import ar.edu.poo2.tpFinal.CircuitosNaviera.CircuitoMaritimo;

public class MenorCantidadTerminales extends SeleccionadorCircuito{

	@Override
	protected CircuitoMaritimo mejorCircuitoBinario(CircuitoMaritimo primerCircuito, CircuitoMaritimo segundoCircuito) {
		if(primerCircuito.getCantidadTotalTerminales() < segundoCircuito.getCantidadTotalTerminales()) {
			return primerCircuito;
		} else {
			return segundoCircuito;
		}
	}

}