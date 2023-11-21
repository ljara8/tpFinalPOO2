package ar.edu.poo2.tpFinal.seleccionadorCircuito;

import java.util.List;

import ar.edu.poo2.tpFinal.CircuitosNaviera.CircuitoMaritimo;

public abstract class SeleccionadorCircuito {
	public CircuitoMaritimo mejorCircuitoEntre(List<CircuitoMaritimo> circuitos) {
		return circuitos.stream()
				.reduce(this::mejorCircuitoBinario)
				.orElseThrow(() -> new IllegalArgumentException("La lista de circuitos no debe ser vacía."));
	}
	
	protected abstract CircuitoMaritimo mejorCircuitoBinario(CircuitoMaritimo primerCircuito, CircuitoMaritimo segundoCircuito);
}
