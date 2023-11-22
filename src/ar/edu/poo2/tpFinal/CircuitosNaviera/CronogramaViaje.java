package ar.edu.poo2.tpFinal.CircuitosNaviera;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.NoSuchElementException;
public class CronogramaViaje {
	
	private LinkedList<Arribo> arribos =  new LinkedList<>();
	private LocalDateTime fechaSalida;
	
	public CronogramaViaje(CircuitoMaritimo circuito, LocalDateTime fechaSalida) {
		this.fechaSalida = fechaSalida;
		this.cronogramaParaViaje(circuito, fechaSalida);

	}
	
	public LocalDateTime getFechaSalida() {
		return this.fechaSalida;
	}
	
	public LocalDateTime getFechaLlegada() {
		return this.arribos.getLast().getFechaDeArribo();
	}
	
	public void cronogramaParaViaje(CircuitoMaritimo circuito, LocalDateTime fechaSalida) {
		LocalDateTime[] fechaParaArribo = {fechaSalida};
	    circuito.getTramos().stream().forEach(t-> {
	        fechaParaArribo[0] = fechaParaArribo[0].plusDays(t.getTiempo()); // Actualización de fechaParaArribo
	        this.arribos.add(new Arribo(t.getDestino(), fechaParaArribo[0]));
	    });
	}


	public LocalDateTime fechaLlegadaATerminal(TerminalPortuaria terminal) {
		return this.arribos.stream().filter(a->a.getDestino().equals(terminal))
				.findFirst().map(a->a.getFechaDeArribo())
				.orElseThrow(()-> new NoSuchElementException("Terminal destino no encontrada"));
	} 


}