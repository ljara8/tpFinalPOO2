package ar.edu.poo2.tpFinal.CircuitosNaviera;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class CronogramaViaje {
	
	private LinkedList<Arribo> arribos =  new LinkedList<>();
	private LocalDate fechaSalida;
	
	public CronogramaViaje(CircuitoMaritimo circuito, LocalDate fechaSalida) {
		this.fechaSalida = fechaSalida;
		this.cronogramaParaViaje(circuito, fechaSalida);

	}
	
	public LocalDate getFechaSalida() {
		return this.fechaSalida;
	}
	
	public LocalDate getFechaLlegada() {
		return this.arribos.getLast().getFechaDeArribo();
	}
	
	public void cronogramaParaViaje(CircuitoMaritimo circuito, LocalDate fechaSalida) {
	    LocalDate[] fechaParaArribo = {fechaSalida};
	    circuito.getTramos().stream().forEach(t-> {
	        fechaParaArribo[0] = fechaParaArribo[0].plusDays(t.getTiempo()); // Actualización de fechaParaArribo
	        this.arribos.add(new Arribo(t.getDestino(), fechaParaArribo[0]));
	    });
	}


	public LocalDate fechaLlegadaATerminal(TerminalPortuaria terminal) throws Exception {
		return this.arribos.stream().filter(a->a.getDestino().equals(terminal))
				.findFirst()
				.map(a->a.getFechaDeArribo())
				.orElseThrow(() -> new NoSuchElementException("No se encuentra la terminal solicitada"));
	} 


}
