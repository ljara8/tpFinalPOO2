package ar.edu.poo2.tpFinal.CircuitosNaviera;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;

import ar.edu.poo2.tpFinal.Buque;

public class Naviera {
	private HashSet<Buque> buques;
	private HashSet<CircuitoMaritimo> circuitos;
	private HashSet<Viaje> viajes;

	public Naviera() {
		this.buques =  new HashSet<Buque>();
		this.circuitos = new HashSet<CircuitoMaritimo>();
		this.viajes = new HashSet<Viaje>();
	}
	
	public HashSet<Buque> getBuques(){
		return this.buques;
	}
	
	public HashSet<CircuitoMaritimo> getCircuitos(){
		return this.circuitos;
	}
	
	public HashSet<Viaje> getViajes(){
		return this.viajes;
	}
	
	public void agregarViaje(Viaje viaje) {
		this.viajes.add(viaje);
	}
	
	public void agregarCircuito(CircuitoMaritimo circuito) {
		this.circuitos.add(circuito);
	}
	
	public boolean tieneCircuitoConTrayecto(TerminalPortuaria origen, TerminalPortuaria destino) {
		return this.circuitos.stream().anyMatch(c->c.tieneTrayectoEntreTerminales(origen, destino));
	}
	
	public boolean tieneCircuitoConTerminal(TerminalPortuaria terminal) {
		return this.circuitos.stream().anyMatch(c->c.tieneTerminalEnTrayecto(terminal));
	}
	
	public int cuantoTardaEnLlegarNaviera(TerminalPortuaria origen, TerminalPortuaria destino) {
		return this.circuitos.stream().filter(c->c.tieneTrayectoEntreTerminales(origen, destino))
				.mapToInt(c->c.tiempoDeLlegadaEntre(origen, destino)).min()
				.orElseThrow(()-> new NoSuchElementException("No hay trayecto entre estas terminales"));
	}

	public LocalDateTime proximaFechaDePartidaADestino(TerminalPortuaria origen, TerminalPortuaria destino) {
		//devuelve la fecha de salida a una terminal destino, desde una terminal origen
	return this.viajes.stream().filter(v->v.tieneTrayectoEntre(origen, destino))
			.map(v->v.getFechaSalida()).min(LocalDateTime::compareTo)
			.orElseThrow(()-> new NoSuchElementException("No hay trayecto entre estas terminales"));
	}
	
	public LocalDateTime proximaFechaDeLlegadaADestino(TerminalPortuaria origen, TerminalPortuaria destino) {
		//devuelve la fecha de llegada a una terminal destino, desde una terminal origen
		return this.viajes.stream().filter(v->v.tieneTrayectoEntre(origen, destino))
				.map(v->v.fechaLlegadaATerminal(destino)).min(LocalDateTime::compareTo)
				.orElseThrow(()-> new NoSuchElementException("No hay trayecto entre estas terminales"));
	}
	
	public List<CircuitoMaritimo> circuitosQuePasanPorTerminales(TerminalPortuaria origen, TerminalPortuaria destino) {
		return circuitos.stream().filter(circuito -> circuito.tieneTrayectoEntreTerminales(origen, destino)).toList();
	}
}