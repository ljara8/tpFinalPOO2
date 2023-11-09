package ar.edu.poo2.tpFinal;

import java.util.LinkedList;
import java.util.List;

public class CircuitoMaritimo {
	
	private List<Tramo> tramos = new LinkedList<Tramo>();
	
	public TerminalPortuaria getOrigen() throws Exception {
		if (!tramos.isEmpty()) {
			return tramos.get(0).getOrigen();
		}
		else throw new Exception ("no hay tramos en el circuito");
	}
	
	public TerminalPortuaria getDestino() throws Exception {
		if (!tramos.isEmpty()) {
			return tramos.get(tramos.size() -1).getDestino();
		}
		else throw new Exception ("no hay tramos en el circuito");
	}
	
	public void agregarTramoHaciaTerminal(TerminalPortuaria destino, double precio, int tiempo) throws Exception {
		this.tramos.add(new Tramo(this.getDestino(), destino, precio, tiempo));
	}
	
}
