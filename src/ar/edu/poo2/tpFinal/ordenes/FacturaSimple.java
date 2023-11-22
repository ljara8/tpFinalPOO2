package ar.edu.poo2.tpFinal.ordenes;

public class FacturaSimple implements Factura {
	private Orden orden;

	FacturaSimple(Orden orden) {
		this.orden = orden;
	}

	public Orden getOrden() {
		return orden;
	}

	@Override
	public double getMontoTotalFacturado(Orden orden) throws Exception {
		return orden.getServiciosContratados().stream().mapToDouble(s -> s.montoTotal(orden)).sum();
	}
}