package ar.edu.poo2.tpFinal.CircuitosNaviera;

import java.time.LocalDateTime;

import ar.edu.poo2.tpFinal.Buque;

public class Viaje {
	
	private CircuitoMaritimo circuito;
	private Buque buque;
	private CronogramaViaje cronograma;

	public Viaje(CircuitoMaritimo circuito, Buque buque, LocalDateTime fechaSalida) {
		this.circuito = circuito;
		this.buque = buque;
		this.cronograma = new CronogramaViaje(circuito, fechaSalida);
	}	
	
	public Buque getBuque() {
		return this.buque;
	}
	
	public CircuitoMaritimo getCircuito() {
		return this.circuito;
	}
	
	public CronogramaViaje getCronograma() {
		return this.cronograma;
	}
	
	public LocalDateTime getFechaSalida() {
		return this.cronograma.getFechaSalida();
	}
	
	public LocalDateTime getFechaLlegada() {
		return this.cronograma.getFechaLlegada();
	}
	
	public TerminalPortuaria getOrigen() {
		return this.circuito.getOrigen();
	}
	
	public TerminalPortuaria getDestino() {
		return this.circuito.getDestino();
	}

	public boolean tieneTrayectoEntre(TerminalPortuaria origen, TerminalPortuaria destino) {
		return this.circuito.tieneTrayectoEntreTerminales(origen, destino);
	}
	
	public LocalDateTime fechaLlegadaATerminal(TerminalPortuaria terminal) {
		return this.cronograma.fechaLlegadaATerminal(terminal);
	}
}
