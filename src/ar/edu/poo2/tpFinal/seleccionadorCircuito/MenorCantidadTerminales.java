package ar.edu.poo2.tpFinal.seleccionadorCircuito;

public class MenorCantidadTerminales extends SeleccionadorCircuito{

	@Override
	public CircuitoMaritimo mejorCircuitoBinario(CircuitoMaritimo primerCircuito, CircuitoMaritimo segundoCircuito) {
		if(primerCircuito.getCantidadTotalTerminales() < segundoCircuito.getCantidadTotalTerminales()) {
			return primerCircuito;
		} else {
			return segundoCircuito;
		}
	}

}
