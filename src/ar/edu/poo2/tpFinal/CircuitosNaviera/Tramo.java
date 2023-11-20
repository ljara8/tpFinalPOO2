package ar.edu.poo2.tpFinal.CircuitosNaviera;

public class Tramo {
	
	private TerminalPortuaria origen;
	private TerminalPortuaria destino;
	private double precio;
	private int tiempo;
	
	
	public Tramo(TerminalPortuaria origen, TerminalPortuaria destino, double precio, int tiempo) {
		this.origen = origen;
		this.destino = destino;
		this.precio = precio;
		this.tiempo = tiempo;
	}

	public TerminalPortuaria getOrigen() {
		return origen;
	}

	public TerminalPortuaria getDestino() {
		return destino;
	}

	public double getPrecio() {
		return precio;
	}

	public int getTiempo() {
		return tiempo;
	}
	
	public boolean tieneTerminal(TerminalPortuaria terminal) {
		return origen == terminal || destino == terminal;
	}
}
