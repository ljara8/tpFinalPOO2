package ar.edu.poo2.tpFinal.CircuitosNaviera;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ar.edu.poo2.tpFinal.Buque;
import ar.edu.poo2.tpFinal.Viaje;

public class Naviera {
	private List<Buque> buques = new ArrayList<Buque>();
	private List<CircuitoMaritimo> circuitos = new ArrayList<CircuitoMaritimo>();
	private List<Viaje> viajes = new ArrayList<Viaje>(); // este no recuerdo si lo ibamos a implementar

	public boolean tieneCircuitoConTerminal(TerminalPortuaria terminal) {
		return this.circuitos.stream().anyMatch(c->c.tieneTerminalEnTrayecto(terminal));
	}
	
	public int cuantoTardaEnLlegarNaviera(TerminalPortuaria origen, TerminalPortuaria destino) throws Exception{
		return this.circuitos.stream().filter(c->c.tieneTrayectoEntreTerminales(origen, destino))
				.findAny().get().tiempoDeLlegadaEntre(origen, destino);
		
		
	}

	/*private void verificarSiHayTrayectoEntreTerminales(TerminalPortuaria origen, TerminalPortuaria destino) throws Exception{
		if(!this.circuitos.stream().anyMatch(c->c.tieneTrayectoEntreTerminales(origen, destino))) {
			throw new Exception("No hay trayecto entre terminales");
		}
		*/
		
		
		
	
	

//	public Date proximaFechaDePartidaParaBuqueADestino(Buque buque, TerminalPortuaria origen, TerminalPortuaria destino)
	//	return 
	

}