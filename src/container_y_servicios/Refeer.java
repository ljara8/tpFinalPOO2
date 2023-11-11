package container_y_servicios;

public class Refeer extends Container{
	public Refeer(int a, int l, int alt, double p, double kw) {
		super(a, l, alt, p);
		this.kwPorHora = kw;
	}

	public double getKwPorHora() {
		return kwPorHora;
	}

	private double kwPorHora;
	
	

}
