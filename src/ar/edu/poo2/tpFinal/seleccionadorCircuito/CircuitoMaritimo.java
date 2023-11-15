package ar.edu.poo2.tpFinal.seleccionadorCircuito;

import java.util.LinkedList;

import ar.edu.poo2.tpFinal.TerminalPortuaria;
import ar.edu.poo2.tpFinal.Tramo;

public class CircuitoMaritimo {
	
	private LinkedList<Tramo> tramos;
	
	public CircuitoMaritimo() {
		this.tramos = new LinkedList<>();
	}
	
	public TerminalPortuaria getOrigen() {
		Tramo tramoOrigen = tramos.getFirst();
		return tramoOrigen.getOrigen();
	}
	
	public TerminalPortuaria getDestino() {
		Tramo tramoDestino = tramos.getLast();
		return tramoDestino.getDestino();
	}
	
	public int getTiempoTotalRecorrido() {
		return tramos.stream().mapToInt(tramo -> tramo.getTiempo()).sum();
	}
	
	public double getPrecioTotalRecorrido() {
		return tramos.stream().mapToDouble(tramo -> tramo.getPrecio()).sum();
	}

	public int getCantidadTotalTerminales() {
		// La cantidad de terminales es igual a la cantidad de tramos + 1
		// ya que por cada par de tramos, se repiten 2 terminales y dos son diferentes
		// Lo mismo se cumple al haber un solo tramo.
		return tramos.size() + 1;
	}
	
}
