package ar.edu.poo2.tpFinal.seleccionadorCircuito;

public class MenorTiempoTotalRecorrido extends SeleccionadorCircuito{

	@Override
	protected CircuitoMaritimo mejorCircuitoBinario(CircuitoMaritimo primerCircuito, CircuitoMaritimo segundoCircuito) {
		if(primerCircuito.getTiempoTotalRecorrido() < segundoCircuito.getTiempoTotalRecorrido()) {
			return primerCircuito;
		} else {
			return segundoCircuito;
		}
	}
	
}
