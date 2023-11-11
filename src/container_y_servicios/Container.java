package container_y_servicios;

public class Container {
	private int ancho;
	private int largo;
	private int altura;
	private double peso;

	public Container(int a, int l, int alt, double p) {
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

	public int getVolumen() {
		return this.getAltura() * this.getAncho() * this.getLargo();
	}
	
	


}
