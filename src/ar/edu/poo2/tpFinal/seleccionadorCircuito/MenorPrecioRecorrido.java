package ar.edu.poo2.tpFinal.seleccionadorCircuito;

public class MenorPrecioRecorrido extends SeleccionadorCircuito {

	@Override
	protected CircuitoMaritimo mejorCircuitoBinario(CircuitoMaritimo primerCircuito, CircuitoMaritimo segundoCircuito) {
		if(primerCircuito.getPrecioTotalRecorrido() < segundoCircuito.getPrecioTotalRecorrido()) {
			return primerCircuito;
		} else {
			return segundoCircuito;
		}
	}

}
