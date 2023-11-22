package ar.edu.poo2.tpFinal.CircuitosNaviera;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class CronogramaViaje {
	
	private LinkedList<Arribo> arribos =  new LinkedList<>();
	private LocalDateTime fechaSalida;
	
	public CronogramaViaje(CircuitoMaritimo circuito, LocalDateTime fechaSalida2) {
		this.fechaSalida = fechaSalida2;
		this.cronogramaParaViaje(circuito, fechaSalida2);

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


	public LocalDateTime fechaLlegadaATerminal(TerminalPortuaria terminal) throws Exception {
		return this.arribos.stream().filter(a->a.getDestino().equals(terminal))
				.findFirst()
				.map(a->a.getFechaDeArribo()).orElseThrow(() -> new Exception("No se encuentra la terminal solicitada"));
	} 


}
