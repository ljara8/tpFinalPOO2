package ar.edu.poo2.tpFinal.CircuitosNaviera;

import java.time.LocalDate;

public class Arribo {
	
	private TerminalPortuaria destino;
	private LocalDate fechaDeArribo;
	
	public Arribo(TerminalPortuaria terminal, LocalDate fecha) {
		this.destino = terminal;
		this.fechaDeArribo = fecha;
	}

	public TerminalPortuaria getDestino() {
		return this.destino;
	}

	public LocalDate getFechaDeArribo() {
		return this.fechaDeArribo;
	}

}
