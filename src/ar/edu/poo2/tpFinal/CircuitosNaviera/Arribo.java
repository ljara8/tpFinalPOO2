package ar.edu.poo2.tpFinal.CircuitosNaviera;

import java.time.LocalDateTime;

public class Arribo {
	
	private TerminalPortuaria destino;
	private LocalDateTime fechaDeArribo;
	
	public Arribo(TerminalPortuaria terminal, LocalDateTime fecha) {
		this.destino = terminal;
		this.fechaDeArribo = fecha;
	}

	public TerminalPortuaria getDestino() {
		return this.destino;
	}

	public LocalDateTime getFechaDeArribo() {
		return this.fechaDeArribo;
	}

}
