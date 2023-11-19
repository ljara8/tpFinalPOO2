package ar.edu.poo2.tpFinal.contyserv;

public class Refeer extends Container {
	private double kwPorHora;

	public Refeer(int a, int l, int alt, double p, double kw) {
		super(a, l, alt, p);
		this.kwPorHora = kw;
	}

	public double getKwPorHora() {
		return kwPorHora;
	}

}
