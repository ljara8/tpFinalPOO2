package ar.edu.poo2.tpFinal.CircuitosNaviera;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
	
	public void agregarNuevoViaje(CircuitoMaritimo circuito, Buque buque, LocalDateTime fechaSalida) {
		this.viajes.add(new Viaje(circuito, buque, fechaSalida));
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

	public LocalDateTime proximaFechaDePartidaADestino(TerminalPortuaria origen, TerminalPortuaria destino) throws Exception{
	return this.viajes.stream().filter(v->v.tieneTrayectoEntre(origen, destino))
			.findFirst().get()
			.fechaLlegadaATerminal(destino);
	}
	
	public List<CircuitoMaritimo> circuitosQuePasanPorTerminales(TerminalPortuaria origen, TerminalPortuaria destino) {
		return circuitos.stream().filter(circuito -> circuito.tieneTrayectoEntreTerminales(origen, destino)).toList();
	}
	
}