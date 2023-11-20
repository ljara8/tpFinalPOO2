package ar.edu.poo2.tpFinal.ordenes;

public class FacturaSimple implements Factura {
	private Orden orden;

	FacturaSimple(Orden orden) {
		this.orden = orden;
	}

	public Orden getOrden() {
		return orden;
	}

	public Desglose getDesglose(Orden orden) {
		return orden.getDesglose();
	}

	@Override
	public double getMontoTotalFacturado(Orden orden) {
		return orden.getServiciosContratados()
				.stream()
				.mapToDouble(s-> s.montoTotal(orden))
				.sum();
	}
}
