package ar.edu.poo2.tpFinal.contyserv;

public class Container {
	private int ancho;
	private int largo;
	private int altura;
	private double peso;

	public Container(int a, int l, int alt, double p) {
		this.ancho = a;
		this.largo = l;
		this.altura = alt;
		this.peso = p;
	}

	public double getPeso() {
		return peso;
	}


	public int getAltura() {
		return altura;
	}


	public int getLargo() {
		return largo;
	}


	public int getAncho() {
		return ancho;
	}

	public int calcularVolumen() {
		return this.getAltura() * this.getAncho() * this.getLargo();
	}
	
	


}
