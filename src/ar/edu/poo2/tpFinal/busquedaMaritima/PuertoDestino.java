package ar.edu.poo2.tpFinal.busquedaMaritima;

import ar.edu.poo2.tpFinal.CircuitosNaviera.TerminalPortuaria;
import ar.edu.poo2.tpFinal.CircuitosNaviera.Viaje;

public class PuertoDestino implements BusquedaMaritima{

	private TerminalPortuaria destino;
	
	public PuertoDestino(TerminalPortuaria destino) {
		this.destino = destino;
	}

	@Override
	public boolean evaluar(Viaje viaje) {
		return viaje.getDestino() == destino;
	}

}