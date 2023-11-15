package ar.edu.poo2.tpFinal;

public class Tramo {
	
	private double precio;
	private int tiempo;
	private TerminalPortuaria origen;
	private TerminalPortuaria destino;
	
	public Tramo(double precio, int tiempo, TerminalPortuaria origen, TerminalPortuaria destino) {
		this.precio = precio;
		this.tiempo = tiempo;
		this.origen = origen;
		this.destino = destino;
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
	
}
