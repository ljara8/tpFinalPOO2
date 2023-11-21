package ar.edu.poo2.tpFinal.CircuitosNaviera;

import java.util.LinkedList;

public class CircuitoMaritimo {

	private LinkedList<Tramo> tramos = new LinkedList<>();

	public CircuitoMaritimo(TerminalPortuaria origen, TerminalPortuaria destino, double precio, int tiempo) {
		// cuando se crea un nuevo circuito se inicializa con un tramo origen
		this.tramos.add(new Tramo(origen, destino, precio, tiempo));
	}

	public LinkedList<Tramo> getTramos() {
		return this.tramos;
	}

	public TerminalPortuaria getOrigen() {
		return tramos.getFirst().getOrigen();
	}

	public TerminalPortuaria getDestino() {
		return tramos.getLast().getDestino();
	}

	public void agregarTramoHacia(TerminalPortuaria destino, double precio, int tiempo) {
		// el circuito no debe estar vacio previamente
		this.tramos.add(new Tramo(this.getDestino(), destino, precio, tiempo));
	}

	public int getTiempoTotalRecorrido() {
		return tramos.stream().mapToInt(tramo -> tramo.getTiempo()).sum();
	}

	public double getPrecioTotalRecorrido() {
		return tramos.stream().mapToDouble(tramo -> tramo.getPrecio()).sum();
	}

	public int getCantidadTotalTerminales() {
		// La cantidad de terminales es igual a la cantidad de tramos + 1
		// ya que por cada par de tramos, se repiten 2 terminales y dos son diferentes
		// Lo mismo se cumple al haber un solo tramo.
		return tramos.size() + 1;
	}

	public boolean tieneTerminalEnTrayecto(TerminalPortuaria terminal) {
		return tramos.stream().anyMatch(t -> t.tieneTerminal(terminal));
	}

	public boolean tieneTrayectoEntreTerminales(TerminalPortuaria origen, TerminalPortuaria destino) {
		return this.tramos.stream().dropWhile(t -> !t.getOrigen().equals(origen))
				.anyMatch(t -> t.getDestino().equals(destino));
	}

	public int tiempoDeLlegadaEntre(TerminalPortuaria origen, TerminalPortuaria destino) {
		if (this.tieneTrayectoEntreTerminales(origen, destino)) {
			return tramos.stream().dropWhile(t -> !t.getOrigen().equals(origen))
					.takeWhile(t -> !t.getOrigen().equals(destino)).mapToInt(t -> t.getTiempo()).sum();
		} else
			throw new Exception("No hay trayecto entre estas terminales");
	}

}
