package ar.edu.poo2.tpFinal;

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
	
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getTiempo() {
		return tiempo;
	}
}
