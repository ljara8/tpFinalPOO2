package ar.edu.poo2.tpFinal.seleccionadorCircuito;

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
