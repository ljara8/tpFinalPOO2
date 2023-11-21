package ar.edu.poo2.tpFinal.CircuitosNaviera;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import ar.edu.poo2.tpFinal.Buque;

public class Naviera {
	private List<Buque> buques;
	private List<CircuitoMaritimo> circuitos;
	private List<Viaje> viajes;

	public Naviera() {
		this.buques =  new ArrayList<Buque>();
		this.circuitos = new ArrayList<CircuitoMaritimo>();
		this.viajes = new ArrayList<Viaje>();
	}
	
	public List<Buque> getBuques(){
		return this.buques;
	}
	
	public List<CircuitoMaritimo> getCircuitos(){
		return this.circuitos;
	}
	
	public List<Viaje> getViajes(){
		return this.viajes;
	}
	
	public void agregarViaje(Viaje viaje) {
		this.viajes.add(viaje);
	}
	
	public void agregarCircuito(CircuitoMaritimo circuito) {
		this.circuitos.add(circuito);
	}
	
	public boolean tieneCircuitoConTerminal(TerminalPortuaria terminal) {
		return this.circuitos.stream().anyMatch(c->c.tieneTerminalEnTrayecto(terminal));
	}
	
	public int cuantoTardaEnLlegarNaviera(TerminalPortuaria origen, TerminalPortuaria destino) throws Exception{
		return this.circuitos.stream().filter(c->c.tieneTrayectoEntreTerminales(origen, destino))
				.findFirst().get()
				.tiempoDeLlegadaEntre(origen, destino);
	}

	public LocalDate proximaFechaDePartidaADestino(TerminalPortuaria origen, TerminalPortuaria destino) throws Exception {
		//devuelve la fecha de salida a una terminal destino, desde una terminal origen
	return this.viajes.stream().filter(v->v.tieneTrayectoEntre(origen, destino))
			.findFirst().map(v->v.getFechaSalida())
			.orElseThrow(() -> new NoSuchElementException("No se encuentra la terminal solicitada"));
	}
	
	public LocalDate proximaFechaDeLlegadaADestino(TerminalPortuaria origen, TerminalPortuaria destino) throws Exception {
		//devuelve la fecha de llegada a una terminal destino, desde una terminal origen
		return this.viajes.stream().filter(v->v.tieneTrayectoEntre(origen, destino))
				.findFirst().get().fechaLlegadaATerminal(destino);
	}
}